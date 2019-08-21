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
import al.edu.fti.gaming.dto.CpuFamilyDTO;
import al.edu.fti.gaming.exception.CpuArchitectureNotFoundException;
import al.edu.fti.gaming.exception.CpuFamilyNotFoundException;
import al.edu.fti.gaming.exception.NoCpuArchitecturesFoundForCompanyException;
import al.edu.fti.gaming.exception.NoCpuFamilyFoundForCompanyException;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.service.CpuFamilyService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.utils.CompanyEditor;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping(value = "/cpuFamily")
@SessionAttributes("allCompanies")
public class CpuFamilyController implements HandlerExceptionResolver {

	@Autowired
	private CpuFamilyService cpuFamilyService;

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
		CpuFamilyDTO cpuFamilyDTO = new CpuFamilyDTO();
		model.addAttribute("newCpuFamily", cpuFamilyDTO);
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());
		return "cpuFamily/addCpuFamily";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newCpuFamily") @Valid CpuFamilyDTO cpuFamilyDTO, BindingResult result,
			HttpServletRequest request) {
		if(result.hasErrors()) {
			return "cpuFamily/addCpuFamily";
		}
		if(cpuFamilyService.add(cpuFamilyDTO) != 0) {
			generalService.imageProcessing(cpuFamilyDTO,
					request.getSession().getServletContext().getRealPath("/"), true);	
			return "redirect:/cpuFamily/cpuFamilies";
		} else {
			return "redirect:/cpuFamily/add?error";
		}
		
	}

	@RequestMapping(value = "/cpuFamilies")
	public String list(Model model) {
		model.addAttribute("cpuFamilies", cpuFamilyService.getAllCpuFamilies());
		List<CompanyDTO> companiesThatHaveCpuFamilies = companyService.getAllCompaniesThatHaveCpuFamilies();
		model.addAttribute("companies", companiesThatHaveCpuFamilies);
		return "cpuFamily/cpuFamilies";
	}
	
	@RequestMapping(value = "/cpuFamilies/{company}")
	public String listByCompany(Model model, @PathVariable("company") String company) {
		List<CpuFamilyDTO> cpuFamilies = cpuFamilyService.getCpuFamiliesByCompany(company);
		model.addAttribute("cpuFamilies", cpuFamilies);
		return "cpuFamily/cpuFamilies";
	}
	
	@RequestMapping("/details")
	public String details(@RequestParam("id") int cpuFamilyId, Model model) {
		CpuFamilyDTO cpuFamilyDTO = cpuFamilyService.getCpuFamilyById(cpuFamilyId);
		model.addAttribute("cpuFamily", cpuFamilyDTO);
		return "cpuFamily/details";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam("id") int cpuFamilyId, Model model) {
		CpuFamilyDTO cpuFamilyDTO = cpuFamilyService.getCpuFamilyById(cpuFamilyId);
		model.addAttribute("cpuFamily", cpuFamilyDTO);
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());
		return "cpuFamily/updateCpuFamily";
	}	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processUpdateForm(@ModelAttribute("cpuFamily") @Valid CpuFamilyDTO cpuFamilyDTO,
			BindingResult result, HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), cpuFamilyDTO.getImage(),
				messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "cpuFamily/updateCpuFamily";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(cpuFamilyDTO,
						request.getSession().getServletContext().getRealPath("/"), false);
			}
			boolean updatedOrNot = cpuFamilyService.update(cpuFamilyDTO);
			if (updatedOrNot == true) {
				return "redirect:/cpuFamily/details?id=" + cpuFamilyDTO.getId();
			} else {
				return "redirect:/cpuFamily/update?id=" + cpuFamilyDTO.getId() + "?error";
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
	
	@ExceptionHandler(CpuFamilyNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, CpuFamilyNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/cpuFamily/cpuFamilyNotFound");
		String id = queryString.substring(3);
		mav.addObject("id", id);
		return mav;

	}

	@ExceptionHandler(NoCpuFamilyFoundForCompanyException.class)
	public String handleNoCpuArchitectureFoundForCompany(Model model, HttpServletRequest req, NoCpuFamilyFoundForCompanyException exception) {
		return "cpuFamily/NoCpuFamilyForCompany";

	}
	

}
