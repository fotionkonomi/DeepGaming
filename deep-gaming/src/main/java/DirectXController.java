

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

import al.edu.fti.gaming.dto.DirectXDTO;
import al.edu.fti.gaming.dto.EsrbRatingsDTO;
import al.edu.fti.gaming.exception.DirectXNotFoundException;
import al.edu.fti.gaming.exception.EsrbRatingNotFoundException;
import al.edu.fti.gaming.models.CPU;
import al.edu.fti.gaming.service.DirectXService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/directX")
public class DirectXController implements HandlerExceptionResolver {

	@Autowired
	private DirectXService directXService;
	
	@Autowired
	private GeneralService generalService;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		DirectXDTO directXDTO = new DirectXDTO();
		model.addAttribute("newDirectX", directXDTO);
		return "/directX/addDirectX";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newDirectX") @Valid DirectXDTO directXDTO, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/directX/addDirectX";
		} else {
			if (directXService.add(directXDTO) != 0) {
				generalService.imageProcessing(directXDTO,
						request.getSession().getServletContext().getRealPath("/"), true);

				return "redirect:/directX/directXs";
			} else {
				return "redirect:/directX/add?error";
			}
		}
	}
	

	@RequestMapping(value = "/directXs", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("directXs", directXService.getAllDirectXs());
		return "/directX/directXs";
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int id, Model model) {
		model.addAttribute("directX", directXService.getDirectXById(id));
		return "/directX/details";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		model.addAttribute("directX", directXService.getDirectXById(id));
		return "/directX/updateDirectX";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("directX") @Valid DirectXDTO directXDTO,
			BindingResult result, HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), directXDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/directX/updateDirectX";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(directXDTO,
						request.getSession().getServletContext().getRealPath("/"), false);
			}

			boolean updatedOrNot = directXService.update(directXDTO);
			if (updatedOrNot == true) {
				return "redirect:/directX/details?id=" + directXDTO.getId();
			} else {
				return "redirect:/directX/update?id=" + directXDTO.getId() + "&error";
			}

		}

	}

	@ExceptionHandler(DirectXNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, DirectXNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/directX/directXNotFound");
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
