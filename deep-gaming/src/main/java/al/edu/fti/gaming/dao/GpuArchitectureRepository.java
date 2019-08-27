package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.GpuArchitecture;

public interface GpuArchitectureRepository {

	int add(GpuArchitecture gpuArchitecture);
	
	List<GpuArchitecture> getAllGpuArchitectures();
	
	GpuArchitecture getGpuArchitectureById(int id);
	
	boolean update(GpuArchitecture gpuArchitecture);
	
	List<GpuArchitecture> getGpuArchitecturesByCompany(String companyName);
}
