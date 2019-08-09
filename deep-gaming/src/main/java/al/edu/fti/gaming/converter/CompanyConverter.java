package al.edu.fti.gaming.converter;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.Company;
import al.edu.fti.gaming.models.IModel;

@Component
public class CompanyConverter implements Converter {

	private static final Logger LOGGER = Logger.getLogger(CompanyConverter.class.getName());

	@Override
	public IModel toModel(IDto dtoObject) {
		Company company = new Company();
		CompanyDTO companyDTO = (CompanyDTO) dtoObject;
		LOGGER.log(Level.INFO, "Starting the conversion from CompanyDTO to Company:\n");
		LOGGER.log(Level.INFO, "|-----------------------------------------------------------------------");
		if (companyDTO.getId() != null) {
			company.setIdCompany(companyDTO.getId());
			LOGGER.log(Level.INFO, "1) The id has been converted.");
		} else {
			LOGGER.log(Level.INFO, "1) The id in the dto object was null, so an auto-increment will happen.");
		}
		company.setCompanyName(companyDTO.getName());
		LOGGER.log(Level.INFO, "2) The name has been converted.");
		company.setCompanyDescription(companyDTO.getDescription());
		LOGGER.log(Level.INFO, "3) The description has been converted.");
		company.setHyperlink(companyDTO.getHyperlink());
		LOGGER.log(Level.INFO, "4) The hyperlink has been converted.");
		LOGGER.log(Level.INFO, "The conversion has finished successfully!");
		LOGGER.log(Level.INFO, "-----------------------------------------------------------------------|");

		return company;

	}

	@Override
	public IDto toDTO(IModel modelObject) {
		CompanyDTO companyDTO = new CompanyDTO();
		Company company = (Company) modelObject;
		LOGGER.log(Level.INFO, "Starting the conversion from Company to CompanyDTO:");
		LOGGER.log(Level.INFO, "|----------------------------------------------------------------------");
		companyDTO.setId(company.getIdCompany());
		LOGGER.log(Level.INFO, "1) The id has been converted.");
		companyDTO.setName(company.getCompanyName());
		LOGGER.log(Level.INFO, "2) The name has been converted.");
		companyDTO.setDescription(company.getCompanyDescription());
		LOGGER.log(Level.INFO, "3) The description has been converted");
		companyDTO.setHyperlink(company.getHyperlink());
		LOGGER.log(Level.INFO, "4) The hyperlink has been converted.");
		LOGGER.log(Level.INFO, "The conversion has finished successfully");
		LOGGER.log(Level.INFO, "---------------------------------------------------------------------|.");
		return companyDTO;

	}

}
