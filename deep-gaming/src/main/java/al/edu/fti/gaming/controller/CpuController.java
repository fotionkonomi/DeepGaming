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
import al.edu.fti.gaming.dto.CpuArchitectureDTO;
import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.CpuFamilyDTO;
import al.edu.fti.gaming.dto.CpuSocketDTO;
import al.edu.fti.gaming.exception.CpuArchitectureNotFoundException;
import al.edu.fti.gaming.exception.CpuFamilyNotFoundException;
import al.edu.fti.gaming.exception.CpuNotFoundException;
import al.edu.fti.gaming.exception.CpuSocketNotFoundException;
import al.edu.fti.gaming.exception.ProductsNotFoundException;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.service.CpuArchitectureService;
import al.edu.fti.gaming.service.CpuFamilyService;
import al.edu.fti.gaming.service.CpuService;
import al.edu.fti.gaming.service.CpuSocketService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.utils.CpuArchitectureEditor;
import al.edu.fti.gaming.utils.CpuFamilyEditor;
import al.edu.fti.gaming.utils.CpuSocketEditor;
import al.edu.fti.gaming.utils.Messages;
import al.edu.fti.gaming.validator.CpuValidator;

@Controller
@RequestMapping("/cpu")
public class CpuController implements HandlerExceptionResolver {

	@Autowired
	private GeneralService generalService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private CpuService cpuService;

	@Autowired
	private CpuFamilyEditor cpuFamilyEditor;

	@Autowired
	private CpuArchitectureEditor cpuArchitectureEditor;

	@Autowired
	private CpuSocketEditor cpuSocketEditor;

	@Autowired
	private CpuValidator cpuValidator;

	@Autowired
	private CpuArchitectureService cpuArchitectureService;

	@Autowired
	private CpuSocketService cpuSocketService;

	@Autowired
	private CpuFamilyService cpuFamilyService;

	@Autowired
	private Messages messages;

	@InitBinder /* Converts empty strings into null when a form is submitted */
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(CpuFamilyDTO.class, this.cpuFamilyEditor);
		binder.registerCustomEditor(CpuArchitectureDTO.class, this.cpuArchitectureEditor);
		binder.registerCustomEditor(CpuSocketDTO.class, this.cpuSocketEditor);
		binder.setValidator(cpuValidator);
	}

	@RequestMapping("/chooseCompany")
	public String chooseCompany(Model model) {
		List<CompanyDTO> companies = companyService.getAllCompanies();
		model.addAttribute("companies", companies);
		return "cpu/chooseCompany";
	}

	@RequestMapping(value = "/chooseSocketArchitectureFamily", method = RequestMethod.GET)
	public String chooseSocketArchitectureFamily(Model model, @RequestParam("company") String company) {
		model.addAttribute("company", company);
		model.addAttribute("cpuFamilies", cpuFamilyService.getCpuFamiliesByCompany(company));
		model.addAttribute("cpuArchitectures", cpuArchitectureService.getCpuArchitecturesByCompany(company));
		model.addAttribute("cpuSockets", cpuSocketService.getCpuSocketsByCompany(company));
		model.addAttribute("errorOrNot", true);
		return "cpu/chooseSocketArchitectureFamily";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model, @RequestParam("cpuFamily") Integer cpuFamily,
			@RequestParam("cpuArchitecture") Integer cpuArchitecture, @RequestParam("cpuSocket") Integer cpuSocket,
			@RequestParam("company") String company) {
		CpuFamilyDTO cpuFamilyDTO;
		try {
			cpuFamilyDTO = cpuFamilyService.getCpuFamilyById(cpuFamily);
		} catch (CpuFamilyNotFoundException e) {
			cpuFamilyDTO = null;
		}

		CpuArchitectureDTO cpuArchitectureDTO;

		try {
			cpuArchitectureDTO = cpuArchitectureService.getCpuArchitectureById(cpuArchitecture);
		} catch (CpuArchitectureNotFoundException e) {
			cpuArchitectureDTO = null;
		}

		CpuSocketDTO cpuSocketDTO;
		try {
			cpuSocketDTO = cpuSocketService.getCpuSocketById(cpuSocket);
		} catch (CpuSocketNotFoundException e) {
			cpuSocketDTO = null;
		}

		if (cpuFamilyDTO == null || cpuArchitectureDTO == null || cpuSocketDTO == null
				|| !cpuFamilyDTO.getCompanyOfThisCpuFamily()
						.equals(cpuArchitectureDTO.getCompanyOfThisCpuArchitecture())
				|| !cpuFamilyDTO.getCompanyOfThisCpuFamily().equals(cpuSocketDTO.getCompanyOfThisSocket())
				|| !cpuArchitectureDTO.getCompanyOfThisCpuArchitecture()
						.equals(cpuSocketDTO.getCompanyOfThisSocket())) {
			model.addAttribute("cpuFamilies", cpuFamilyService.getCpuFamiliesByCompany(company));
			model.addAttribute("cpuArchitectures", cpuArchitectureService.getCpuArchitecturesByCompany(company));
			model.addAttribute("cpuSockets", cpuSocketService.getCpuSocketsByCompany(company));
			model.addAttribute("errorOrNot", null);
			model.addAttribute("company", company);

			return "/cpu/chooseSocketArchitectureFamily";
		}

		model.addAttribute("cpuFamily", cpuFamily);
		model.addAttribute("cpuArchitecture", cpuArchitecture);
		model.addAttribute("cpuSocket", cpuSocket);
		model.addAttribute("company", company);
		CpuDTO cpuDTO = new CpuDTO();
		model.addAttribute("newCpu", cpuDTO);

		return "/cpu/addCpu";
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int cpuId, Model model) {
		model.addAttribute("cpu", cpuService.getCpuById(cpuId));
		return "/cpu/details";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute("newCpu") @Valid CpuDTO cpuDTO, BindingResult result,
			HttpServletRequest request) throws ParseException {
		ModelAndView mav;
		if (result.hasErrors()) {

			mav = cpuService.getModelWithRequestParameters(request.getQueryString());

			mav.setViewName("cpu/addCpu");
			return mav;
		}

		mav = new ModelAndView();
		cpuService.preCpuSave(cpuDTO, request.getQueryString());
		cpuService.add(cpuDTO);
		generalService.imageProcessing(cpuDTO, request.getSession().getServletContext().getRealPath("/"), true);
		mav.setViewName("redirect:/cpu/details?id=" + cpuDTO.getId());

		return mav;
	}

	@RequestMapping(value = "/cpus")
	public String list(Model model, @RequestParam("page") int currentPage) {
		List<Integer> pageNumbers = new ArrayList<Integer>();
		int numberOfItemsOnThePage = 6;
		Long numberOfCpus = cpuService.countOfCpusInStock();
		for (int i = 1; i < numberOfCpus; i++) {
			if (i % 3 == 0) {
				pageNumbers.add(i / 3);
			}

		}
		if (numberOfCpus > pageNumbers.size() * numberOfItemsOnThePage) {
			pageNumbers.add(pageNumbers.size() + 1);
		}
		model.addAttribute("numberOfItemsOnThePage", numberOfItemsOnThePage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("count", numberOfCpus);
		model.addAttribute("cpus", cpuService.getAllCpusInStock(currentPage, numberOfItemsOnThePage));
		return "cpu/cpus";
	}

	@RequestMapping(value = "/chooseCpuToCompare")
	public String chooseCpuToCompare(Model model, @RequestParam("cpu") int cpuId) {
		CpuDTO cpuDTO = cpuService.getCpuById(cpuId);
		model.addAttribute("cpu", cpuDTO);
		model.addAttribute("companies", companyService.getAllCompaniesThatHaveCpuFamilies());
		return "cpu/chooseCpuToCompare";
	}

	@RequestMapping(value = "/compare")
	public String compare(Model model, @RequestParam("cpu1") int cpu1, @RequestParam("cpu2") int cpu2) {
		CpuDTO cpuDTO1 = cpuService.getCpuById(cpu1);
		CpuDTO cpuDTO2 = cpuService.getCpuById(cpu2);
		if (cpuDTO1.getCpuBenchmark() >= cpuDTO2.getCpuBenchmark()) {
			model.addAttribute("cpu1", cpuDTO1);
			model.addAttribute("cpu2", cpuDTO2);
		} else {
			model.addAttribute("cpu2", cpuDTO1);
			model.addAttribute("cpu1", cpuDTO2);
		}

		return "cpu/compare";

	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int cpuId, Model model) {
		CpuDTO cpuDTO = cpuService.getCpuById(cpuId);
		model.addAttribute("cpu", cpuDTO );
		return "cpu/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCompany(@ModelAttribute("cpu") @Valid CpuDTO cpuDTO, BindingResult result,
			HttpServletRequest request, @RequestParam("id") int id) throws ParseException {
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), cpuDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));
		
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			return "/cpu/update";
		} else {

			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(cpuDTO, request.getSession().getServletContext().getRealPath("/"),
						false);
			}
		    cpuService.update(cpuDTO, id);
				return "redirect:/cpu/details?id=" + cpuDTO.getId();
			

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
		return "cpu/noProductsFound";
	}

	@ExceptionHandler(CpuNotFoundException.class)
	public String handleNoProductsFound(Model model, HttpServletRequest request, CpuNotFoundException exception) {
		String queryString = request.getQueryString();
		int indexOfCpu = queryString.indexOf("cpu=");
		int finalIndex = queryString.indexOf("&");
		if (finalIndex == -1) {
			finalIndex = queryString.length();
		}
		String cpu = queryString.substring(indexOfCpu + 4, finalIndex);
		model.addAttribute("cpu", cpu);
		return "cpu/noProductsFound";
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
