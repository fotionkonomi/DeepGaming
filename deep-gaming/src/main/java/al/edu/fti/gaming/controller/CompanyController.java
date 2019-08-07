package al.edu.fti.gaming.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.exception.CompanyNotFoundException;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/company")
public class CompanyController implements HandlerExceptionResolver {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCompanyForm(Model model) {
		CompanyDTO companyDTO = new CompanyDTO();
		model.addAttribute("newCompany", companyDTO);
		return "/company/addCompany";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newCompany") @Valid CompanyDTO companyDTO, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/company/addCompany";
		}
		if (companyService.add(companyDTO) != 0) {

			generalService.imageProcessing(companyDTO, companyDTO.getImage(), companyDTO.getId(),
					request.getSession().getServletContext().getRealPath("/"), true);

			return "redirect:/company/companies";
		} else {
			return "redirect:/company/add?error";
		}
	}

	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	public String allCompanies(Model model) {
		model.addAttribute("companies", companyService.getAllCompanies());
		return "/company/companies";
	}

	@RequestMapping("/details")
	public String detailsOfACompany(@RequestParam("id") int companyId, Model model) {
		model.addAttribute("company", companyService.getCompanyById(companyId));
		return "/company/details";
	}

	@RequestMapping("/update")
	public String updateCompany(@RequestParam("id") int companyId, Model model) {
		model.addAttribute("company", companyService.getCompanyById(companyId));
		return "/company/updateCompany";
	}

	@ExceptionHandler(CompanyNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, CompanyNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/company/companyNotFound");
		String id = queryString.substring(3);
		mav.addObject("id", id);
		return mav;

	}

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (exception instanceof MaxUploadSizeExceededException) {
			model.put("errors", messages.get("add.form.image.error.size.afterSubmit"));
			CompanyDTO companyDTO = new CompanyDTO();
			model.put("newCompany", companyDTO);
			return new ModelAndView("/company/addCompany", model);
		} else {
			model.put("error", messages.get("error.genericError"));
			model.put("sorry", messages.get("error.genericError.sorry"));
			return new ModelAndView("genericError", model);
		}

		// Vendos nje faqe per erroret
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCompany(@ModelAttribute("company") @Valid CompanyDTO companyDTO, BindingResult result,
			HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), companyDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));

		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/company/updateCompany";
		}

		if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
			generalService.imageProcessing(companyDTO, companyDTO.getImage(), companyDTO.getId(),
					request.getSession().getServletContext().getRealPath("/"), false);
		}
		boolean updatedOrNot = companyService.update(companyDTO);
		if (updatedOrNot == true) {
			return "redirect:/company/details?id=" + companyDTO.getId();
		} else {
			return "redirect:/company/update?id=" + companyDTO.getId() + "&error";
		}

	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public GeneralService getGeneralService() {
		return generalService;
	}

	public void setGeneralService(GeneralService generalService) {
		this.generalService = generalService;
	}

	public Messages getMessages() {
		return messages;
	}

	public void setMessages(Messages messages) {
		this.messages = messages;
	}
}
