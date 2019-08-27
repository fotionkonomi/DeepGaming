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
import al.edu.fti.gaming.dto.GpuFamilyDTO;
import al.edu.fti.gaming.exception.GpuFamilyNotFoundException;
import al.edu.fti.gaming.exception.NoGpuFamilyFoundForCompanyException;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.GpuFamilyService;
import al.edu.fti.gaming.utils.CompanyEditor;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/gpuFamily")
@SessionAttributes("allCompanies")
public class GpuFamilyController implements HandlerExceptionResolver {

	@Autowired
	private GpuFamilyService gpuFamilyService;
	
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
		GpuFamilyDTO gpuFamilyDTO = new GpuFamilyDTO();
		model.addAttribute("newGpuFamily", gpuFamilyDTO);
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());
		return "gpuFamily/addGpuFamily";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newGpuFamily") @Valid GpuFamilyDTO gpuFamilyDTO, BindingResult result,
			HttpServletRequest request) {
		if(result.hasErrors()) {
			return "gpuFamily/addGpuFamily";
		}
		if(gpuFamilyService.add(gpuFamilyDTO) != 0) {
			generalService.imageProcessing(gpuFamilyDTO,
					request.getSession().getServletContext().getRealPath("/"), true);	
			return "redirect:/gpuFamily/gpuFamilies";
		} else {
			return "redirect:/gpuFamily/add?error";
		}
		
	}
	
	@RequestMapping(value = "/gpuFamilies")
	public String list(Model model) {
		model.addAttribute("gpuFamilies", gpuFamilyService.getAllGpuFamilies());
		List<CompanyDTO> companiesThatHaveGpuFamilies = companyService.getAllCompaniesThatHaveGpuFamilies();
		model.addAttribute("companies", companiesThatHaveGpuFamilies);
		return "gpuFamily/gpuFamilies";
	}
	
	@RequestMapping(value = "/gpuFamilies/{company}")
	public String listByCompany(Model model, @PathVariable("company") String company) {
		List<GpuFamilyDTO> gpuFamilies = gpuFamilyService.getGuFamiliesByCompany(company);
		model.addAttribute("gpuFamilies", gpuFamilies);
		return "gpuFamily/gpuFamilies";
	}
	
	@RequestMapping("/details")
	public String details(@RequestParam("id") int gpuFamilyId, Model model) {
		GpuFamilyDTO gpuFamilyDTO = gpuFamilyService.getGpuFamilyById(gpuFamilyId);
		model.addAttribute("gpuFamily", gpuFamilyDTO);
		return "gpuFamily/details";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") int gpuFamilyId, Model model) {
		GpuFamilyDTO gpuFamilyDTO = gpuFamilyService.getGpuFamilyById(gpuFamilyId);
		model.addAttribute("gpuFamily", gpuFamilyDTO);
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());
		return "gpuFamily/updateGpuFamily";
	}	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processUpdateForm(@ModelAttribute("gpuFamily") @Valid GpuFamilyDTO gpuFamilyDTO,
			BindingResult result, HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), gpuFamilyDTO.getImage(),
				messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "gpuFamily/updateGpuFamily";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(gpuFamilyDTO,
						request.getSession().getServletContext().getRealPath("/"), false);
			}
			boolean updatedOrNot = gpuFamilyService.update(gpuFamilyDTO);
			if (updatedOrNot == true) {
				return "redirect:/gpuFamily/details?id=" + gpuFamilyDTO.getId();
			} else {
				return "redirect:/gpuFamily/update?id=" + gpuFamilyDTO.getId() + "?error";
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
	
	@ExceptionHandler(GpuFamilyNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, GpuFamilyNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/gpuFamily/gpuFamilyNotFound");
		String id = queryString.substring(3);
		mav.addObject("id", id);
		return mav;

	}

	@ExceptionHandler(NoGpuFamilyFoundForCompanyException.class)
	public String handleNoGpuArchitectureFoundForCompany(Model model, HttpServletRequest req, NoGpuFamilyFoundForCompanyException exception) {
		return "gpuFamily/NoGpuFamilyForCompany";

	}
	
	
}
