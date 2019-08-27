package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.EsrbRatingsRepository;
import al.edu.fti.gaming.dto.EsrbRatingsDTO;
import al.edu.fti.gaming.exception.EsrbRatingNotFoundException;
import al.edu.fti.gaming.models.EsrbRatings;
import al.edu.fti.gaming.service.EsrbRatingsService;

@Service
@Transactional
public class EsrbRatingsServiceImpl implements EsrbRatingsService {

	@Autowired
	private EsrbRatingsRepository esrbRatingsRepository;

	@Autowired
	@Qualifier("esrbRatingsConverter")
	private Converter esrbRatingsConverter;

	@Override
	public int add(EsrbRatingsDTO esrbRatingsDTO) {
		EsrbRatings esrbRatings = (EsrbRatings) esrbRatingsConverter.toModel(esrbRatingsDTO);
		int retVal = esrbRatingsRepository.add(esrbRatings);
		if (retVal != 0) {
			esrbRatingsDTO.setId(retVal);
		}
		return retVal;

	}

	@Override
	public List<EsrbRatingsDTO> getAllEsrbRatingsDTO() {
		List<EsrbRatings> esrbRatingsModels = esrbRatingsRepository.getAllEsrbRatings();
		return convertList(esrbRatingsModels);
	}

	@Override
	public EsrbRatingsDTO getEsrbRatingById(int id) {
		EsrbRatings esrbRatings = esrbRatingsRepository.getEsrbRatingsById(id);
		if (esrbRatings == null) {
			throw new EsrbRatingNotFoundException(id);
		} else {
			return (EsrbRatingsDTO) esrbRatingsConverter.toDTO(esrbRatings);
		}
	}

	@Override
	public boolean update(EsrbRatingsDTO esrbRatingsDTO) {
		return this.esrbRatingsRepository.update((EsrbRatings) esrbRatingsConverter.toModel(esrbRatingsDTO));
	}

	private List<EsrbRatingsDTO> convertList(List<EsrbRatings> esrbRatingsModels) {
		List<EsrbRatingsDTO> esrbRatingsDTOs = new ArrayList<EsrbRatingsDTO>();
		for (EsrbRatings esrbRatings : esrbRatingsModels) {
			EsrbRatingsDTO esrbRatingsDTO = (EsrbRatingsDTO) esrbRatingsConverter.toDTO(esrbRatings);
			esrbRatingsDTOs.add(esrbRatingsDTO);
		}
		return esrbRatingsDTOs;
	}

}
