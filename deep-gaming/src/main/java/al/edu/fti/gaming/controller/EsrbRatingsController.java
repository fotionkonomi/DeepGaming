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

import al.edu.fti.gaming.dto.EsrbRatingsDTO;
import al.edu.fti.gaming.exception.EsrbRatingNotFoundException;
import al.edu.fti.gaming.service.EsrbRatingsService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/esrbRating")
public class EsrbRatingsController implements HandlerExceptionResolver {

	@Autowired
	private EsrbRatingsService esrbRatingsService;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		EsrbRatingsDTO esrbRatingsDTO = new EsrbRatingsDTO();
		model.addAttribute("newEsrbRating", esrbRatingsDTO);
		return "/esrbRating/addEsrbRating";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newEsrbRating") @Valid EsrbRatingsDTO esrbRatingsDTO,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/esrbRating/addEsrbRating";
		} else {
			if (esrbRatingsService.add(esrbRatingsDTO) != 0) {
				generalService.imageProcessing(esrbRatingsDTO,
						request.getSession().getServletContext().getRealPath("/"), true);

				return "redirect:/esrbRating/esrbRatings";
			} else {
				return "redirect:/esrbRating/add?error";
			}
		}
	}

	@RequestMapping(value = "/esrbRatings", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("esrbRatings", esrbRatingsService.getAllEsrbRatingsDTO());
		return "/esrbRating/esrbRatings";
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int id, Model model) {
		model.addAttribute("esrbRating", esrbRatingsService.getEsrbRatingById(id));
		return "/esrbRating/details";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		model.addAttribute("esrbRating", esrbRatingsService.getEsrbRatingById(id));
		return "/esrbRating/updateEsrbRating";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("esrbRating") @Valid EsrbRatingsDTO esrbRatingsDTO, BindingResult result,
			HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), esrbRatingsDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/esrbRating/updateEsrbRatings";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(esrbRatingsDTO,
						request.getSession().getServletContext().getRealPath("/"), false);
			}

			boolean updatedOrNot = esrbRatingsService.update(esrbRatingsDTO);
			if (updatedOrNot == true) {
				return "redirect:/esrbRating/details?id=" + esrbRatingsDTO.getId();
			} else {
				return "redirect:/esrbRating/update?id=" + esrbRatingsDTO.getId() + "&error";
			}

		}

	}

	@ExceptionHandler(EsrbRatingNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, EsrbRatingNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/esrbRating/esrbRatingNotFound");
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
			model.put("error", messages.get("error.genericError"));
			model.put("sorry", messages.get("error.genericError.sorry"));
			return new ModelAndView("error", model);
		}
	}

}
