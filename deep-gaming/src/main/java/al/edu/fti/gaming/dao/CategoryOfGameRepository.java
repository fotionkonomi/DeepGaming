package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.CategoryOfGame;

public interface CategoryOfGameRepository {

	int add(CategoryOfGame categoryOfGame);

	List<CategoryOfGame> getAllCategories();

	CategoryOfGame getCategoryById(int id);

	boolean update(CategoryOfGame categoryOfGame);

}
