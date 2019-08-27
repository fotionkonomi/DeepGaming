package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.GpuBenchmarkType;

public interface GpuBenchmarkTypeRepository {

	int add(GpuBenchmarkType benchmarkType);

	List<GpuBenchmarkType> getAllBenchmarkTypes();

	GpuBenchmarkType getBenchmarkTypeById(int id);

	boolean update(GpuBenchmarkType benchmarkType);
}
