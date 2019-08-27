package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.RamMemoryTechnologyDTO;

public interface RamMemoryTechnologyService {

	int add(RamMemoryTechnologyDTO ramMemoryTechnologyDTO);
	
	List<RamMemoryTechnologyDTO> getAllRamMemoryTechnologies();
	
	RamMemoryTechnologyDTO getRamMemoryTechnologyById(int id);
	
	boolean update(RamMemoryTechnologyDTO ramMemoryTechnologyDTO);
	
}
