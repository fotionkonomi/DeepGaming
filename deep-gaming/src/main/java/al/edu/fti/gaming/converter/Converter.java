package al.edu.fti.gaming.converter;

import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.IModel;

public interface Converter {

	IModel toModel(IDto dtoObject);

	IDto toDTO(IModel modelObject);
}
