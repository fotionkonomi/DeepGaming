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

import al.edu.fti.gaming.dto.CategoryOfGameDTO;
import al.edu.fti.gaming.exception.CategoryOfGameNotFoundException;
import al.edu.fti.gaming.service.CategoryOfGameService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/categoryOfGames")
public class CategoryOfGamesController implements HandlerExceptionResolver {

	@Autowired
	private CategoryOfGameService categoryOfGameService;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCategoryForm(Model model) {
		CategoryOfGameDTO categoryOfGameDTO = new CategoryOfGameDTO();
		model.addAttribute("newCategory", categoryOfGameDTO);
		return "/categoryOfGames/addCategory";

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newCategory") @Valid CategoryOfGameDTO categoryOfGameDTO,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/categoryOfGames/addCategory";
		} else {
			if (categoryOfGameService.add(categoryOfGameDTO) != 0) {
				generalService.imageProcessing(categoryOfGameDTO,
						request.getSession().getServletContext().getRealPath("/"), true);

				return "redirect:/categoryOfGames/categories";
			} else {
				return "redirect:/categoryOfGames/add?error";
			}
		}
	}

	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String allCategories(Model model) {
		model.addAttribute("categories", categoryOfGameService.getAllCategories());
		return "/categoryOfGames/categories";
	}

	@RequestMapping("/details")
	public String detailsOfACategory(@RequestParam("id") int categoryId, Model model) {
		model.addAttribute("category", categoryOfGameService.getCategoryById(categoryId));
		return "/categoryOfGames/details";
	}

	@RequestMapping("/update")
	public String updateCategory(@RequestParam("id") int categoryId, Model model) {
		model.addAttribute("category", categoryOfGameService.getCategoryById(categoryId));
		return "/categoryOfGames/updateCategory";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("category") @Valid CategoryOfGameDTO categoryOfGameDTO,
			BindingResult result, HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), categoryOfGameDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/categoryOfGames/updateCategory";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(categoryOfGameDTO,
						request.getSession().getServletContext().getRealPath("/"), false);
			}

			boolean updatedOrNot = categoryOfGameService.update(categoryOfGameDTO);
			if (updatedOrNot == true) {
				return "redirect:/categoryOfGames/details?id=" + categoryOfGameDTO.getId();
			} else {
				return "redirect:/categoryOfGames/update?id=" + categoryOfGameDTO.getId() + "&error";
			}

		}

	}

	@ExceptionHandler(CategoryOfGameNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, CategoryOfGameNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/categoryOfGames/categoryNotFound");
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

	public CategoryOfGameService getCategoryOfGameService() {
		return categoryOfGameService;
	}

	public void setCategoryOfGameService(CategoryOfGameService categoryOfGameService) {
		this.categoryOfGameService = categoryOfGameService;
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
