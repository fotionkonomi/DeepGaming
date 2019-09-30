package al.edu.fti.gaming.service;

import java.text.ParseException;
import java.util.List;

import al.edu.fti.gaming.dto.MotherboardDTO;

public interface MotherboardService {

	int add(MotherboardDTO motherboardDTO);
	
	void preMotherboardSave(MotherboardDTO motherboardDTO) throws ParseException;
	
	MotherboardDTO getMotherboardById(int id);
	
	Long countMotherboardsInStock();
	
	List<MotherboardDTO> getAllMotherboardsInStock(int page, int numberOfItemsOnThePage);
	
	void update(MotherboardDTO motherboardDTO, int id) throws ParseException;
}
