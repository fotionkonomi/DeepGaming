package al.edu.fti.gaming.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddSocketForm(Model model) {
		CompanyDTO companyDTO = new CompanyDTO();
		model.addAttribute("newCompany", companyDTO);
		return "addCompany";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newCompany") CompanyDTO companyDTO, HttpServletRequest request) {
		MultipartFile companyImage = companyDTO.getImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		rootDirectory += "resources\\img\\";
		System.out.println(rootDirectory);
		String imageLocation = rootDirectory + "company" + companyDTO.getName() + ".png";
		if (companyImage != null && !companyImage.isEmpty()) {
			try {
				companyImage.transferTo(new File(imageLocation));
			} catch (Exception e) {
				throw new RuntimeException("Company Image saving failed");
			}
		}
		if (companyService.add(companyDTO)) {
			return "redirect:/company/companies";
		} else {
			return "redirect:/company/add?error";
		}

	}

	@RequestMapping("/companies")
	public String list(Model model) {
		model.addAttribute("companies", companyService.getAllCompanies());
		return "companies";
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
}
