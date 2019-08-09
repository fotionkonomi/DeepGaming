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

import al.edu.fti.gaming.dto.ChipsetDTO;
import al.edu.fti.gaming.exception.ChipsetNotFoundException;
import al.edu.fti.gaming.service.ChipsetService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping(value = "/chipset")
public class ChipsetController implements HandlerExceptionResolver {

	@Autowired
	private ChipsetService chipsetService;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addChipsetForm(Model model) {
		ChipsetDTO chipsetDTO = new ChipsetDTO();
		model.addAttribute("newChipset", chipsetDTO);
		return "/chipset/addChipset";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newChipset") @Valid ChipsetDTO chipsetDTO, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/categoryOfGames/addCategory";
		} else {
			if (chipsetService.add(chipsetDTO) != 0) {
				generalService.imageProcessing(chipsetDTO, request.getSession().getServletContext().getRealPath("/"),
						true);

				return "redirect:/chipset/chipsets";
			} else {
				return "redirect:/chipset/add?error";
			}
		}
	}

	@RequestMapping(value = "/chipsets", method = RequestMethod.GET)
	public String allChipsets(Model model) {
		model.addAttribute("chipsets", chipsetService.getAllChipsets());
		return "/chipset/chipsets";
	}

	@RequestMapping(value = "/details")
	public String detailsOfAChipset(@RequestParam("id") int chipsetId, Model model) {
		model.addAttribute("chipset", chipsetService.getChipsetById(chipsetId));
		return "/chipset/details";
	}

	@RequestMapping(value = "/update")
	public String updateAChipset(@RequestParam("id") int chipsetId, Model model) {
		model.addAttribute("chipset", chipsetService.getChipsetById(chipsetId));
		return "/chipset/details";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateChipset(@ModelAttribute("chipset") @Valid ChipsetDTO chipsetDTO, BindingResult result,
			HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), chipsetDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));

		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/chipset/updateChipset";
		} else {

			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(chipsetDTO, request.getSession().getServletContext().getRealPath("/"),
						false);
			}
			boolean updatedOrNot = chipsetService.update(chipsetDTO);
			if (updatedOrNot == true) {
				return "redirect:/chipset/details?id=" + chipsetDTO.getId();
			} else {
				return "redirect:/chipset/update?id=" + chipsetDTO.getId() + "&error";
			}

		}
	}

	@ExceptionHandler(ChipsetNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ChipsetNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/chipset/chipsetNotFound");
		String id = queryString.substring(3);
		mav.addObject("id", id);
		return mav;

	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (exception instanceof MaxUploadSizeExceededException) {
			model.put("errors", messages.get("add.form.image.error.size.afterSubmit"));
			ChipsetDTO chipsetDTO = new ChipsetDTO();
			model.put("newChipset", chipsetDTO);
			return new ModelAndView("/company/addCompany", model);
		} else {
			model.put("error", messages.get("error.genericError"));
			model.put("sorry", messages.get("error.genericError.sorry"));
			return new ModelAndView("genericError", model);
		}

	}

}