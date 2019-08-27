package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.DirectXDTO;

public interface DirectXService {

	int add(DirectXDTO directXDTO);
	
	List<DirectXDTO> getAllDirectXs();
	
	DirectXDTO getDirectXById(int id);
	
	boolean update(DirectXDTO directXDTO);
}
