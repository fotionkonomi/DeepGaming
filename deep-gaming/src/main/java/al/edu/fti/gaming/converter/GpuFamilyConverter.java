package al.edu.fti.gaming.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.dto.GpuFamilyDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.Company;
import al.edu.fti.gaming.models.GpuFamily;
import al.edu.fti.gaming.models.IModel;

@Component
public class GpuFamilyConverter implements Converter{

	@Autowired
	@Qualifier("companyConverter")
	private Converter companyConverter;
	
	@Override
	public IModel toModel(IDto dtoObject) {
		GpuFamily gpuFamily = new GpuFamily();
		GpuFamilyDTO gpuFamilyDTO = (GpuFamilyDTO) dtoObject;
		if(gpuFamilyDTO.getId() != null) {
			gpuFamily.setIdGpuFamily(gpuFamilyDTO.getId());
		}
		gpuFamily.setGpuFamilyName(gpuFamilyDTO.getName());
		gpuFamily.setGpuFamilyDescription(gpuFamilyDTO.getDescription());
		gpuFamily.setCompanyOfThisGpuFamily((Company) companyConverter.toModel(gpuFamilyDTO.getCompanyOfThisGpuFamily()));
		return gpuFamily;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		GpuFamily gpuFamily = (GpuFamily) modelObject;
		GpuFamilyDTO gpuFamilyDTO = new GpuFamilyDTO();
		gpuFamilyDTO.setId(gpuFamily.getIdGpuFamily());
		gpuFamilyDTO.setName(gpuFamily.getGpuFamilyName());
		gpuFamilyDTO.setDescription(gpuFamily.getGpuFamilyDescription());
		gpuFamilyDTO.setCompanyOfThisGpuFamily((CompanyDTO) companyConverter.toDTO(gpuFamily.getCompanyOfThisGpuFamily()));
		return gpuFamilyDTO;
	}

}
