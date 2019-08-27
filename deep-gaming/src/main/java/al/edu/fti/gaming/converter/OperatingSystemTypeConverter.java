package al.edu.fti.gaming.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.dto.OperatingSystemTypeDTO;
import al.edu.fti.gaming.models.Company;
import al.edu.fti.gaming.models.IModel;
import al.edu.fti.gaming.models.OperatingSystemType;

@Component
public class OperatingSystemTypeConverter implements Converter {

	@Autowired
	@Qualifier("companyConverter")
	private Converter companyConverter;

	@Override
	public IModel toModel(IDto dtoObject) {
		OperatingSystemType operatingSystemType = new OperatingSystemType();
		OperatingSystemTypeDTO operatingSystemTypeDTO = (OperatingSystemTypeDTO) dtoObject;
		if (operatingSystemTypeDTO.getId() != null) {
			operatingSystemType.setIdOperatingSystemType(operatingSystemTypeDTO.getId());
		}
		operatingSystemType.setOperatingSystemTypeName(operatingSystemTypeDTO.getName());
		operatingSystemType.setOperatingSystemTypeDescription(operatingSystemTypeDTO.getDescription());
		operatingSystemType
				.setCompanyOfThisOS((Company) companyConverter.toModel(operatingSystemTypeDTO.getCompanyOfThisOS()));
		return operatingSystemType;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		OperatingSystemType operatingSystemType = (OperatingSystemType) modelObject;
		OperatingSystemTypeDTO operatingSystemTypeDTO = new OperatingSystemTypeDTO();
		operatingSystemTypeDTO.setId(operatingSystemType.getIdOperatingSystemType());
		operatingSystemTypeDTO.setName(operatingSystemType.getOperatingSystemTypeName());
		operatingSystemTypeDTO.setDescription(operatingSystemType.getOperatingSystemTypeDescription());
		operatingSystemTypeDTO
				.setCompanyOfThisOS((CompanyDTO) companyConverter.toDTO(operatingSystemType.getCompanyOfThisOS()));
		return operatingSystemTypeDTO;
	}

}
