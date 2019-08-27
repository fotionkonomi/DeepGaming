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

import al.edu.fti.gaming.dto.GpuBenchmarkTypeDTO;
import al.edu.fti.gaming.exception.GpuBenchmarkTypeNotFoundException;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.GpuBenchmarkTypeService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/gpuBenchmarkType")
public class GpuBenchmarkController implements HandlerExceptionResolver {

	@Autowired
	private GpuBenchmarkTypeService benchmarkTypeService;
	
	@Autowired
	private GeneralService generalService;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		GpuBenchmarkTypeDTO benchmarkTypeDTO = new GpuBenchmarkTypeDTO();
		model.addAttribute("newBenchmarkType", benchmarkTypeDTO);
		return "/gpuBenchmarkType/addBenchmarkType";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newBenchmarkType") @Valid GpuBenchmarkTypeDTO benchmarkTypeDTO,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/gpuBenchmarkType/addBenchmarkType";
		} else {
			if (benchmarkTypeService.add(benchmarkTypeDTO) != 0) {
				generalService.imageProcessing(benchmarkTypeDTO, request.getSession().getServletContext().getRealPath("/"),
						true);

				return "redirect:/gpuBenchmarkType/benchmarkTypes";
			} else {
				return "redirect:/gpuBenchmarkType/add?error";
			}
		}
	}

	@RequestMapping(value = "/benchmarkTypes", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("benchmarkTypes", benchmarkTypeService.getAllBenchmarkTypes());
		return "/gpuBenchmarkType/benchmarkTypes";
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int id, Model model) {
		model.addAttribute("benchmarkType", benchmarkTypeService.getBenchmarkTypeById(id));
		return "/gpuBenchmarkType/details";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		model.addAttribute("benchmarkType", benchmarkTypeService.getBenchmarkTypeById(id));
		return "/gpuBenchmarkType/updateBenchmarkType";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("benchmarkType") @Valid GpuBenchmarkTypeDTO benchmarkTypeDTO, BindingResult result,
			HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), benchmarkTypeDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/gpuBenchmarkType/updateBenchmarkType";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(benchmarkTypeDTO, request.getSession().getServletContext().getRealPath("/"),
						false);
			}

			boolean updatedOrNot = benchmarkTypeService.update(benchmarkTypeDTO);
			if (updatedOrNot == true) {
				return "redirect:/gpuBenchmarkType/details?id=" + benchmarkTypeDTO.getId();
			} else {
				return "redirect:/gpuBenchmarkType/update?id=" + benchmarkTypeDTO.getId() + "&error";
			}

		}

	}

	@ExceptionHandler(GpuBenchmarkTypeNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, GpuBenchmarkTypeNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/gpuBenchmarkType/benchmarkTypeNotFound");
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
