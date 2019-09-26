package al.edu.fti.gaming.utils;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.EsrbRatingsDTO;
import al.edu.fti.gaming.service.EsrbRatingsService;

@Component
public class EsrbRatingsEditor extends PropertyEditorSupport {

	@Autowired
	private EsrbRatingsService esrbRatingsService;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			Integer id = Integer.parseInt(text);
			EsrbRatingsDTO esrbRatingsDTO = this.esrbRatingsService.getEsrbRatingById(id);

			this.setValue(esrbRatingsDTO);
		} catch (NumberFormatException e) {
			return;
		}
	}
}
