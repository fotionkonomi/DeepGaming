package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.CategoryOfGameDTO;

public interface CategoryOfGameService {

	int add(CategoryOfGameDTO categoryOfGameDTO);
	
	List<CategoryOfGameDTO> getAllCategories();
	
	CategoryOfGameDTO getCategoryById(int id);
	
	boolean update(CategoryOfGameDTO categoryOfGameDTO);
}
