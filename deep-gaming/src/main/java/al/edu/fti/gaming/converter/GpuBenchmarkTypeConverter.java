package al.edu.fti.gaming.converter;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.GpuBenchmarkTypeDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.GpuBenchmarkType;
import al.edu.fti.gaming.models.IModel;

@Component
public class GpuBenchmarkTypeConverter  implements Converter{

	@Override
	public IModel toModel(IDto dtoObject) {
		GpuBenchmarkType gpuBenchmarkType = new GpuBenchmarkType();
		GpuBenchmarkTypeDTO gpuBenchmarkTypeDTO = (GpuBenchmarkTypeDTO) dtoObject;
		if (gpuBenchmarkTypeDTO.getId() != null) {
			gpuBenchmarkType.setIdGpuBenchmarkType(gpuBenchmarkTypeDTO.getId());
		}
		gpuBenchmarkType.setGpuBenchmarkTypeName(gpuBenchmarkTypeDTO.getName());
		gpuBenchmarkType.setGpuBenchmarkTypeDescription(gpuBenchmarkTypeDTO.getDescription());
		return gpuBenchmarkType;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		GpuBenchmarkTypeDTO gpuBenchmarkTypeDTO = new GpuBenchmarkTypeDTO();
		GpuBenchmarkType gpuBenchmarkType = (GpuBenchmarkType) modelObject;
		gpuBenchmarkTypeDTO.setId(gpuBenchmarkType.getIdGpuBenchmarkType());
		gpuBenchmarkTypeDTO.setName(gpuBenchmarkType.getGpuBenchmarkTypeName());
		gpuBenchmarkTypeDTO.setDescription(gpuBenchmarkType.getGpuBenchmarkTypeDescription());
		return gpuBenchmarkTypeDTO;
	}
}
