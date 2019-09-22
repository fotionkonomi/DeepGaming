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

import al.edu.fti.gaming.dto.GpuMemoryTechnologyDTO;
import al.edu.fti.gaming.exception.GpuMemoryTechnologyNotFoundException;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.GpuMemoryTechnologyService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/gpuMemoryTechnology")
public class GpuMemoryTechnologyController implements HandlerExceptionResolver {

	@Autowired
	private GpuMemoryTechnologyService gpuMemoryTechnologyService;
	
	@Autowired
	private GeneralService generalService;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		GpuMemoryTechnologyDTO gpuMemoryTechnologyDTO = new GpuMemoryTechnologyDTO();
		model.addAttribute("newGpuMemoryTechnology", gpuMemoryTechnologyDTO);
		return "/gpuMemoryTechnology/addGpuMemoryTechnology";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newGpuMemoryTechnology") @Valid GpuMemoryTechnologyDTO gpuMemoryTechnologyDTO,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/gpuMemoryTechnology/addGpuMemoryTechnology";
		} else {
			if (gpuMemoryTechnologyService.add(gpuMemoryTechnologyDTO) != 0) {
				generalService.imageProcessing(gpuMemoryTechnologyDTO, request.getSession().getServletContext().getRealPath("/"),
						true);

				return "redirect:/gpuMemoryTechnology/gpuMemoryTechnologies";
			} else {
				return "redirect:/gpuMemoryTechnology/add?error";
			}
		}
	}

	@RequestMapping(value = "/gpuMemoryTechnologies", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("gpuMemoryTechnologies", gpuMemoryTechnologyService.getAllGpuMemoryTechnologies());
		return "/gpuMemoryTechnology/gpuMemoryTechnologies";
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int id, Model model) {
		model.addAttribute("gpuMemoryTechnology", gpuMemoryTechnologyService.getGpuMemoryTechnologyById(id));
		return "/gpuMemoryTechnology/details";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		model.addAttribute("gpuMemoryTechnology", gpuMemoryTechnologyService.getGpuMemoryTechnologyById(id));
		return "/gpuMemoryTechnology/updateGpuMemoryTechnology";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("gpuMemoryTechnology") @Valid GpuMemoryTechnologyDTO gpuMemoryTechnologyDTO, BindingResult result,
			HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), gpuMemoryTechnologyDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/gpuMemoryTechnology/updateGpuMemoryTechnology";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(gpuMemoryTechnologyDTO, request.getSession().getServletContext().getRealPath("/"),
						false);
			}

			boolean updatedOrNot = gpuMemoryTechnologyService.update(gpuMemoryTechnologyDTO);
			if (updatedOrNot == true) {
				return "redirect:/gpuMemoryTechnology/details?id=" + gpuMemoryTechnologyDTO.getId();
			} else {
				return "redirect:/gpuMemoryTechnology/update?id=" + gpuMemoryTechnologyDTO.getId() + "&error";
			}

		}

	}

	@ExceptionHandler(GpuMemoryTechnologyNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, GpuMemoryTechnologyNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/gpuMemoryTechnology/gpuMemoryTechnologyNotFound");
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
