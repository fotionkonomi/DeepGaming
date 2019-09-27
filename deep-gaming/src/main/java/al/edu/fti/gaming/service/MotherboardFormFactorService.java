package al.edu.fti.gaming.service;

import java.util.List;
import java.util.Map;

import al.edu.fti.gaming.dto.MotherboardFormFactorDTO;

public interface MotherboardFormFactorService {

	int add(MotherboardFormFactorDTO motherboardFormFactorDTO);
	
	List<MotherboardFormFactorDTO> getAllMotherboardFormFactors();
	
	MotherboardFormFactorDTO getMotherboardFormFactorById(int id);
	
	boolean update(MotherboardFormFactorDTO motherboardFormFactorDTO);
	
	Map<Integer, String> getAllMotherboardFormFactorsMap();
}
