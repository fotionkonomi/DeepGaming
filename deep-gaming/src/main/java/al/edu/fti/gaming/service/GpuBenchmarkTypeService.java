package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.GpuBenchmarkTypeDTO;

public interface GpuBenchmarkTypeService {

	int add(GpuBenchmarkTypeDTO benchmarkTypeDTO);
	
	List<GpuBenchmarkTypeDTO> getAllBenchmarkTypes();
	
	GpuBenchmarkTypeDTO getBenchmarkTypeById(int id);
	
	boolean update(GpuBenchmarkTypeDTO benchmarkTypeDTO);
}
