package al.edu.fti.gaming.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.dto.CpuArchitectureDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.Company;
import al.edu.fti.gaming.models.CpuArchitecture;
import al.edu.fti.gaming.models.IModel;

@Component
public class CpuArchitectureConverter implements Converter {

	@Autowired
	@Qualifier("companyConverter")
	private Converter companyConverter;

	@Override
	public IModel toModel(IDto dtoObject) {
		CpuArchitecture cpuArchitecture = new CpuArchitecture();
		CpuArchitectureDTO cpuArchitectureDTO = (CpuArchitectureDTO) dtoObject;
		if (cpuArchitectureDTO.getId() != null) {
			cpuArchitecture.setIdCpuArchitecture(cpuArchitectureDTO.getId());
		}
		cpuArchitecture.setCpuArchitectureName(cpuArchitectureDTO.getName());
		cpuArchitecture.setCpuArchitectureDescription(cpuArchitectureDTO.getDescription());
		cpuArchitecture.setCpuProcessNanometers(cpuArchitectureDTO.getCpuProcessNanometers());
		cpuArchitecture.setCompanyOfThisCpuArchitecture(
				(Company) companyConverter.toModel(cpuArchitectureDTO.getCompanyOfThisCpuArchitecture()));
		return cpuArchitecture;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		CpuArchitectureDTO cpuArchitectureDTO = new CpuArchitectureDTO();
		CpuArchitecture cpuArchitecture = (CpuArchitecture) modelObject;
		cpuArchitectureDTO.setId(cpuArchitecture.getIdCpuArchitecture());
		cpuArchitectureDTO.setName(cpuArchitecture.getCpuArchitectureName());
		cpuArchitectureDTO.setDescription(cpuArchitecture.getCpuArchitectureDescription());
		cpuArchitectureDTO.setCpuProcessNanometers(cpuArchitecture.getCpuProcessNanometers());
		cpuArchitectureDTO.setCompanyOfThisCpuArchitecture(
				(CompanyDTO) companyConverter.toDTO(cpuArchitecture.getCompanyOfThisCpuArchitecture()));
		return cpuArchitectureDTO;
	}

}
