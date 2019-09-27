package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.MotherboardFormFactorRepository;
import al.edu.fti.gaming.dto.MotherboardFormFactorDTO;
import al.edu.fti.gaming.exception.MotherboardFormFactorNotFoundException;
import al.edu.fti.gaming.models.MotherboardFormFactor;
import al.edu.fti.gaming.service.MotherboardFormFactorService;

@Service
@Transactional
public class MotherboardFormFactorServiceImpl implements MotherboardFormFactorService {

	@Autowired
	@Qualifier("motherboardFormFactorConverter")
	private Converter motherboardFormFactorConverter;

	@Autowired
	private MotherboardFormFactorRepository motherboardFormFactorRepository;

	@Override
	public int add(MotherboardFormFactorDTO motherboardFormFactorDTO) {
		MotherboardFormFactor motherboardFormFactor = (MotherboardFormFactor) motherboardFormFactorConverter
				.toModel(motherboardFormFactorDTO);
		int retVal = motherboardFormFactorRepository.add(motherboardFormFactor);
		if (retVal != 0) {
			motherboardFormFactorDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<MotherboardFormFactorDTO> getAllMotherboardFormFactors() {
		List<MotherboardFormFactor> motherboardFormFactors = motherboardFormFactorRepository
				.getAllMotherboardFormFactors();
		return convertList(motherboardFormFactors);
	}

	@Override
	public MotherboardFormFactorDTO getMotherboardFormFactorById(int id) {
		MotherboardFormFactor motherboardFormFactor = motherboardFormFactorRepository.getMotherboardFormFactorById(id);
		if (motherboardFormFactor == null) {
			throw new MotherboardFormFactorNotFoundException(id);
		} else {
			return (MotherboardFormFactorDTO) motherboardFormFactorConverter.toDTO(motherboardFormFactor);
		}
	}

	@Override
	public boolean update(MotherboardFormFactorDTO motherboardFormFactorDTO) {
		return motherboardFormFactorRepository
				.update((MotherboardFormFactor) motherboardFormFactorConverter.toModel(motherboardFormFactorDTO));
	}

	private List<MotherboardFormFactorDTO> convertList(List<MotherboardFormFactor> motherboardFormFactors) {
		List<MotherboardFormFactorDTO> motherboardFormFactorDTOs = new ArrayList<MotherboardFormFactorDTO>();
		for (MotherboardFormFactor motherboardFormFactor : motherboardFormFactors) {
			motherboardFormFactorDTOs
					.add((MotherboardFormFactorDTO) motherboardFormFactorConverter.toDTO(motherboardFormFactor));
		}
		return motherboardFormFactorDTOs;
	}

	@Override
	public Map<Integer, String> getAllMotherboardFormFactorsMap() {
		Map<Integer, String> allMotherboardFormFactorsMap = new HashMap<Integer, String>();
		for (MotherboardFormFactorDTO motherboardFormFactorDTO : getAllMotherboardFormFactors()) {
			allMotherboardFormFactorsMap.put(motherboardFormFactorDTO.getId(), motherboardFormFactorDTO.getName());
		}
		return allMotherboardFormFactorsMap;
	}

}
