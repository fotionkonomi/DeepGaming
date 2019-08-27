package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.StorageTypeRepository;
import al.edu.fti.gaming.dto.StorageTypeDTO;
import al.edu.fti.gaming.exception.StorageTypeNotFoundException;
import al.edu.fti.gaming.models.StorageType;
import al.edu.fti.gaming.service.StorageTypeService;

@Service
@Transactional
public class StorageTypeServiceImpl implements StorageTypeService {

	@Autowired
	@Qualifier("storageTypeConverter")
	private Converter storageTypeConverter;

	@Autowired
	private StorageTypeRepository storageTypeRepository;

	@Override
	public int add(StorageTypeDTO storageTypeDTO) {
		StorageType storageType = (StorageType) storageTypeConverter.toModel(storageTypeDTO);
		int retVal = storageTypeRepository.add(storageType);
		if (retVal != 0) {
			storageTypeDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<StorageTypeDTO> getAllStorageTypes() {
		List<StorageType> storageTypes = storageTypeRepository.getAllStorageTypes();
		return convertList(storageTypes);

	}

	@Override
	public StorageTypeDTO getStorageTypeById(int id) {
		StorageType storageType = storageTypeRepository.getStorageTypeById(id);
		if (storageType == null) {
			throw new StorageTypeNotFoundException(id);
		} else {
			return (StorageTypeDTO) storageTypeConverter.toDTO(storageType);

		}
	}

	@Override
	public boolean update(StorageTypeDTO storageTypeDTO) {
		return storageTypeRepository.update((StorageType) storageTypeConverter.toModel(storageTypeDTO));
	}

	private List<StorageTypeDTO> convertList(List<StorageType> storageTypes) {
		List<StorageTypeDTO> storageTypeDTOs = new ArrayList<StorageTypeDTO>();
		for (StorageType storageType : storageTypes) {
			storageTypeDTOs.add((StorageTypeDTO) storageTypeConverter.toDTO(storageType));
		}
		return storageTypeDTOs;
	}
}
