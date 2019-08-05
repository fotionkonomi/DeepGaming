package al.edu.fti.gaming.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.service.CompanyService;
import al.edu.fti.gaming.utils.Messages;

@Controller
@RequestMapping("/company")
public class CompanyController implements HandlerExceptionResolver {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private Messages messages; 
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCompanyForm(Model model) {
		CompanyDTO companyDTO = new CompanyDTO();
		model.addAttribute("newCompany", companyDTO);
		return "addCompany";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processForm(@ModelAttribute("newCompany") @Valid CompanyDTO companyDTO, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addCompany";
		}
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

	@RequestMapping(value = "/companies",  method = RequestMethod.GET)
	public String allCompanies(Model model) {
		model.addAttribute("companies", companyService.getAllCompanies());
		return "companies";
	}
	
	
	 public ModelAndView resolveException(HttpServletRequest request,
	            HttpServletResponse response, Object handler, Exception exception)
	    {        
	        Map<String, Object> model = new HashMap<String, Object>();
	        if (exception instanceof MaxUploadSizeExceededException)
	        {
	            model.put("errors", messages.get("addCompany.form.image.error.size.afterSubmit"));
	        }
	        CompanyDTO companyDTO = new CompanyDTO();
	        model.put("newCompany", companyDTO );
	        return new ModelAndView("addCompany", model);
	    }

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}
}
