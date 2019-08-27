package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.CpuBenchmarkType;

public interface CpuBenchmarkTypeRepository {

	int add(CpuBenchmarkType benchmarkType);
	
	List<CpuBenchmarkType> getAllBenchmarkTypes();
	
	CpuBenchmarkType getBenchmarkTypeById(int id);
	
	boolean update(CpuBenchmarkType benchmarkType);
}
