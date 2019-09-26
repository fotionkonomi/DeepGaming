package al.edu.fti.gaming.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CategoryOfGameDTO;
import al.edu.fti.gaming.service.CategoryOfGameService;

@Component
public class CategoryOfGamesEditor extends PropertyEditorSupport {

	@Autowired
	private CategoryOfGameService categoryOfGamesService;

	@Override
	public void setAsText(String text) {
		try {
			Integer id = Integer.parseInt(text);
			CategoryOfGameDTO categoryOfGameDTO = categoryOfGamesService.getCategoryById(id);

			this.setValue(categoryOfGameDTO);
		} catch (NumberFormatException e) {
			return;
		}
	}

}
