package al.edu.fti.gaming.converter;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.dto.StorageTypeDTO;
import al.edu.fti.gaming.models.IModel;
import al.edu.fti.gaming.models.StorageType;

@Component
public class StorageTypeConverter implements Converter {

	@Override
	public IModel toModel(IDto dtoObject) {
		StorageType storageType = new StorageType();
		StorageTypeDTO storageTypeDTO = (StorageTypeDTO) dtoObject;
		if (storageTypeDTO.getId() != null) {
			storageType.setIdStorageType(storageTypeDTO.getId());
		}
		storageType.setStorageTypeName(storageTypeDTO.getName());
		storageType.setStorageTypeDescription(storageTypeDTO.getDescription());
		return storageType;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		StorageType storageType = (StorageType) modelObject;
		StorageTypeDTO storageTypeDTO = new StorageTypeDTO();
		storageTypeDTO.setId(storageType.getIdStorageType());
		storageTypeDTO.setName(storageType.getStorageTypeName());
		storageTypeDTO.setDescription(storageType.getStorageTypeDescription());
		return storageTypeDTO;
	}

}
