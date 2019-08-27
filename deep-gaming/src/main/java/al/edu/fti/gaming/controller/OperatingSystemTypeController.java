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
import al.edu.fti.gaming.dto.OperatingSystemTypeDTO;
import al.edu.fti.gaming.exception.CompanyNotFoundException;
import al.edu.fti.gaming.exception.NoGpuArchitecturesFoundForCompanyException;
import al.edu.fti.gaming.exception.NoOperatingSystemFoundForCompanyException;
import al.edu.fti.gaming.exception.OperatingSystemNotFoundException;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.OperatingSystemTypeService;
import al.edu.fti.gaming.utils.CompanyEditor;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/operatingSystemType")
@SessionAttributes("allCompanies")
public class OperatingSystemTypeController implements HandlerExceptionResolver {

	@Autowired
	private OperatingSystemTypeService operatingSystemService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private GeneralService generalService;
	
	@Autowired
	private Messages messages;
	
	@Autowired
	private CompanyEditor editor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(CompanyDTO.class, this.editor);
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		OperatingSystemTypeDTO operatingSystemTypeDTO = new OperatingSystemTypeDTO();
		model.addAttribute("newOperatingSystemType", operatingSystemTypeDTO);
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());
		return "operatingSystemType/addOperatingSystemType";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newOperatingSystemType") @Valid OperatingSystemTypeDTO operatingSystemTypeDTO, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/operatingSystemType/addOperatingSystemType";
		}
		if (operatingSystemService.add(operatingSystemTypeDTO) != 0) {

			generalService.imageProcessing(operatingSystemTypeDTO, request.getSession().getServletContext().getRealPath("/"), true);

			return "redirect:/operatingSystemType/operatingSystemTypes";
		} else {
			return "redirect:/operatingSystemType/add?error";
		}
	}
	
	@RequestMapping(value = "/operatingSystemTypes", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("operatingSystemTypes", operatingSystemService.getOperatingSystemTypes());
		List<CompanyDTO> companiesThatHaveOperatingSystems = companyService.getAllCompaniesThatHaveOS();
		model.addAttribute("companies", companiesThatHaveOperatingSystems);
		return "/operatingSystemType/operatingSystemTypes";
	}
	
	@RequestMapping(value = "/operatingSystemTypes/{company}", method = RequestMethod.GET)
	public String list(Model model, @PathVariable("company") String company) {
		model.addAttribute("operatingSystemTypes", operatingSystemService.getAllOperatingSystemTypesByCompanyName(company));
		return "/operatingSystemType/operatingSystemTypes";
	}
	
	
	
	@RequestMapping("/details")
	public String details(@RequestParam("id") int id, Model model) {
		model.addAttribute("operatingSystemType", operatingSystemService.getOperatingSystemTypeById(id));
		return "/operatingSystemType/details";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		model.addAttribute("operatingSystemType", operatingSystemService.getOperatingSystemTypeById(id));
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());
		return "/operatingSystemType/updateOperatingSystemType";
	}

	@ExceptionHandler(OperatingSystemNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, OperatingSystemNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/operatingSystemType/operatingSystemTypeNotFound");
		String id = queryString.substring(3);
		mav.addObject("id", id);
		return mav;

	}

	@ExceptionHandler(NoOperatingSystemFoundForCompanyException.class)
	public String handleNoGpuArchitectureFoundForCompany(Model model, HttpServletRequest req, NoOperatingSystemFoundForCompanyException exception) {
		return "operatingSystemType/NoOperatingSystemForCompany";

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

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("operatingSystemType") @Valid OperatingSystemTypeDTO operatingSystemTypeDTO, BindingResult result,
			HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), operatingSystemTypeDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));

		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/operatingSystemType/updateOperatingSystemType";
		} else {

			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(operatingSystemTypeDTO, request.getSession().getServletContext().getRealPath("/"),
						false);
			}
			boolean updatedOrNot = operatingSystemService.update(operatingSystemTypeDTO);
			if (updatedOrNot == true) {
				return "redirect:/operatingSystemType/details?id=" + operatingSystemTypeDTO.getId();
			} else {
				return "redirect:/operatingSystemType/update?id=" + operatingSystemTypeDTO.getId() + "&error";
			}

		}
	}
}
