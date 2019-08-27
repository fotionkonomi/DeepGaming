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

import al.edu.fti.gaming.dto.RamMemoryTechnologyDTO;
import al.edu.fti.gaming.exception.RamMemoryTechnologyNotFoundException;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.RamMemoryTechnologyService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/ramMemoryTechnology")
public class RamMemoryTechnologyController implements HandlerExceptionResolver{
	
	@Autowired
	private RamMemoryTechnologyService ramMemoryTechnologyService;
	
	@Autowired
	private GeneralService generalService;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		RamMemoryTechnologyDTO ramMemoryTechnologyDTO = new RamMemoryTechnologyDTO();
		model.addAttribute("newRamMemoryTechnology", ramMemoryTechnologyDTO);
		return "/ramMemoryTechnology/addRamMemoryTechnology";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newRamMemoryTechnology") @Valid RamMemoryTechnologyDTO ramMemoryTechnologyDTO,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/ramMemoryTechnology/addRamMemoryTechnology";
		} else {
			if (ramMemoryTechnologyService.add(ramMemoryTechnologyDTO) != 0) {
				generalService.imageProcessing(ramMemoryTechnologyDTO, request.getSession().getServletContext().getRealPath("/"),
						true);

				return "redirect:/ramMemoryTechnology/ramMemoryTechnologies";
			} else {
				return "redirect:/ramMemoryTechnology/add?error";
			}
		}
	}

	@RequestMapping(value = "/ramMemoryTechnologies", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("ramMemoryTechnologies", ramMemoryTechnologyService.getAllRamMemoryTechnologies());
		return "/ramMemoryTechnology/ramMemoryTechnologies";
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int id, Model model) {
		model.addAttribute("ramMemoryTechnology", ramMemoryTechnologyService.getRamMemoryTechnologyById(id));
		return "/ramMemoryTechnology/details";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		model.addAttribute("ramMemoryTechnology", ramMemoryTechnologyService.getRamMemoryTechnologyById(id));
		return "/ramMemoryTechnology/updateRamMemoryTechnology";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("ramMemoryTechnology") @Valid RamMemoryTechnologyDTO ramMemoryTechnologyDTO, BindingResult result,
			HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), ramMemoryTechnologyDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/ramMemoryTechnology/updateRamMemoryTechnology";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(ramMemoryTechnologyDTO, request.getSession().getServletContext().getRealPath("/"),
						false);
			}

			boolean updatedOrNot = ramMemoryTechnologyService.update(ramMemoryTechnologyDTO);
			if (updatedOrNot == true) {
				return "redirect:/ramMemoryTechnology/details?id=" + ramMemoryTechnologyDTO.getId();
			} else {
				return "redirect:/ramMemoryTechnology/update?id=" + ramMemoryTechnologyDTO.getId() + "&error";
			}

		}

	}

	@ExceptionHandler(RamMemoryTechnologyNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, RamMemoryTechnologyNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/ramMemoryTechnology/ramMemoryTechnologyNotFound");
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
