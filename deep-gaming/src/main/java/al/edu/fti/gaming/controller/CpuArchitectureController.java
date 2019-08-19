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

import al.edu.fti.gaming.exception.CpuArchitectureNotFoundException;
import al.edu.fti.gaming.exception.NoCpuArchitecturesFoundForCompanyException;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.service.CpuArchitectureService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.utils.CompanyEditor;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping(value = "/cpuArchitecture")
@SessionAttributes("allCompanies")
public class CpuArchitectureController implements HandlerExceptionResolver {

	@Autowired
	private CpuArchitectureService cpuArchitectureService;

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
		CpuArchitectureDTO cpuArchitectureDTO = new CpuArchitectureDTO();
		model.addAttribute("newCpuArchitecture", cpuArchitectureDTO);
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());
		return "cpuArchitecture/addCpuArchitecture";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newCpuArchitecture") @Valid CpuArchitectureDTO cpuArchitectureDTO,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "cpuArchitecture/addCpuArchitecture";
		}
		if (cpuArchitectureService.add(cpuArchitectureDTO) != 0) {
			generalService.imageProcessing(cpuArchitectureDTO,
					request.getSession().getServletContext().getRealPath("/"), true);
			return "redirect:/cpuArchitecture/cpuArchitectures";
		} else {
			return "redirect:/cpuArchitecture/add?error";
		}
	}

	@RequestMapping(value = "/cpuArchitectures")
	public String list(Model model) {
		model.addAttribute("cpuArchitectures", cpuArchitectureService.getAllCpuArchitectures());
		List<CompanyDTO> companiesThatHaveCpuArchitectures = companyService.getAllCompaniesThatHaveCpuArchitectures();
		model.addAttribute("companies", companiesThatHaveCpuArchitectures);
		return "cpuArchitecture/cpuArchitectures";
	}

	@RequestMapping(value = "/cpuArchitecture/{company}")
	public String listByCompany(Model model, @PathVariable("company") String company) {
		List<CpuArchitectureDTO> cpuArchitectures = cpuArchitectureService.getCpuArchitecturesByCompany(company);
		model.addAttribute("cpuArchitectures", cpuArchitectures);
		return "cpuArchitecture/cpuArchitectures";
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int cpuArchitectureId, Model model) {
		CpuArchitectureDTO cpuArchitectureDTO = cpuArchitectureService.getCpuArchitectureById(cpuArchitectureId);
		model.addAttribute("cpuArchitecture", cpuArchitectureDTO);
		return "cpuArchitecture/details";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int cpuArchitectureId, Model model) {
		model.addAttribute("cpuArchitecture", cpuArchitectureService.getCpuArchitectureById(cpuArchitectureId));
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());
		return "/cpuArchitecture/updateCpuArchitecture";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processUpdateForm(@ModelAttribute("cpuArchitecture") @Valid CpuArchitectureDTO cpuArchitectureDTO,
			BindingResult result, HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), cpuArchitectureDTO.getImage(),
				messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "cpuArchitecture/updateCpuArchitecture";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(cpuArchitectureDTO,
						request.getSession().getServletContext().getRealPath("/"), false);
			}
			boolean updatedOrNot = cpuArchitectureService.update(cpuArchitectureDTO);
			if (updatedOrNot == true) {
				return "redirect:/cpuArchitecture/details?id=" + cpuArchitectureDTO.getId();
			} else {
				return "redirect:/cpuArchitecture/update?id=" + cpuArchitectureDTO.getId() + "?error";
			}
		}
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (ex instanceof MaxUploadSizeExceededException) {
			model.put("errors", messages.get("add.form.image.error.size.afterSubmit"));
			CpuArchitectureDTO cpuArchitectureDTO = new CpuArchitectureDTO();
			model.put("newCpuArchitecture", cpuArchitectureDTO);
			return new ModelAndView("/cpuArchitecture/addCpuArchitecture", model);
		} else {
			model.put("error", messages.get("error.genericError"));
			model.put("sorry", messages.get("error.genericError.sorry"));
			return new ModelAndView("genericError", model);
		}
	}
	
	@ExceptionHandler(NoCpuArchitecturesFoundForCompanyException.class)
	public String handleNoCpuArchitectureFoundForCompany(Model model, HttpServletRequest req, NoCpuArchitecturesFoundForCompanyException exception) {
		return "cpuArchitecture/NoCpuArchitectureForCompany";

	}
	
	@ExceptionHandler(CpuArchitectureNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, CpuArchitectureNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/cpuArchitecture/cpuArchtitectureNotFound");
		String id = queryString.substring(3);
		mav.addObject("id", id);
		return mav;

	}

}
