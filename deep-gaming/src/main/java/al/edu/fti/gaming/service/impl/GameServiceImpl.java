package al.edu.fti.gaming.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.GameConverter;
import al.edu.fti.gaming.dao.GameRepository;
import al.edu.fti.gaming.dto.GameDTO;
import al.edu.fti.gaming.dto.GpuDTO;
import al.edu.fti.gaming.exception.GameNotFoundException;
import al.edu.fti.gaming.exception.ProductsNotFoundException;
import al.edu.fti.gaming.models.Game;
import al.edu.fti.gaming.service.GameService;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.ProductTypeService;

@Service
@Transactional
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private ProductTypeService productTypeService;

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
		if (game == null) {
			throw new GameNotFoundException(id);
		} else {
			return (GameDTO) gameConverter.toDTO(game);
		}
	}

	@Override
	public void preGameSave(GameDTO gameDTO) throws ParseException {
		generalService.convertStringToDate(gameDTO);
		gameDTO.setProductType(productTypeService.getGameProductType());
		gameDTO.setUploadDate(new Date());
		gameDTO.setEditedDate(new Date());
	}

	@Override
	public Long countGamesInStock() {
		return gameRepository.countGames();
	}

	@Override
	public List<GameDTO> getAllGamesInStock(int page, int numberOfItemsOnThePage) {
		page--;
		List<Game> gameModels = gameRepository.getAllGamesInStock(page, numberOfItemsOnThePage);
		if (gameModels == null || gameModels.isEmpty()) {
			throw new ProductsNotFoundException();
		}
		return convertList(gameModels);
	}

	private List<GameDTO> convertList(List<Game> gameModels) {
		List<GameDTO> gameDTOs = new ArrayList<GameDTO>();
		for (Game game : gameModels) {
			gameDTOs.add((GameDTO) gameConverter.toDTO(game));
		}
		return gameDTOs;
	}

	@Override
	public void update(GameDTO gameDTO, int id) throws ParseException {
		Game game = gameRepository.getGameById(id);
		gameDTO.setId(game.getIdProduct());
		generalService.convertStringToDate(gameDTO);
		gameDTO.setEditedDate(new Date());
		gameDTO.setProductType(productTypeService.getGameProductType());
		
		gameRepository.update((Game) gameConverter.toModel(gameDTO));
	}
}
