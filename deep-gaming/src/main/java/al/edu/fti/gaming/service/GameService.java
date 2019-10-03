package al.edu.fti.gaming.service;

import java.text.ParseException;
import java.util.List;

import al.edu.fti.gaming.dto.GameDTO;

public interface GameService {

	int add(GameDTO gameDTO);

	GameDTO getGameById(int id);

	void preGameSave(GameDTO gameDTO) throws ParseException;

	Long countGamesInStock();

	List<GameDTO> getAllGamesInStock(int page, int numberOfItemsOnThePage);

	void update(GameDTO gameDTO, int id) throws ParseException;
}
