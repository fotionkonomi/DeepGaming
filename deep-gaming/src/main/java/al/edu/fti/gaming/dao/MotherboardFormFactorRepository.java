package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.MotherboardFormFactor;

public interface MotherboardFormFactorRepository {

	int add(MotherboardFormFactor motherboardFormFactor);
	
	List<MotherboardFormFactor> getAllMotherboardFormFactors();
	
	MotherboardFormFactor getMotherboardFormFactorById(int id);
	
	boolean update(MotherboardFormFactor motherboardFormFactor);
}
