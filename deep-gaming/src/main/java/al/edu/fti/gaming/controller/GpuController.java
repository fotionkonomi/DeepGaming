package al.edu.fti.gaming.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.DirectXDTO;
import al.edu.fti.gaming.dto.GpuArchitectureDTO;
import al.edu.fti.gaming.dto.GpuDTO;
import al.edu.fti.gaming.dto.GpuFamilyDTO;
import al.edu.fti.gaming.dto.GpuMemoryTechnologyDTO;
import al.edu.fti.gaming.dto.GpuSlotDTO;
import al.edu.fti.gaming.exception.GpuArchitectureNotFoundException;
import al.edu.fti.gaming.exception.GpuNotFoundException;
import al.edu.fti.gaming.exception.ProductsNotFoundException;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.service.CpuService;
import al.edu.fti.gaming.service.DirectXService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.GpuArchitectureService;
import al.edu.fti.gaming.service.GpuFamilyService;
import al.edu.fti.gaming.service.GpuMemoryTechnologyService;
import al.edu.fti.gaming.service.GpuService;
import al.edu.fti.gaming.service.GpuSlotService;
import al.edu.fti.gaming.utils.CpuEditor;
import al.edu.fti.gaming.utils.DirectXEditor;
import al.edu.fti.gaming.utils.GpuMemoryTechnologyEditor;
import al.edu.fti.gaming.utils.GpuSlotEditor;
import al.edu.fti.gaming.utils.Messages;
import al.edu.fti.gaming.validator.GpuValidator;

@Controller
@RequestMapping("/gpu")
public class GpuController implements HandlerExceptionResolver {

	@Autowired
	private GeneralService generalService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private GpuService gpuService;

	@Autowired
	private GpuArchitectureService gpuArchitectureService;

	@Autowired
	private GpuSlotService gpuSlotService;

	@Autowired
	private GpuFamilyService gpuFamilyService;

	@Autowired
	private GpuMemoryTechnologyService gpuMemoryTechnologyService;

	@Autowired
	private DirectXService directXService;

	@Autowired
	private Messages messages;

	@Autowired
	private CpuService cpuService;

	@Autowired
	private GpuValidator gpuValidator;

	@Autowired
	private GpuMemoryTechnologyEditor gpuMemoryTechnologyEditor;

	@Autowired
	private GpuSlotEditor gpuSlotEditor;

	@Autowired
	private DirectXEditor directXEditor;

	@Autowired
	private CpuEditor cpuEditor;

	@InitBinder /* Converts empty strings into null when a form is submitted */
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(GpuMemoryTechnologyDTO.class, this.gpuMemoryTechnologyEditor);
		binder.registerCustomEditor(DirectXDTO.class, this.directXEditor);
		binder.registerCustomEditor(GpuSlotDTO.class, this.gpuSlotEditor);
		binder.registerCustomEditor(CpuDTO.class, this.cpuEditor);

		binder.setValidator(gpuValidator);
	}

	@RequestMapping("/chooseCompany")
	public String chooseCompany(Model model) {
		List<CompanyDTO> companies = companyService.getAllCompaniesThatHaveGpuFamilies();
		model.addAttribute("companies", companies);
		return "gpu/chooseCompany";
	}

	@RequestMapping(value = "/chooseSelects", method = RequestMethod.GET)
	public String chooseSlotArchitectureFamily(Model model, @RequestParam("company") String company) {
		model.addAttribute("company", company);
		model.addAttribute("gpuFamilies", gpuFamilyService.getGuFamiliesByCompany(company));
		model.addAttribute("gpuArchitectures", gpuArchitectureService.getGpuArchitecturesByCompany(company));
		model.addAttribute("errorOrNot", true);
		return "gpu/chooseSelects";
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int gpuId, Model model) {
		model.addAttribute("gpu", gpuService.getGpuById(gpuId));
		return "gpu/details";
	}

	@RequestMapping(value = "/gpus")
	public String list(Model model, @RequestParam("page") int currentPage) {
		List<Integer> pageNumbers = new ArrayList<Integer>();
		int numberOfItemsOnThePage = 6;
		Long numberOfGpus = gpuService.countOfGpusInStock();
		for (int i = 1; i < numberOfGpus; i++) {
			if (i % 3 == 0) {
				pageNumbers.add(i / 3);
			}

		}
		if (numberOfGpus > pageNumbers.size() * numberOfItemsOnThePage) {
			pageNumbers.add(pageNumbers.size() + 1);
		}
		model.addAttribute("numberOfItemsOnThePage", numberOfItemsOnThePage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("count", numberOfGpus);
		model.addAttribute("gpus", gpuService.getAllGpusInStock(currentPage, numberOfItemsOnThePage));
		return "gpu/gpus";
	}
	
	@RequestMapping("/chooseGpuToCompare")
	public String chooseGpuToCompare(Model model, @RequestParam("gpu") int gpuId) {
		GpuDTO gpuDTO = gpuService.getGpuById(gpuId);
		model.addAttribute("gpu", gpuDTO);
		model.addAttribute("companies", companyService.getAllCompaniesThatHaveGpuFamilies());
		return "gpu/chooseGpuToCompare";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addGpu(Model model, @RequestParam("gpuFamily") Integer gpuFamily,
			@RequestParam("gpuArchitecture") Integer gpuArchitecture, @RequestParam("company") String company) {
		GpuFamilyDTO gpuFamilyDTO;
		try {
			gpuFamilyDTO = gpuFamilyService.getGpuFamilyById(gpuFamily);
		} catch (GpuNotFoundException e) {
			gpuFamilyDTO = null;
		}

		GpuArchitectureDTO gpuArchitectureDTO;

		try {
			gpuArchitectureDTO = gpuArchitectureService.getGpuArchitectureById(gpuArchitecture);
		} catch (GpuArchitectureNotFoundException e) {
			gpuArchitectureDTO = null;
		}

		// MOS VENDOSEN FAMILJE GPU TE KOMPANIVE TE NDRYSHME
		if (gpuFamilyDTO == null || gpuArchitectureDTO == null
				|| !gpuFamilyDTO.getCompanyOfThisGpuFamily()
						.equals(gpuArchitectureDTO.getCompanyOfThisGpuArchitecture())
				|| !gpuFamilyDTO.getCompanyOfThisGpuFamily().getName().equals(company)) {
			model.addAttribute("company", company);
			model.addAttribute("gpuFamilies", gpuFamilyService.getGuFamiliesByCompany(company));
			model.addAttribute("gpuArchitectures", gpuArchitectureService.getGpuArchitecturesByCompany(company));
			model.addAttribute("errorOrNot", null);

			return "/gpu/chooseSelects";
		}

		model.addAttribute("gpuFamily", gpuFamily);
		model.addAttribute("gpuArchitecture", gpuArchitecture);
		model.addAttribute("company", company);
		model.addAttribute("gpuMemoryTechnologies", gpuService.getAllMemoryTechnologiesMap());
		model.addAttribute("gpuSlots", gpuService.getAllGpuSlotsMap());
		model.addAttribute("directXs", gpuService.getDirectXsMap());
		model.addAttribute("cpus", gpuService.getAllCpusMap());
		GpuDTO gpuDTO = new GpuDTO();
		model.addAttribute("newGpu", gpuDTO);
		return "/gpu/addGpu";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute("newGpu") @Valid GpuDTO gpuDTO, BindingResult result,
			HttpServletRequest request) throws ParseException {
		ModelAndView mav;
		if (result.hasErrors()) {
			mav = gpuService.getModelWithRequestParameters(request.getQueryString());
			mav.addObject("gpuMemoryTechnologies", gpuService.getAllMemoryTechnologiesMap());
			mav.addObject("gpuSlots", gpuService.getAllGpuSlotsMap());
			mav.addObject("directXs", gpuService.getDirectXsMap());
			mav.addObject("cpus", gpuService.getAllCpusMap());
			mav.setViewName("gpu/addGpu");
			return mav;
		}

		mav = new ModelAndView();
		gpuService.preGpuSave(gpuDTO, request.getQueryString());
		gpuService.add(gpuDTO);
		generalService.imageProcessing(gpuDTO, request.getSession().getServletContext().getRealPath("/"), true);
		mav.setViewName("redirect:/gpu/details?id=" + gpuDTO.getId());

		return mav;
	}

	@RequestMapping("/compare")
	public String compare(Model model, @RequestParam("gpu1") int gpu1, @RequestParam("gpu2") int gpu2) {
		GpuDTO gpuDTO1 = gpuService.getGpuById(gpu1);
		GpuDTO gpuDTO2 = gpuService.getGpuById(gpu2);
		if (gpuDTO1.getGpuBenchmark() >= gpuDTO2.getGpuBenchmark()) {
			model.addAttribute("gpu1", gpuDTO1);
			model.addAttribute("gpu2", gpuDTO2);
		} else {
			model.addAttribute("gpu2", gpuDTO1);
			model.addAttribute("gpu1", gpuDTO2);
		}

		return "gpu/compare";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("id") int gpuId, Model model) {
		GpuDTO gpuDTO = gpuService.getGpuById(gpuId);
		model.addAttribute("gpu", gpuDTO);
		model.addAttribute("gpuMemoryTechnologies", gpuService.getAllMemoryTechnologiesMap());
		model.addAttribute("gpuSlots", gpuService.getAllGpuSlotsMap());
		model.addAttribute("directXs", gpuService.getDirectXsMap());
		model.addAttribute("cpus", gpuService.getAllCpusMap());
		return "gpu/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateGpu(@ModelAttribute("gpu") @Valid GpuDTO gpuDTO, BindingResult result,
			HttpServletRequest request, @RequestParam("id") int id) throws ParseException {
		ModelAndView mav = new ModelAndView();
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), gpuDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));

		if (!listOfErrorsWithoutImageError.isEmpty()) {
			mav.addObject("gpuMemoryTechnologies", gpuService.getAllMemoryTechnologiesMap());
			mav.addObject("gpuSlots", gpuService.getAllGpuSlotsMap());
			mav.addObject("directXs", gpuService.getDirectXsMap());
			mav.addObject("cpus", gpuService.getAllCpusMap());
			mav.setViewName("gpu/update");
			return mav;
		} else {

			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(gpuDTO, request.getSession().getServletContext().getRealPath("/"),
						false);
			}
			gpuService.update(gpuDTO, id);
			mav.setViewName("redirect:/gpu/details?id=" + gpuDTO.getId());
			return mav;
		}
	}

	@ExceptionHandler(ProductsNotFoundException.class)
	public String handleNoProductsFound(Model model, HttpServletRequest request, ProductsNotFoundException exception) {
		String queryString = request.getQueryString();
		int indexOfPage = queryString.indexOf("page=");
		int finalIndex = queryString.indexOf("&");
		if (finalIndex == -1) {
			finalIndex = queryString.length();
		}
		String pageValue = queryString.substring(indexOfPage + 5, finalIndex);
		model.addAttribute("page", pageValue);
		return "gpu/noProductsFound";
	}

	@ExceptionHandler(GpuNotFoundException.class)
	public String handleNoProductsFound(Model model, HttpServletRequest request, GpuNotFoundException exception) {
		return "gpu/noProductsFound";
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
