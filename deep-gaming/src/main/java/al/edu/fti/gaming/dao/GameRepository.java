package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.Game;

public interface GameRepository {

	int add(Game game);
	
	Game getGameById(int id);

	List<Game> getAllGamesInStock(int page, int numberOfItemsOnThePage);
	
	Long countGames();
	
	void update(Game game);
	
}
