package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.StorageTypeDTO;

public interface StorageTypeService {

	int add(StorageTypeDTO storageTypeDTO);
	
	List<StorageTypeDTO> getAllStorageTypes();
	
	StorageTypeDTO getStorageTypeById(int id);
	
	boolean update(StorageTypeDTO storageTypeDTO);
	
}
