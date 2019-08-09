package al.edu.fti.gaming.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.service.CompanyService;

@Component
public class CompanyEditor extends PropertyEditorSupport {

	private @Autowired CompanyService companyService;

	@Override
	public void setAsText(String text) {
		Integer id = Integer.parseInt(text);
		CompanyDTO companyDTO = this.companyService.getCompanyById(id);

		this.setValue(companyDTO);
	}

}
