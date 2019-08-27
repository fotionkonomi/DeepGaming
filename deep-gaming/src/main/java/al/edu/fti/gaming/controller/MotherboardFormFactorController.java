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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.dto.MotherboardFormFactorDTO;
import al.edu.fti.gaming.exception.MotherboardFormFactorNotFoundException;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.MotherboardFormFactorService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/motherboardFormFactor")
public class MotherboardFormFactorController implements HandlerExceptionResolver{
	
	@Autowired
	private MotherboardFormFactorService motherboardFormFactorService;
	
	@Autowired
	private GeneralService generalService;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		MotherboardFormFactorDTO motherboardFormFactorDTO = new MotherboardFormFactorDTO();
		model.addAttribute("newMotherboardFormFactor", motherboardFormFactorDTO);
		return "/motherboardFormFactor/addMotherboardFormFactor";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newMotherboardFormFactor") @Valid MotherboardFormFactorDTO motherboardFormFactorDTO,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/motherboardFormFactor/addMotherboardFormFactor";
		} else {
			if (motherboardFormFactorService.add(motherboardFormFactorDTO) != 0) {
				generalService.imageProcessing(motherboardFormFactorDTO, request.getSession().getServletContext().getRealPath("/"),
						true);

				return "redirect:/motherboardFormFactor/motherboardFormFactors";
			} else {
				return "redirect:/motherboardFormFactor/add?error";
			}
		}
	}

	@RequestMapping(value = "/motherboardFormFactors", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("motherboardFormFactors", motherboardFormFactorService.getAllMotherboardFormFactors());
		return "/motherboardFormFactor/motherboardFormFactors";
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int id, Model model) {
		model.addAttribute("motherboardFormFactor", motherboardFormFactorService.getMotherboardFormFactorById(id));
		return "/motherboardFormFactor/details";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		model.addAttribute("motherboardFormFactor", motherboardFormFactorService.getMotherboardFormFactorById(id));
		return "/motherboardFormFactor/updateMotherboardFormFactor";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("motherboardFormFactor") @Valid MotherboardFormFactorDTO motherboardFormFactorDTO, BindingResult result,
			HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), motherboardFormFactorDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/motherboardFormFactor/updateMotherboardFormFactor";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(motherboardFormFactorDTO, request.getSession().getServletContext().getRealPath("/"),
						false);
			}

			boolean updatedOrNot = motherboardFormFactorService.update(motherboardFormFactorDTO);
			if (updatedOrNot == true) {
				return "redirect:/motherboardFormFactor/details?id=" + motherboardFormFactorDTO.getId();
			} else {
				return "redirect:/motherboardFormFactor/update?id=" + motherboardFormFactorDTO.getId() + "&error";
			}

		}

	}

	@ExceptionHandler(MotherboardFormFactorNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, MotherboardFormFactorNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/motherboardFormFactor/motherboardFormFactorNotFound");
		String id = queryString.substring(3);
		mav.addObject("id", id);
		return mav;

	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (ex instanceof MaxUploadSizeExceededException) {
			model.put("errors", messages.get("add.form.image.error.size.afterSubmit"));
			return new ModelAndView("error", model);
		} else {
			ex.printStackTrace();
			model.put("error", messages.get("error.genericError"));
			model.put("sorry", messages.get("error.genericError.sorry"));
			return new ModelAndView("error", model);
		}
	}
	
}
