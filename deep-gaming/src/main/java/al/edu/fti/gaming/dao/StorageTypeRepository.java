package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.StorageType;

public interface StorageTypeRepository {

	int add(StorageType storageType);
	
	List<StorageType> getAllStorageTypes();
	
	StorageType getStorageTypeById(int id);
	
	boolean update(StorageType storageType);
}
