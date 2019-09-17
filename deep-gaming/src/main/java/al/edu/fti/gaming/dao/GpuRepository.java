package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.GPU;

public interface GpuRepository {

	int add(GPU gpu);
	
	GPU getGpuById(int id);
	
	List<GPU> getAllGpusInStock(int page, int numberOfItemsOnThePage);
	
	Long countOfGpusInStock();
	
	List<GPU> getGpuByGpuFamily(Integer gpuFamilyId);
	
	List<GPU> getAllGpus();
	
	void update(GPU gpu);
} 
