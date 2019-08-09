package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.Chipset;

public interface ChipsetRepository {

	int add(Chipset chipset);
	
	List<Chipset> getAllChipsets();
	
	Chipset getChipsetById(int id);
	
	boolean update(Chipset chipset);
}
