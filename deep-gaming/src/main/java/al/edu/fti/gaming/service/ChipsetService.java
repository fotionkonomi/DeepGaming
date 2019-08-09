package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.ChipsetDTO;

public interface ChipsetService {

	int add(ChipsetDTO chipsetDTO);
	
	List<ChipsetDTO> getAllChipsets();
	
	ChipsetDTO getChipsetById(int id);
	
	boolean update(ChipsetDTO chipsetDTO);
}
