package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.GpuFamily;

public interface GpuFamilyRepository {

	int add(GpuFamily gpuFamily);
	
	List<GpuFamily> getAllGpuFamilies();
	
	GpuFamily getGpuFamilyById(int id);
	
	boolean update(GpuFamily gpuFamily);
	
	List<GpuFamily> getGpuFamiliesByCompany(String companyName);
}
