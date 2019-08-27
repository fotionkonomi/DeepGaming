package al.edu.fti.gaming.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

import al.edu.fti.gaming.dto.CpuBenchmarkTypeDTO;
import al.edu.fti.gaming.exception.CpuBenchmarkTypeNotFoundException;
import al.edu.fti.gaming.service.CpuBenchmarkTypeService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.utils.Messages;

@Repository
@RequestMapping("/cpuBenchmarkType")
public class CpuBenchmarkTypeController implements HandlerExceptionResolver {

	@Autowired
	private CpuBenchmarkTypeService benchmarkTypeService;
	
	@Autowired
	private GeneralService generalService;

	@Autowired
	private Messages messages;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(Model model) {
		CpuBenchmarkTypeDTO benchmarkTypeDTO = new CpuBenchmarkTypeDTO();
		model.addAttribute("newBenchmarkType", benchmarkTypeDTO);
		return "/cpuBenchmarkType/addBenchmarkType";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newBenchmarkType") @Valid CpuBenchmarkTypeDTO benchmarkTypeDTO,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/cpuBenchmarkType/addBenchmarkType";
		} else {
			if (benchmarkTypeService.add(benchmarkTypeDTO) != 0) {
				generalService.imageProcessing(benchmarkTypeDTO, request.getSession().getServletContext().getRealPath("/"),
						true);

				return "redirect:/cpuBenchmarkType/benchmarkTypes";
			} else {
				return "redirect:/cpuBenchmarkType/add?error";
			}
		}
	}

	@RequestMapping(value = "/benchmarkTypes", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("benchmarkTypes", benchmarkTypeService.getAllBenchmarkTypes());
		return "/cpuBenchmarkType/benchmarkTypes";
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int id, Model model) {
		model.addAttribute("benchmarkType", benchmarkTypeService.getBenchmarkTypeById(id));
		return "/cpuBenchmarkType/details";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		model.addAttribute("benchmarkType", benchmarkTypeService.getBenchmarkTypeById(id));
		return "/cpuBenchmarkType/updateBenchmarkType";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("benchmarkType") @Valid CpuBenchmarkTypeDTO benchmarkTypeDTO, BindingResult result,
			HttpServletRequest request) {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), benchmarkTypeDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/cpuBenchmarkType/updateBenchmarkType";
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(benchmarkTypeDTO, request.getSession().getServletContext().getRealPath("/"),
						false);
			}

			boolean updatedOrNot = benchmarkTypeService.update(benchmarkTypeDTO);
			if (updatedOrNot == true) {
				return "redirect:/cpuBenchmarkType/details?id=" + benchmarkTypeDTO.getId();
			} else {
				return "redirect:/cpuBenchmarkType/update?id=" + benchmarkTypeDTO.getId() + "&error";
			}

		}

	}

	@ExceptionHandler(CpuBenchmarkTypeNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, CpuBenchmarkTypeNotFoundException exception) {
		ModelAndView mav = new ModelAndView();
		String queryString = req.getQueryString();
		if (queryString.contains("&")) {
			int index = req.getQueryString().indexOf("&");
			queryString = req.getQueryString().substring(0, index);

		}

		mav.addObject("url", req.getRequestURL() + "?" + queryString);
		mav.setViewName("/cpuBenchmarkType/benchmarkTypeNotFound");
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
