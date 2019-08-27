package al.edu.fti.gaming.converter;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.GpuSlotDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.GpuSlot;
import al.edu.fti.gaming.models.IModel;

@Component
public class GpuSlotConverter implements Converter {

	@Override
	public IModel toModel(IDto dtoObject) {
		GpuSlot gpuSlot = new GpuSlot();
		GpuSlotDTO gpuSlotDTO = (GpuSlotDTO) dtoObject;
		if (gpuSlotDTO.getId() != null) {
			gpuSlot.setIdGpuSlot(gpuSlotDTO.getId());
		}
		gpuSlot.setGpuSlotName(gpuSlotDTO.getName());
		gpuSlot.setGpuSlotDescription(gpuSlotDTO.getDescription());
		gpuSlot.setLaptopOrDesktop(gpuSlotDTO.getLaptopOrDesktop());
		return gpuSlot;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		GpuSlot gpuSlot = (GpuSlot) modelObject;
		GpuSlotDTO gpuSlotDTO = new GpuSlotDTO();
		gpuSlotDTO.setId(gpuSlot.getIdGpuSlot());
		gpuSlotDTO.setName(gpuSlot.getGpuSlotName());
		gpuSlotDTO.setDescription(gpuSlot.getGpuSlotDescription());
		gpuSlotDTO.setLaptopOrDesktop(gpuSlot.getLaptopOrDesktop());
		return gpuSlotDTO;
	}

}
