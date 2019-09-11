package al.edu.fti.gaming.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.service.CpuArchitectureService;
import al.edu.fti.gaming.service.CpuFamilyService;
import al.edu.fti.gaming.service.CpuSocketService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.GpuArchitectureService;
import al.edu.fti.gaming.service.GpuFamilyService;
import al.edu.fti.gaming.service.GpuService;
import al.edu.fti.gaming.service.GpuSlotService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/gpu")
public class GpuController implements HandlerExceptionResolver {

	private GeneralService generalService;
	
	private CompanyService companyService;
	
	private GpuService gpuService;
	
	@Autowired
	private GpuArchitectureService gpuArchitectureService;

	@Autowired
	private GpuSlotService gpuSlotService;

	@Autowired
	private GpuFamilyService gpuFamilyService;

	@Autowired
	private Messages messages;
	
	@InitBinder /* Converts empty strings into null when a form is submitted */
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@RequestMapping("/chooseCompany")
	public String chooseCompany(Model model) {
		List<CompanyDTO> companies = companyService.getAllCompanies();
		model.addAttribute("companies", companies);
		return "gpu/chooseCompany";
	}

	@RequestMapping(value = "/chooseSocketArchitectureFamily", method = RequestMethod.GET)
	public String chooseSlotArchitectureFamily(Model model, @RequestParam("company") String company) {
		model.addAttribute("company", company);
		model.addAttribute("gpuFamilies", gpuFamilyService.getGuFamiliesByCompany(company));
		model.addAttribute("gpuArchitectures", gpuArchitectureService.getGpuArchitecturesByCompany(company));
		model.addAttribute("gpuSlots", gpuSlotService.getAllGpuSlots());
		model.addAttribute("errorOrNot", true);
		return "cpu/chooseSocketArchitectureFamily";
	}

	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
