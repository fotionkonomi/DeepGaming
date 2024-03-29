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
import al.edu.fti.gaming.dto.CpuSocketDTO;
import al.edu.fti.gaming.exception.CpuSocketNotFoundException;
import al.edu.fti.gaming.exception.NoCpuSocketsFoundForCompanyException;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.service.CpuSocketService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.utils.CompanyEditor;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/cpuSocket")
@SessionAttributes("allCompanies")
public class CpuSocketController implements HandlerExceptionResolver {

	@Autowired
	private CpuSocketService cpuSocketService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private CompanyEditor editor;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCpuSocketForm(Model model) {
		CpuSocketDTO cpuSocketDTO = new CpuSocketDTO();
		model.addAttribute("newCpuSocket", cpuSocketDTO);
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());
		return "/cpuSocket/addCpuSocket";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newCpuSocket") @Valid CpuSocketDTO cpuSocketDTO, BindingResult result,
			HttpServletRequest request) {

		if (result.hasErrors()) {
			return "cpuSocket/addCpuSocket";
		}
		if (cpuSocketService.add(cpuSocketDTO) != 0) {
			generalService.imageProcessing(cpuSocketDTO, request.getSession().getServletContext().getRealPath("/"),
					true);
			return "redirect:/cpuSocket/cpuSockets";
		} else {
			return "redirect:/cpuSocket/add?error";
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(CompanyDTO.class, this.editor);
	}

	@RequestMapping(value = "/cpuSockets", method = RequestMethod.GET)
	public String allCpuSockets(Model model) {
		model.addAttribute("cpuSockets", cpuSocketService.getAllCpuSockets());
		List<CompanyDTO> companiesThatHaveCpuSockets = companyService.getAllCompaniesThatHaveCpuSockets();
 		model.addAttribute("companies", companiesThatHaveCpuSockets );
		return "/cpuSocket/cpuSockets";
	}

	@RequestMapping(value = "/cpuSockets/{company}")
	public String getCpuSocketsByCompany(Model model, @PathVariable("company") String company) {
		List<CpuSocketDTO> cpuSockets = cpuSocketService.getCpuSocketsByCompany(company);
		model.addAttribute("cpuSockets", cpuSockets);
		return "/cpuSocket/cpuSockets";
	}

	@RequestMapping("/details")
	public String detailsOfACpuSocket(@RequestParam("id") int cpuSocketId, Model model) {
		CpuSocketDTO cpuSocketDTO = cpuSocketService.getCpuSocketById(cpuSocketId);
		model.addAttribute("cpuSocket", cpuSocketDTO);
		return "/cpuSocket/details";
	}

	@RequestMapping("/update")
	public String updateCpuSocket(@RequestParam("id") int cpuSocketId, Model model) {
		model.addAttribute("cpuSocket", cpuSocketService.getCpuSocketById(cpuSocketId));
		
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());

		return "/cpuSocket/updateCpuSocket";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCpuSocket(@ModelAttribute("cpuSocket") @Valid CpuSocketDTO cpuSocketDTO, BindingResult result,
			HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), cpuSocketDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));

		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/cpuSocket/updateCpuSocket";
		} else {

			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(cpuSocketDTO, request.getSession().getServletContext().getRealPath("/"),
						false);
			}
			boolean updatedOrNot = cpuSocketService.update(cpuSocketDTO);
			if (updatedOrNot == true) {
				return "redirect:/cpuSocket/details?id=" + cpuSocketDTO.getId();
			} else {
				return "redirect:/cpuSocket/update?id=" + cpuSocketDTO.getId() + "&error";
			}

		}
	}

	@ExceptionHandler(CpuSocketNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, CpuSocketNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/cpuSocket/cpuSocketNotFound");
		String id = queryString.substring(3);
		mav.addObject("id", id);
		return mav;

	}
	
	@ExceptionHandler(NoCpuSocketsFoundForCompanyException.class)
	public String handleNoCpuSocketFoundForCompany(Model model, HttpServletRequest req, NoCpuSocketsFoundForCompanyException exception) {
		return "cpuSocket/NoCpuSocketForCompany";

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
}
