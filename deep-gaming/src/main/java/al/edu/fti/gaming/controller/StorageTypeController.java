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

import al.edu.fti.gaming.dto.StorageTypeDTO;
import al.edu.fti.gaming.exception.StorageTypeNotFoundException;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.StorageTypeService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/storageType")
public class StorageTypeController implements HandlerExceptionResolver {

	@Autowired
	private StorageTypeService storageTypeService;
	
	@Autowired
	private GeneralService generalService;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		StorageTypeDTO storageTypeDTO = new StorageTypeDTO();
		model.addAttribute("newStorageType", storageTypeDTO);
		return "/storageType/addStorageType";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newStorageType") @Valid StorageTypeDTO storageTypeDTO,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/storageType/addStorageType";
		} else {
			if (storageTypeService.add(storageTypeDTO) != 0) {
				generalService.imageProcessing(storageTypeDTO, request.getSession().getServletContext().getRealPath("/"),
						true);

				return "redirect:/storageType/storageTypes";
			} else {
				return "redirect:/storageType/add?error";
			}
		}
	}

	@RequestMapping(value = "/storageTypes", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("storageTypes", storageTypeService.getAllStorageTypes());
		return "/storageType/storageTypes";
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int id, Model model) {
		model.addAttribute("storageType", storageTypeService.getStorageTypeById(id));
		return "/storageType/details";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		model.addAttribute("storageType", storageTypeService.getStorageTypeById(id));
		return "/storageType/updateStorageType";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCategory(@ModelAttribute("storageType") @Valid StorageTypeDTO storageTypeDTO, BindingResult result,
			HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), storageTypeDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/storageType/updateStorageTypeDTO";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(storageTypeDTO, request.getSession().getServletContext().getRealPath("/"),
						false);
			}

			boolean updatedOrNot = storageTypeService.update(storageTypeDTO);
			if (updatedOrNot == true) {
				return "redirect:/storageType/details?id=" + storageTypeDTO.getId();
			} else {
				return "redirect:/storageType/update?id=" + storageTypeDTO.getId() + "&error";
			}

		}

	}

	@ExceptionHandler(StorageTypeNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, StorageTypeNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/storageType/storageTypeNotFound");
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
