package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.CategoryOfGameRepository;
import al.edu.fti.gaming.dto.CategoryOfGameDTO;
import al.edu.fti.gaming.exception.CategoryOfGameNotFoundException;
import al.edu.fti.gaming.models.CategoryOfGame;
import al.edu.fti.gaming.service.CategoryOfGameService;

@Service
@Transactional
public class CategoryOfGameServiceImpl implements CategoryOfGameService {

	private static final Logger LOGGER = Logger.getLogger(CategoryOfGameServiceImpl.class.getName());

	@Autowired
	private CategoryOfGameRepository categoryOfGameRepository;

	@Autowired
	@Qualifier("categoryOfGamesConverter")
	private Converter categoryConverter;

	@Override
	public int add(CategoryOfGameDTO categoryOfGameDTO) {
		CategoryOfGame categoryOfGame = (CategoryOfGame) categoryConverter.toModel(categoryOfGameDTO);
		int retVal = categoryOfGameRepository.add(categoryOfGame);
		if (retVal != 0) {
			categoryOfGameDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<CategoryOfGameDTO> getAllCategories() {
		LOGGER.log(Level.INFO, "Getting all the category models by calling the repository");
		List<CategoryOfGame> categoryModels = categoryOfGameRepository.getAllCategories();
		List<CategoryOfGameDTO> categoryDTOs = new ArrayList<CategoryOfGameDTO>();
		for (CategoryOfGame categoryOfGame : categoryModels) {
			CategoryOfGameDTO categoryOfGameDTO = (CategoryOfGameDTO) categoryConverter.toDTO(categoryOfGame);
			if (categoryOfGameDTO != null) {
				LOGGER.log(Level.INFO, categoryOfGameDTO.getName() + " was converted and added to the list");
				categoryDTOs.add(categoryOfGameDTO);
			} else {
				LOGGER.log(Level.SEVERE, "One object couldn't be converted, process aborted!");
				return null;
			}
		}
		LOGGER.log(Level.INFO, "Process was finished successfully!");
		return categoryDTOs;
	}

	@Override
	public CategoryOfGameDTO getCategoryById(int id) {
		CategoryOfGame categoryOfGame = categoryOfGameRepository.getCategoryById(id);
		if (categoryOfGame == null) {
			throw new CategoryOfGameNotFoundException(id);
		} else {
			return (CategoryOfGameDTO) categoryConverter.toDTO(categoryOfGame);
		}
	}

	@Override
	public boolean update(CategoryOfGameDTO categoryOfGameDTO) {
		return this.categoryOfGameRepository.update((CategoryOfGame) categoryConverter.toModel(categoryOfGameDTO));
	}

	public CategoryOfGameRepository getCategoryOfGameRepository() {
		return categoryOfGameRepository;
	}

	public void setCategoryOfGameRepository(CategoryOfGameRepository categoryOfGameRepository) {
		this.categoryOfGameRepository = categoryOfGameRepository;
	}

	public Converter getCategoryConverter() {
		return categoryConverter;
	}

	public void setCategoryConverter(Converter categoryConverter) {
		this.categoryConverter = categoryConverter;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

}
