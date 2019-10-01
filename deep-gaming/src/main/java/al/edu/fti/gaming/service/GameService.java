package al.edu.fti.gaming.service;

import al.edu.fti.gaming.dto.GameDTO;

public interface GameService {

	int add(GameDTO gameDTO);
	
	GameDTO getGameById(int id);
}
