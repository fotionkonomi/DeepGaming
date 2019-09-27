package al.edu.fti.gaming.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
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

	@InitBinder /* Converts empty strings into null when a form is submitted */
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(CompanyDTO.class, this.companyEditor);
		binder.registerCustomEditor(GpuSlotDTO.class, this.gpuSlotEditor);
		binder.registerCustomEditor(CpuSocketDTO.class, this.cpuSocketEditor);
		binder.registerCustomEditor(MotherboardFormFactorDTO.class, this.motherboardFormFactorEditor);
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

}