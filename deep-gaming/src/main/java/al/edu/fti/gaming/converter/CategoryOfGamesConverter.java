package al.edu.fti.gaming.converter;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CategoryOfGameDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.CategoryOfGame;
import al.edu.fti.gaming.models.Company;
import al.edu.fti.gaming.models.IModel;

@Component
public class CategoryOfGamesConverter implements Converter {

	private static final Logger LOGGER = Logger.getLogger(CategoryOfGamesConverter.class.getName());

	@Override
	public IModel toModel(IDto dtoObject) {
		CategoryOfGame categoryOfGame = new CategoryOfGame();
		CategoryOfGameDTO categoryOfGameDTO = (CategoryOfGameDTO) dtoObject;
		LOGGER.log(Level.INFO, "Starting the conversion from CategoryOfGameDTO to CategoryOfGame:\n");
		LOGGER.log(Level.INFO, "|----------------------------------------------------------------------");
		if (categoryOfGameDTO.getId() != null) {
			categoryOfGame.setIdCategory(categoryOfGameDTO.getId());
			LOGGER.log(Level.INFO, "1) The id has been converted.");
		} else {
			LOGGER.log(Level.INFO, "1) The id in the dto object was null, so an auto-increment will happen.");
		}
		categoryOfGame.setCategoryName(categoryOfGameDTO.getName());
		LOGGER.log(Level.INFO, "2) The name has been converted.");
		categoryOfGame.setCategoryDescription(categoryOfGameDTO.getDescription());
		LOGGER.log(Level.INFO, "3) The description has been converted.");

		LOGGER.log(Level.INFO, "The conversion has finished successfully!");
		LOGGER.log(Level.INFO, "-----------------------------------------------------------------------|");

		return categoryOfGame;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		CategoryOfGameDTO categoryOfGameDTO = new CategoryOfGameDTO();
		CategoryOfGame categoryOfGame = (CategoryOfGame) modelObject;
		LOGGER.log(Level.INFO, "Starting the conversion from CategoryOfGame to CategoryOfGameDTO:");
		LOGGER.log(Level.INFO, "|----------------------------------------------------------------------");
		categoryOfGameDTO.setId(categoryOfGame.getIdCategory());
		LOGGER.log(Level.INFO, "1) The id has been converted.");
		categoryOfGameDTO.setName(categoryOfGame.getCategoryName());
		LOGGER.log(Level.INFO, "2) The name has been converted.");
		categoryOfGameDTO.setDescription(categoryOfGame.getCategoryDescription());
		LOGGER.log(Level.INFO, "3) The description has been converted");

		LOGGER.log(Level.INFO, "The conversion has finished successfully");
		LOGGER.log(Level.INFO, "---------------------------------------------------------------------|.");
		return categoryOfGameDTO;
	}
}
