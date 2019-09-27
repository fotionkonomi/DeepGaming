package al.edu.fti.gaming.service;

import java.text.ParseException;

import al.edu.fti.gaming.dto.MotherboardDTO;

public interface MotherboardService {

	int add(MotherboardDTO motherboardDTO);
	
	void preMotherboardSave(MotherboardDTO motherboardDTO) throws ParseException;
	
	MotherboardDTO getMotherboardById(int id);
}
