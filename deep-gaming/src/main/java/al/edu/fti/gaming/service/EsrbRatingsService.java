package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.EsrbRatingsDTO;

public interface EsrbRatingsService {

	int add(EsrbRatingsDTO esrbRatingsDTO);
	
	List<EsrbRatingsDTO> getAllEsrbRatingsDTO();
	
	EsrbRatingsDTO getEsrbRatingById(int id);
	
	boolean update(EsrbRatingsDTO esrbRatingsDTO);
}
