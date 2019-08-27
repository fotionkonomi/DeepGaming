package al.edu.fti.gaming.converter;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CpuBenchmarkTypeDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.CpuBenchmarkType;
import al.edu.fti.gaming.models.IModel;

@Component
public class CpuBenchmarkTypeConverter implements Converter {

	@Override
	public IModel toModel(IDto dtoObject) {
		CpuBenchmarkType cpuBenchmarkType = new CpuBenchmarkType();
		CpuBenchmarkTypeDTO cpuBenchmarkTypeDTO = (CpuBenchmarkTypeDTO) dtoObject;
		if (cpuBenchmarkTypeDTO.getId() != null) {
			cpuBenchmarkType.setIdCpuBenchmarkType(cpuBenchmarkTypeDTO.getId());
		}
		cpuBenchmarkType.setCpuBenchmarkTypeName(cpuBenchmarkTypeDTO.getName());
		cpuBenchmarkType.setCpuBenchmarkTypeDescription(cpuBenchmarkTypeDTO.getDescription());
		return cpuBenchmarkType;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		CpuBenchmarkTypeDTO cpuBenchmarkTypeDTO = new CpuBenchmarkTypeDTO();
		CpuBenchmarkType cpuBenchmarkType = (CpuBenchmarkType) modelObject;
		cpuBenchmarkTypeDTO.setId(cpuBenchmarkType.getIdCpuBenchmarkType());
		cpuBenchmarkTypeDTO.setName(cpuBenchmarkType.getCpuBenchmarkTypeName());
		cpuBenchmarkTypeDTO.setDescription(cpuBenchmarkType.getCpuBenchmarkTypeDescription());
		return cpuBenchmarkTypeDTO;
	}

}
