package al.edu.fti.gaming.converter;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.GpuMemoryTechnologyDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.GpuMemoryTechnology;
import al.edu.fti.gaming.models.IModel;

@Component
public class GpuMemoryTechnologyConverter implements Converter {

	@Override
	public IDto toDTO(IModel modelObject) {
		GpuMemoryTechnology gpuMemoryTechnology = (GpuMemoryTechnology) modelObject;
		GpuMemoryTechnologyDTO gpuMemoryTechnologyDTO = new GpuMemoryTechnologyDTO();
		gpuMemoryTechnologyDTO.setId(gpuMemoryTechnology.getIdGpuMemoryTechnology());
		gpuMemoryTechnologyDTO.setName(gpuMemoryTechnology.getGpuMemoryTechnologyName());
		gpuMemoryTechnologyDTO.setDescription(gpuMemoryTechnology.getGpuMemoryTechnologyDescription());
		return gpuMemoryTechnologyDTO;
	}

	@Override
	public IModel toModel(IDto dtoObject) {
		GpuMemoryTechnology gpuMemoryTechnology = new GpuMemoryTechnology();
		GpuMemoryTechnologyDTO gpuMemoryTechnologyDTO = (GpuMemoryTechnologyDTO) dtoObject;
		if (gpuMemoryTechnologyDTO.getId() != null) {
			gpuMemoryTechnology.setIdGpuMemoryTechnology(gpuMemoryTechnologyDTO.getId());
		}
		gpuMemoryTechnology.setGpuMemoryTechnologyName(gpuMemoryTechnologyDTO.getName());
		gpuMemoryTechnology.setGpuMemoryTechnologyDescription(gpuMemoryTechnologyDTO.getDescription());
		return gpuMemoryTechnology;
	}
}
