package al.edu.fti.gaming.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

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
import al.edu.fti.gaming.dto.CpuArchitectureDTO;
import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.CpuFamilyDTO;
import al.edu.fti.gaming.dto.CpuSocketDTO;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.service.CpuService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.utils.CpuArchitectureEditor;
import al.edu.fti.gaming.utils.CpuFamilyEditor;
import al.edu.fti.gaming.utils.CpuSocketEditor;

@Controller
@RequestMapping("/cpu")
public class CpuController {

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

	@InitBinder /* Converts empty strings into null when a form is submitted */
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(CpuFamilyDTO.class, this.cpuFamilyEditor);
		binder.registerCustomEditor(CpuArchitectureDTO.class, this.cpuArchitectureEditor);
		binder.registerCustomEditor(CpuSocketDTO.class, this.cpuSocketEditor);

	}

	@RequestMapping("/chooseCompany")
	public String chooseCompany(Model model) {
		List<CompanyDTO> companies = companyService.getAllCompanies();
		model.addAttribute("companies", companies);
		return "cpu/chooseCompany";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model, @RequestParam("company") String company) {
		CpuDTO cpuDTO = new CpuDTO();
		model.addAttribute("newCpu", cpuDTO);
		model.addAttribute("company", company);
		model.addAttribute("cpuFamilies", cpuService.getCpuFamiliesByCompanyName(company));
		model.addAttribute("cpuArchitectures", cpuService.getCpuArchitecturesByCompanyName(company));
		model.addAttribute("cpuSockets", cpuService.getCpuSocketsByCompanyName(company));
		return "/cpu/addCpu";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView processForm(@ModelAttribute("newCpu") @Valid CpuDTO cpuDTO, BindingResult result,
			HttpServletRequest request) throws ParseException {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("cpu/addCpu");

			String company = request.getQueryString();
			int indexOfCompany = company.indexOf("company=");
			int endOfCompanyParameter = company.indexOf("&");
			if (endOfCompanyParameter == -1) {
				endOfCompanyParameter = company.length();
			}
			company = company.substring(indexOfCompany + 8, endOfCompanyParameter);
			mav.addObject("company", company);
			mav.addObject("cpuFamilies", cpuService.getCpuFamiliesByCompanyName(company));
			mav.addObject("cpuArchitectures", cpuService.getCpuArchitecturesByCompanyName(company));
			mav.addObject("cpuSockets", cpuService.getCpuSocketsByCompanyName(company));
			return mav;
		}

		generalService.convertStringToDate(cpuDTO);
		cpuDTO.setUploadDate(new Date());
		cpuDTO.setEditedDate(new Date());
		if (cpuService.add(cpuDTO) != 0) {
			generalService.imageProcessing(cpuDTO, request.getSession().getServletContext().getRealPath("/"), true);
			mav.setViewName("/company/addCompany");
		}

		return mav;
	}

}
