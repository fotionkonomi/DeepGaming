package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.RamMemoryTechnology;

public interface RamMemoryTechnologyRepository {

	int add(RamMemoryTechnology ramMemoryTechnology);
	
	List<RamMemoryTechnology> getAllRamMemoryTechnologies();
	
	RamMemoryTechnology getRamMemoryTechnologyById(int id);
	
	boolean update(RamMemoryTechnology ramMemoryTechnology);
}
