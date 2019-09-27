package al.edu.fti.gaming.dao;

import al.edu.fti.gaming.models.Motherboard;

public interface MotherboardRepository {

	int add(Motherboard motherboard);
	
	Motherboard getMotherboardById(int id);
}
