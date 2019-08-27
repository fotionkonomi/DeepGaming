package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.EsrbRatings;

public interface EsrbRatingsRepository {

	int add(EsrbRatings esrbRatings);
	
	List<EsrbRatings> getAllEsrbRatings();
	
	EsrbRatings getEsrbRatingsById(int id);
	
	boolean update(EsrbRatings esrbRatings);
}
