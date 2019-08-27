package al.edu.fti.gaming.converter;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.dto.MotherboardFormFactorDTO;
import al.edu.fti.gaming.models.IModel;
import al.edu.fti.gaming.models.MotherboardFormFactor;

@Component
public class MotherboardFormFactorConverter implements Converter {

	@Override
	public IModel toModel(IDto dtoObject) {
		MotherboardFormFactor motherboardFormFactor = new MotherboardFormFactor();
		MotherboardFormFactorDTO motherboardFormFactorDTO = (MotherboardFormFactorDTO) dtoObject;
		if (motherboardFormFactorDTO.getId() != null) {
			motherboardFormFactor.setIdMotherboardFormFactor(motherboardFormFactorDTO.getId());
		}
		motherboardFormFactor.setMotherboardFormFactorName(motherboardFormFactorDTO.getName());
		motherboardFormFactor.setMotherboardFormFactorDescription(motherboardFormFactorDTO.getDescription());
		return motherboardFormFactor;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		MotherboardFormFactorDTO motherboardFormFactorDTO = new MotherboardFormFactorDTO();
		MotherboardFormFactor motherboardFormFactor = (MotherboardFormFactor) modelObject;
		motherboardFormFactorDTO.setId(motherboardFormFactor.getIdMotherboardFormFactor());
		motherboardFormFactorDTO.setName(motherboardFormFactor.getMotherboardFormFactorName());
		motherboardFormFactorDTO.setDescription(motherboardFormFactor.getMotherboardFormFactorDescription());
		return motherboardFormFactorDTO;
	}

}
