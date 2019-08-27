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

import al.edu.fti.gaming.dto.GpuSlotDTO;
import al.edu.fti.gaming.exception.GpuSlotNotFoundException;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.GpuSlotService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/gpuSlot")
public class GpuSlotController implements HandlerExceptionResolver {

	@Autowired
	private GpuSlotService gpuSlotService;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		GpuSlotDTO gpuSlotDTO = new GpuSlotDTO();
		model.addAttribute("newGpuSlot", gpuSlotDTO);
		return "/gpuSlot/addGpuSlot";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newGpuSlot") @Valid GpuSlotDTO gpuSlotDTO,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/gpuSlot/addGpuSlot";
		} else {
			if (gpuSlotService.add(gpuSlotDTO) != 0) {
				generalService.imageProcessing(gpuSlotDTO, request.getSession().getServletContext().getRealPath("/"),
						true);

				return "redirect:/gpuSlot/gpuSlots";
			} else {
				return "redirect:/gpuSlot/add?error";
			}
		}
	}

	@RequestMapping(value = "/gpuSlots", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("gpuSlots", gpuSlotService.getAllGpuSlots());
		return "/gpuSlot/gpuSlots";
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int id, Model model) {
		model.addAttribute("gpuSlot", gpuSlotService.getGpuSlotById(id));
		return "/gpuSlot/details";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		model.addAttribute("gpuSlot", gpuSlotService.getGpuSlotById(id));
		return "/gpuSlot/updateGpuSlot";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("gpuSlot") @Valid GpuSlotDTO gpuSlotDTO, BindingResult result,
			HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), gpuSlotDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/gpuSlot/updateGpuSloT";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(gpuSlotDTO, request.getSession().getServletContext().getRealPath("/"),
						false);
			}

			boolean updatedOrNot = gpuSlotService.update(gpuSlotDTO);
			if (updatedOrNot == true) {
				return "redirect:/gpuSlot/details?id=" + gpuSlotDTO.getId();
			} else {
				return "redirect:/gpuSlot/update?id=" + gpuSlotDTO.getId() + "&error";
			}

		}

	}

	@ExceptionHandler(GpuSlotNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, GpuSlotNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/gpuSlot/gpuSlotNotFound");
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
