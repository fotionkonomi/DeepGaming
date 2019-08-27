package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.GpuArchitectureDTO;

public interface GpuArchitectureService {

	int add(GpuArchitectureDTO gpuArchitecture);
	
	List<GpuArchitectureDTO> getAllGpuArchitectures();
	
	GpuArchitectureDTO getGpuArchitectureById(int id);
	
	boolean update(GpuArchitectureDTO gpuArchitectureDTO);
	
	List<GpuArchitectureDTO> getGpuArchitecturesByCompany(String companyName);
}
