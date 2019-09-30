package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.Motherboard;

public interface MotherboardRepository {

	int add(Motherboard motherboard);
	
	Motherboard getMotherboardById(int id);
	
	Long countMotherboardsInStock();
	
	List<Motherboard> getAllMotherboardsInStock(int page, int numberOfItemsOnThePage);
	
	void update(Motherboard motherboard);
	
}
