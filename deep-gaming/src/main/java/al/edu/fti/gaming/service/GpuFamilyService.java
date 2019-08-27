package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.GpuFamilyDTO;

public interface GpuFamilyService {
	
	int add(GpuFamilyDTO gpuFamilyDTO);

	List<GpuFamilyDTO> getAllGpuFamilies();

	GpuFamilyDTO getGpuFamilyById(int id);

	boolean update(GpuFamilyDTO gpuFamilyDTO);

	List<GpuFamilyDTO> getGuFamiliesByCompany(String companyName);
}
