package al.edu.fti.gaming.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.dto.GpuArchitectureDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.Company;
import al.edu.fti.gaming.models.GpuArchitecture;
import al.edu.fti.gaming.models.IModel;

@Component
public class GpuArchitectureConverter implements Converter {

	@Autowired
	@Qualifier("companyConverter")
	private Converter companyConverter;

	@Override
	public IModel toModel(IDto dtoObject) {
		GpuArchitecture gpuArchitecture = new GpuArchitecture();
		GpuArchitectureDTO gpuArchitectureDTO = (GpuArchitectureDTO) dtoObject;
		if (gpuArchitectureDTO.getId() != null) {
			gpuArchitecture.setIdGpuArchitecture(gpuArchitectureDTO.getId());
		}
		gpuArchitecture.setGpuArchitectureName(gpuArchitectureDTO.getName());
		gpuArchitecture.setGpuArchitectureDescription(gpuArchitectureDTO.getDescription());
		gpuArchitecture.setGpuProcessNanometers(gpuArchitectureDTO.getGpuProcessNanometers());
		gpuArchitecture.setCompanyOfThisGpuArchitecture(
				(Company) companyConverter.toModel(gpuArchitectureDTO.getCompanyOfThisGpuArchitecture()));
		return gpuArchitecture;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		GpuArchitectureDTO gpuArchitectureDTO = new GpuArchitectureDTO();
		GpuArchitecture gpuArchitecture = (GpuArchitecture) modelObject;
		gpuArchitectureDTO.setId(gpuArchitecture.getIdGpuArchitecture());
		gpuArchitectureDTO.setName(gpuArchitecture.getGpuArchitectureName());
		gpuArchitectureDTO.setDescription(gpuArchitecture.getGpuArchitectureDescription());
		gpuArchitectureDTO.setGpuProcessNanometers(gpuArchitecture.getGpuProcessNanometers());
		gpuArchitectureDTO.setCompanyOfThisGpuArchitecture(
				(CompanyDTO) companyConverter.toDTO(gpuArchitecture.getCompanyOfThisGpuArchitecture()));
		return gpuArchitectureDTO;
	}

}
