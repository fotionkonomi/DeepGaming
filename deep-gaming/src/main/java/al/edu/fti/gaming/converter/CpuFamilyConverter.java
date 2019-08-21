package al.edu.fti.gaming.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.dto.CpuFamilyDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.Company;
import al.edu.fti.gaming.models.CpuFamily;
import al.edu.fti.gaming.models.IModel;

@Component
public class CpuFamilyConverter implements Converter {

	@Autowired
	@Qualifier("companyConverter")
	private Converter companyConverter;

	@Override
	public IModel toModel(IDto dtoObject) {
		CpuFamily cpuFamily = new CpuFamily();
		CpuFamilyDTO cpuFamilyDTO = (CpuFamilyDTO) dtoObject;
		if (cpuFamilyDTO.getId() != null) {
			cpuFamily.setIdCpuFamily(cpuFamilyDTO.getId());
		}
		cpuFamily.setCpuFamilyName(cpuFamilyDTO.getName());
		cpuFamily.setCpuFamilyDescription(cpuFamilyDTO.getDescription());
		cpuFamily.setCompanyOfThisCpuFamily(
				(Company) companyConverter.toModel(cpuFamilyDTO.getCompanyOfThisCpuFamily()));
		return cpuFamily;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		CpuFamily cpuFamily = (CpuFamily) modelObject;
		CpuFamilyDTO cpuFamilyDTO = new CpuFamilyDTO();
		cpuFamilyDTO.setId(cpuFamily.getIdCpuFamily());
		cpuFamilyDTO.setName(cpuFamily.getCpuFamilyName());
		cpuFamilyDTO.setDescription(cpuFamily.getCpuFamilyDescription());
		cpuFamilyDTO
				.setCompanyOfThisCpuFamily((CompanyDTO) companyConverter.toDTO(cpuFamily.getCompanyOfThisCpuFamily()));
		return cpuFamilyDTO;
	}

}
