package al.edu.fti.gaming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.GameConverter;
import al.edu.fti.gaming.dao.GameRepository;
import al.edu.fti.gaming.dto.GameDTO;
import al.edu.fti.gaming.exception.GameNotFoundException;
import al.edu.fti.gaming.models.Game;
import al.edu.fti.gaming.service.GameService;

@Service
@Transactional
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	@Qualifier("gameConverter")
	private GameConverter gameConverter;

	@Override
	public int add(GameDTO gameDTO) {
		Game game = (Game) gameConverter.toModel(gameDTO);
		int retVal = gameRepository.add(game);
		if (retVal != 0) {
			gameDTO.setId(retVal);
		}
		return retVal;

	}
	
	@Override
	public GameDTO getGameById(int id) {
		Game game = gameRepository.getGameById(id);
		if(game == null) {
			throw new GameNotFoundException(id);
		} else {
			return (GameDTO)gameConverter.toDTO(game);
		}
	}
}
