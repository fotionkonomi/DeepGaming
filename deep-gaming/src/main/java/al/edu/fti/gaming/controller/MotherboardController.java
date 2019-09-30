package al.edu.fti.gaming.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.dto.CpuSocketDTO;
import al.edu.fti.gaming.dto.GpuSlotDTO;
import al.edu.fti.gaming.dto.MotherboardDTO;
import al.edu.fti.gaming.dto.MotherboardFormFactorDTO;
import al.edu.fti.gaming.dto.UserDTO;
import al.edu.fti.gaming.exception.CpuNotFoundException;
import al.edu.fti.gaming.exception.MotherboardNotFoundException;
import al.edu.fti.gaming.exception.ProductsNotFoundException;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.service.CpuSocketService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.GpuSlotService;
import al.edu.fti.gaming.service.MotherboardFormFactorService;
import al.edu.fti.gaming.service.MotherboardService;
import al.edu.fti.gaming.utils.CompanyEditor;
import al.edu.fti.gaming.utils.CpuSocketEditor;
import al.edu.fti.gaming.utils.GpuSlotEditor;
import al.edu.fti.gaming.utils.Messages;
import al.edu.fti.gaming.utils.MotherboardFormFactorEditor;
import al.edu.fti.gaming.validator.MotherboardValidator;

@Controller
@RequestMapping("/motherboard")
public class MotherboardController {

	@Autowired
	private MotherboardService motherboardService;

	@Autowired
	private MotherboardFormFactorService motherboardFormFactorService;

	@Autowired
	private CpuSocketService cpuSocketService;

	@Autowired
	private GpuSlotService gpuSlotService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private Messages messages;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private CompanyEditor companyEditor;

	@Autowired
	private CpuSocketEditor cpuSocketEditor;

	@Autowired
	private GpuSlotEditor gpuSlotEditor;

	@Autowired
	private MotherboardFormFactorEditor motherboardFormFactorEditor;

	@Autowired
	private MotherboardValidator motherboardValidator;

	@InitBinder /* Converts empty strings into null when a form is submitted */
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));

		binder.registerCustomEditor(CompanyDTO.class, this.companyEditor);
		binder.registerCustomEditor(GpuSlotDTO.class, this.gpuSlotEditor);
		binder.registerCustomEditor(CpuSocketDTO.class, this.cpuSocketEditor);
		binder.registerCustomEditor(MotherboardFormFactorDTO.class, this.motherboardFormFactorEditor);

		binder.setValidator(motherboardValidator);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) {
		MotherboardDTO motherboardDTO = new MotherboardDTO();
		model.addAttribute("newMotherboard", motherboardDTO);
		model.addAttribute("allCpuSockets", cpuSocketService.getAllCpuSocketsMap());
		model.addAttribute("allGpuSlots", gpuSlotService.getAllGpuSlotsMap());
		model.addAttribute("allMotherboardFormFactors", motherboardFormFactorService.getAllMotherboardFormFactorsMap());
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());
		return "/motherboard/addMotherboard";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute("newMotherboard") @Valid MotherboardDTO motherboardDTO,
			BindingResult result, HttpServletRequest request) throws ParseException {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.addObject("allCpuSockets", cpuSocketService.getAllCpuSocketsMap());
			mav.addObject("allGpuSlots", gpuSlotService.getAllGpuSlotsMap());
			mav.addObject("allMotherboardFormFactors", motherboardFormFactorService.getAllMotherboardFormFactorsMap());
			mav.addObject("allCompanies", generalService.getAllCompaniesMap());
			mav.setViewName("/motherboard/addMotherboard");
			return mav;
		}
		motherboardService.preMotherboardSave(motherboardDTO);
		int add = motherboardService.add(motherboardDTO);
		System.out.println("Added : " + add);
		generalService.imageProcessing(motherboardDTO, request.getSession().getServletContext().getRealPath("/"), true);
		mav.setViewName("redirect:/motherboard/details?id=" + motherboardDTO.getId());
		return mav;
	}

	@RequestMapping("/details")
	public String details(@RequestParam("id") int motherboardId, Model model) {
		MotherboardDTO motherboardDTO = motherboardService.getMotherboardById(motherboardId);
		model.addAttribute("motherboard", motherboardDTO);
		return "/motherboard/details";
	}

	@RequestMapping(value = "/motherboards")
	public String list(Model model, @RequestParam("page") int currentPage) {
		List<Integer> pageNumbers = new ArrayList<Integer>();
		int numberOfItemsOnThePage = 6;
		Long numberOfMotherboards = motherboardService.countMotherboardsInStock();
		for (int i = 1; i < numberOfMotherboards; i++) {
			if (i % 3 == 0) {
				pageNumbers.add(i / 3);
			}

		}
		if (numberOfMotherboards > pageNumbers.size() * numberOfItemsOnThePage) {
			pageNumbers.add(pageNumbers.size() + 1);
		}

		model.addAttribute("numberOfItemsOnThePage", numberOfItemsOnThePage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("pageNumbers", pageNumbers);
		model.addAttribute("count", numberOfMotherboards);
		model.addAttribute("motherboards",
				motherboardService.getAllMotherboardsInStock(currentPage, numberOfItemsOnThePage));
		return "/motherboard/motherboards";
	}

	@RequestMapping("/update")
	public String update(@RequestParam("id") int motherboardId, Model model) {
		MotherboardDTO motherboardDTO = motherboardService.getMotherboardById(motherboardId);
		model.addAttribute("motherboard", motherboardDTO);
		model.addAttribute("allCpuSockets", cpuSocketService.getAllCpuSocketsMap());
		model.addAttribute("allGpuSlots", gpuSlotService.getAllGpuSlotsMap());
		model.addAttribute("allMotherboardFormFactors", motherboardFormFactorService.getAllMotherboardFormFactorsMap());
		model.addAttribute("allCompanies", generalService.getAllCompaniesMap());
		return "/motherboard/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateMotherboard(@ModelAttribute("motherboard") @Valid MotherboardDTO motherboardDTO,
			BindingResult result, HttpServletRequest request, @RequestParam("id") int id) throws ParseException {
		ModelAndView mav = new ModelAndView();
		List<ObjectError> listOfErrorsWithoutImageError = generalService.listOfErrorsWithoutImageError(
				result.getAllErrors(), motherboardDTO.getImage(), messages.get("al.edu.fti.gaming.validator.image"));
		if (!listOfErrorsWithoutImageError.isEmpty()) {
			mav.addObject("allCpuSockets", cpuSocketService.getAllCpuSocketsMap());
			mav.addObject("allGpuSlots", gpuSlotService.getAllGpuSlotsMap());
			mav.addObject("allMotherboardFormFactors", motherboardFormFactorService.getAllMotherboardFormFactorsMap());
			mav.addObject("allCompanies", generalService.getAllCompaniesMap());
			mav.setViewName("/motherboard/update");
			return mav;
		} else {
			if (listOfErrorsWithoutImageError.size() == result.getAllErrors().size()) {
				generalService.imageProcessing(motherboardDTO,
						request.getSession().getServletContext().getRealPath("/"), false);
			}
			motherboardService.update(motherboardDTO, id);
			mav.setViewName("redirect:/motherboard/details?id=" + motherboardDTO.getId());
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
		model.addAttribute("noProductInThisPage", messages.get("Cpus.NotFound"));
		return "motherboard/noProductsFound";
	}

	@ExceptionHandler(MotherboardNotFoundException.class)
	public String handleNoProductsFound(Model model, HttpServletRequest request,
			MotherboardNotFoundException exception) {
		model.addAttribute("noProductInThisPage", messages.get("motherboard.noCpuFound"));
		return "motherboard/noProductsFound";
	}
}