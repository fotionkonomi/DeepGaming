package al.edu.fti.gaming.converter;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.DirectXDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.DirectX;
import al.edu.fti.gaming.models.IModel;

@Component
public class DirectXConverter implements Converter {

	@Override
	public IModel toModel(IDto dtoObject) {
		DirectX directX = new DirectX();
		DirectXDTO directXDTO = (DirectXDTO) dtoObject;
		if(directXDTO.getId() != null) {
			directX.setIdDirectX(directXDTO.getId());
		}
		directX.setDirectXType(directXDTO.getName());
		directX.setDirectXDescription(directXDTO.getDescription());
		return directX;
	} 

	@Override
	public IDto toDTO(IModel modelObject) {
		DirectX directX = (DirectX) modelObject;
		DirectXDTO directXDTO = new DirectXDTO();
		directXDTO.setId(directX.getIdDirectX());
		directXDTO.setName(directX.getDirectXType());
		directXDTO.setDescription(directX.getDirectXDescription());
		return directXDTO;
	}

	
}
