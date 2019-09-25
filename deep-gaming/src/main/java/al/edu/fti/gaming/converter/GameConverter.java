package al.edu.fti.gaming.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.controller.ProductTypeConverter;
import al.edu.fti.gaming.dto.CategoryOfGameDTO;
import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.DirectXDTO;
import al.edu.fti.gaming.dto.EsrbRatingsDTO;
import al.edu.fti.gaming.dto.GameDTO;
import al.edu.fti.gaming.dto.GpuDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.dto.ProductTypeDTO;
import al.edu.fti.gaming.models.CPU;
import al.edu.fti.gaming.models.CategoryOfGame;
import al.edu.fti.gaming.models.DirectX;
import al.edu.fti.gaming.models.EsrbRatings;
import al.edu.fti.gaming.models.GPU;
import al.edu.fti.gaming.models.Game;
import al.edu.fti.gaming.models.IModel;
import al.edu.fti.gaming.models.ProductType;

@Component
public class GameConverter implements Converter {

	@Autowired
	@Qualifier("productTypeConverter")
	private ProductTypeConverter productTypeConverter;

	@Autowired
	@Qualifier("cpuConverter")
	private CpuConverter cpuConverter;

	@Autowired
	@Qualifier("gpuConverter")
	private GpuConverter gpuConverter;

	@Autowired
	@Qualifier("directXConverter")
	private DirectXConverter directXConverter;

	@Autowired
	@Qualifier("esrbRatingsConverter")
	private EsrbRatingsConverter esrbRatingsConverter;

	@Autowired
	@Qualifier("categoryOfGamesConverter")
	private CategoryOfGamesConverter categoryOfGamesConverter;

	@Override
	public IModel toModel(IDto dtoObject) {
		Game game = new Game();
		GameDTO gameDTO = (GameDTO) dtoObject;
		if (gameDTO.getId() != null) {
			game.setIdProduct(gameDTO.getId());
		}
		game.setProductName(gameDTO.getName());
		game.setProductDescription(gameDTO.getDescription());
		game.setReleaseDate(gameDTO.getReleaseDate());
		game.setPrice(gameDTO.getPrice());
		game.setQuantity(gameDTO.getQuantity());
		game.setUploadDate(gameDTO.getUploadDate());
		game.setEditedDate(gameDTO.getEditedDate());
		game.setHyperlink(gameDTO.getHyperlink());
		game.setProductType((ProductType) productTypeConverter.toModel(gameDTO.getProductType()));
		game.setRamLow(gameDTO.getRamLow());
		game.setRamMedium(gameDTO.getRamMedium());
		game.setRamHigh(gameDTO.getRamHigh());
		game.setCpuLow((CPU) cpuConverter.toModel(gameDTO.getCpuLow()));
		game.setCpuMedium((CPU) cpuConverter.toModel(gameDTO.getCpuMedium()));
		game.setCpuHigh((CPU) cpuConverter.toModel(gameDTO.getCpuHigh()));
		game.setGpuLow((GPU) gpuConverter.toModel(gameDTO.getGpuLow()));
		game.setGpuMedium((GPU) gpuConverter.toModel(gameDTO.getGpuMedium()));
		game.setGpuHigh((GPU) gpuConverter.toModel(gameDTO.getGpuHigh()));
		game.setDirectXMinimum((DirectX) directXConverter.toModel(gameDTO.getDirectXMinimum()));
		game.setEsrbRating((EsrbRatings) esrbRatingsConverter.toModel(gameDTO.getEsrbRating()));
		Set<CategoryOfGame> addingCategoryOfGames = new HashSet<>();
		for (CategoryOfGameDTO categoryOfGameDTO : gameDTO.getCategoryOfGames()) {
			addingCategoryOfGames.add((CategoryOfGame) categoryOfGamesConverter.toModel(categoryOfGameDTO));
		}
		game.setCategoriesOfThisGame(addingCategoryOfGames);
		return game;

	}

	@Override
	public IDto toDTO(IModel modelObject) {
		GameDTO gameDTO = new GameDTO();
		Game game = (Game) modelObject;
		gameDTO.setId(game.getIdProduct());
		gameDTO.setName(game.getProductName());
		gameDTO.setDescription(game.getProductDescription());
		gameDTO.setReleaseDate(game.getReleaseDate());
		gameDTO.setPrice(game.getPrice());
		gameDTO.setQuantity(game.getQuantity());
		gameDTO.setUploadDate(game.getUploadDate());
		gameDTO.setEditedDate(game.getEditedDate());
		gameDTO.setHyperlink(game.getHyperlink());
		gameDTO.setProductType((ProductTypeDTO) productTypeConverter.toDTO(game.getProductType()));
		gameDTO.setRamLow(game.getRamLow());
		gameDTO.setRamMedium(game.getRamMedium());
		gameDTO.setRamHigh(game.getRamHigh());
		gameDTO.setCpuLow((CpuDTO) cpuConverter.toDTO(game.getCpuLow()));
		gameDTO.setCpuMedium((CpuDTO) cpuConverter.toDTO(game.getCpuMedium()));
		gameDTO.setCpuHigh((CpuDTO) cpuConverter.toDTO(game.getCpuHigh()));
		gameDTO.setGpuLow((GpuDTO) gpuConverter.toDTO(game.getGpuLow()));
		gameDTO.setGpuMedium((GpuDTO) gpuConverter.toDTO(game.getGpuMedium()));
		gameDTO.setGpuHigh((GpuDTO) gpuConverter.toDTO(game.getGpuHigh()));
		gameDTO.setDirectXMinimum((DirectXDTO) directXConverter.toDTO(game.getDirectXMinimum()));
		gameDTO.setEsrbRating((EsrbRatingsDTO) esrbRatingsConverter.toDTO(game.getEsrbRating()));
		return gameDTO;
	}

}
