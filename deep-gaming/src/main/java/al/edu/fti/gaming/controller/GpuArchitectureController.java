package al.edu.fti.gaming.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.dto.CpuArchitectureDTO;
import al.edu.fti.gaming.dto.GpuArchitectureDTO;
import al.edu.fti.gaming.exception.CpuArchitectureNotFoundException;
import al.edu.fti.gaming.exception.GpuArchitectureNotFoundException;
import al.edu.fti.gaming.exception.NoCpuArchitecturesFoundForCompanyException;
import al.edu.fti.gaming.exception.NoGpuArchitecturesFoundForCompanyException;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.GpuArchitectureService;
import al.edu.fti.gaming.utils.CompanyEditor;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping(value = "/gpuArchitecture")
@SessionAttributes("allCompanies")
public class GpuArchitectureController implements HandlerExceptionResolver{

	@Autowired
	private GpuArchitectureService gpuArchitectureService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private GeneralService generalService;

	@Autowired
	private CompanyEditor editor;

	@Autowired
	private Messages messages;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(CompanyDTO.class, this.editor);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		GpuArchitectureDTO gpuArchitectureDTO = new GpuArchitectureDTO();
		model.addAttribute("newGpuArchitecture", gpuArchitectureDTO);
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());
		return "gpuArchitecture/addGpuArchitecture";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newGpuArchitecture") @Valid GpuArchitectureDTO gpuArchitectureDTO,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "gpuArchitecture/addGpuArchitecture";
		}
		if (gpuArchitectureService.add(gpuArchitectureDTO) != 0) {
			generalService.imageProcessing(gpuArchitectureDTO,
					request.getSession().getServletContext().getRealPath("/"), true);
			return "redirect:/gpuArchitecture/gpuArchitectures";
		} else {
			return "redirect:/gpuArchitecture/add?error";
		}
	}
	
	@RequestMapping(value = "/gpuArchitectures")
	public String list(Model model) {
		model.addAttribute("gpuArchitectures", gpuArchitectureService.getAllGpuArchitectures());
		List<CompanyDTO> companiesThatHaveGpuArchitectures = companyService.getAllCompaniesThatHaveGpuArchitectures();
		model.addAttribute("companies", companiesThatHaveGpuArchitectures);
		return "gpuArchitecture/gpuArchitectures";
	}
	
	@RequestMapping(value = "/gpuArchitectures/{company}")
	public String listByCompany(Model model, @PathVariable("company") String company) {
		List<GpuArchitectureDTO> gpuArchitectures = gpuArchitectureService.getGpuArchitecturesByCompany(company);
		model.addAttribute("gpuArchitectures", gpuArchitectures);
		return "gpuArchitecture/gpuArchitectures";
	}
	
	@RequestMapping("/details")
	public String details(@RequestParam("id") int gpuArchitectureId, Model model) {
		GpuArchitectureDTO gpuArchitectureDTO = gpuArchitectureService.getGpuArchitectureById(gpuArchitectureId);
		model.addAttribute("gpuArchitecture", gpuArchitectureDTO);
		return "gpuArchitecture/details";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") int gpuArchitectureId, Model model) {
		model.addAttribute("gpuArchitecture", gpuArchitectureService.getGpuArchitectureById(gpuArchitectureId));
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());
		return "/gpuArchitecture/updateGpuArchitecture";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processUpdateForm(@ModelAttribute("gpuArchitecture") @Valid GpuArchitectureDTO gpuArchitectureDTO,
			BindingResult result, HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), gpuArchitectureDTO.getImage(),
				messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "gpuArchitecture/updateGpuArchitecture";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(gpuArchitectureDTO,
						request.getSession().getServletContext().getRealPath("/"), false);
			}
			boolean updatedOrNot = gpuArchitectureService.update(gpuArchitectureDTO);
			if (updatedOrNot == true) {
				return "redirect:/gpuArchitecture/details?id=" + gpuArchitectureDTO.getId();
			} else {
				return "redirect:/gpuArchitecture/update?id=" + gpuArchitectureDTO.getId() + "?error";
			}
		}
	}
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (ex instanceof MaxUploadSizeExceededException) {
			model.put("errors", messages.get("add.form.image.error.size.afterSubmit"));
			return new ModelAndView("error", model);
		} else {
			model.put("error", messages.get("error.genericError"));
			model.put("sorry", messages.get("error.genericError.sorry"));
			return new ModelAndView("error", model);
		}
	}
	
	@ExceptionHandler(NoGpuArchitecturesFoundForCompanyException.class)
	public String handleNoGpuArchitectureFoundForCompany(Model model, HttpServletRequest req, NoGpuArchitecturesFoundForCompanyException exception) {
		return "gpuArchitecture/NoGpuArchitectureForCompany";

	}

	@ExceptionHandler(GpuArchitectureNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, GpuArchitectureNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/gpuArchitecture/gpuArchitectureNotFound");
		String id = queryString.substring(3);
		mav.addObject("id", id);
		return mav;

	}

}
