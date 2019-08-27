package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.GpuMemoryTechnology;

public interface GpuMemoryTechnologyRepository {

	int add(GpuMemoryTechnology gpuMemoryTechnology);

	List<GpuMemoryTechnology> getAllGpuMemoryTechnologies();

	GpuMemoryTechnology getGpuMemoryTechnologyById(int id);

	boolean update(GpuMemoryTechnology gpuMemoryTechnology);
}
