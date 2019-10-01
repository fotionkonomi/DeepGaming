package al.edu.fti.gaming.dao;

import al.edu.fti.gaming.models.Game;

public interface GameRepository {

	int add(Game game);
	
	Game getGameById(int id);
}
