package al.edu.fti.gaming.converter;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.EsrbRatingsDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.models.EsrbRatings;
import al.edu.fti.gaming.models.IModel;

@Component
public class EsrbRatingsConverter implements Converter {

	@Override
	public IModel toModel(IDto dtoObject) {
		EsrbRatings esrbRatings = new EsrbRatings();
		EsrbRatingsDTO esrbRatingsDTO = (EsrbRatingsDTO) dtoObject;
		if(esrbRatingsDTO.getId() != null) {
			esrbRatings.setIdEsrbRating(esrbRatingsDTO.getId());
		}
		esrbRatings.setEsrbRatingName(esrbRatingsDTO.getName());
		esrbRatings.setEsrbRatingDescription(esrbRatingsDTO.getDescription());
		return esrbRatings;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		EsrbRatings esrbRatings = (EsrbRatings) modelObject;
		EsrbRatingsDTO esrbRatingsDTO = new EsrbRatingsDTO();
		esrbRatingsDTO.setId(esrbRatings.getIdEsrbRating());
		esrbRatingsDTO.setName(esrbRatings.getEsrbRatingName());
		esrbRatingsDTO.setDescription(esrbRatings.getEsrbRatingDescription());
		return esrbRatingsDTO;
	}

	
}
