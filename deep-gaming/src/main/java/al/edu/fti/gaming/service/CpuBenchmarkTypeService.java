package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.CpuBenchmarkDTO;
import al.edu.fti.gaming.dto.CpuBenchmarkTypeDTO;

public interface CpuBenchmarkTypeService {

	int add(CpuBenchmarkTypeDTO benchmarkTypeDTO);
	
	List<CpuBenchmarkTypeDTO> getAllBenchmarkTypes();
	
	CpuBenchmarkTypeDTO getBenchmarkTypeById(int id);
	
	boolean update(CpuBenchmarkTypeDTO benchmarkTypeDTO);
}
