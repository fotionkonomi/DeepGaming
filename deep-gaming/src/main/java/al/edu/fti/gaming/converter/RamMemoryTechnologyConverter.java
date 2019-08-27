package al.edu.fti.gaming.converter;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.dto.RamMemoryTechnologyDTO;
import al.edu.fti.gaming.models.IModel;
import al.edu.fti.gaming.models.RamMemoryTechnology;

@Component
public class RamMemoryTechnologyConverter implements Converter {

	@Override
	public IModel toModel(IDto dtoObject) {
		RamMemoryTechnology ramMemoryTechnology = new RamMemoryTechnology();
		RamMemoryTechnologyDTO ramMemoryTechnologyDTO = (RamMemoryTechnologyDTO) dtoObject;
		if (ramMemoryTechnologyDTO.getId() != null) {
			ramMemoryTechnology.setIdRamMemoryTechnology(ramMemoryTechnologyDTO.getId());
		}
		ramMemoryTechnology.setRamMemoryTechnologyName(ramMemoryTechnologyDTO.getName());
		ramMemoryTechnology.setRamMemoryTechnologyDescription(ramMemoryTechnologyDTO.getDescription());
		return ramMemoryTechnology;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		RamMemoryTechnologyDTO ramMemoryTechnologyDTO = new RamMemoryTechnologyDTO();
		RamMemoryTechnology ramMemoryTechnology = (RamMemoryTechnology) modelObject;
		ramMemoryTechnologyDTO.setId(ramMemoryTechnology.getIdRamMemoryTechnology());
		ramMemoryTechnologyDTO.setName(ramMemoryTechnology.getRamMemoryTechnologyName());
		ramMemoryTechnologyDTO.setDescription(ramMemoryTechnology.getRamMemoryTechnologyDescription());
		return ramMemoryTechnologyDTO;
	}

}
