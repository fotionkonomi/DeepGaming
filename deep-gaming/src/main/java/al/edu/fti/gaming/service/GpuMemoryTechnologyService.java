package al.edu.fti.gaming.service;

import java.util.List;
import java.util.Map;

import al.edu.fti.gaming.dto.GpuMemoryTechnologyDTO;

public interface GpuMemoryTechnologyService {

	int add(GpuMemoryTechnologyDTO gpuMemoryTechnologyDTO);

	List<GpuMemoryTechnologyDTO> getAllGpuMemoryTechnologies();

	GpuMemoryTechnologyDTO getGpuMemoryTechnologyById(int id);

	boolean update(GpuMemoryTechnologyDTO gpuMemoryTechnologyDTO);

	Map<Integer, String> getAllMemoryTechnologiesMap();

}
