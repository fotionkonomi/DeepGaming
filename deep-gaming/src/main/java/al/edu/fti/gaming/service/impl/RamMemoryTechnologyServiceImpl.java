package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.RamMemoryTechnologyRepository;
import al.edu.fti.gaming.dto.RamMemoryTechnologyDTO;
import al.edu.fti.gaming.exception.RamMemoryTechnologyNotFoundException;
import al.edu.fti.gaming.models.RamMemoryTechnology;
import al.edu.fti.gaming.service.RamMemoryTechnologyService;

@Service
@Transactional
public class RamMemoryTechnologyServiceImpl implements RamMemoryTechnologyService {

	@Autowired
	@Qualifier("ramMemoryTechnologyConverter")
	private Converter ramMemoryTechnologyConverter;

	@Autowired
	private RamMemoryTechnologyRepository ramMemoryTechnologyRepository;

	@Override
	public int add(RamMemoryTechnologyDTO ramMemoryTechnologyDTO) {
		RamMemoryTechnology ramMemoryTechnology = (RamMemoryTechnology) ramMemoryTechnologyConverter
				.toModel(ramMemoryTechnologyDTO);
		int retVal = this.ramMemoryTechnologyRepository.add(ramMemoryTechnology);
		if (retVal != 0) {
			ramMemoryTechnologyDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<RamMemoryTechnologyDTO> getAllRamMemoryTechnologies() {
		List<RamMemoryTechnology> ramMemoryTechnologyModels = ramMemoryTechnologyRepository
				.getAllRamMemoryTechnologies();
		return convertList(ramMemoryTechnologyModels);

	}

	@Override
	public RamMemoryTechnologyDTO getRamMemoryTechnologyById(int id) {
		RamMemoryTechnology ramMemoryTechnology = ramMemoryTechnologyRepository.getRamMemoryTechnologyById(id);
		if (ramMemoryTechnology == null) {
			throw new RamMemoryTechnologyNotFoundException(id);
		} else {
			return (RamMemoryTechnologyDTO) ramMemoryTechnologyConverter.toDTO(ramMemoryTechnology);
		}
	}

	@Override
	public boolean update(RamMemoryTechnologyDTO ramMemoryTechnologyDTO) {
		return ramMemoryTechnologyRepository
				.update((RamMemoryTechnology) ramMemoryTechnologyConverter.toModel(ramMemoryTechnologyDTO));
	}

	private List<RamMemoryTechnologyDTO> convertList(List<RamMemoryTechnology> ramMemoryTechnologyModels) {
		List<RamMemoryTechnologyDTO> ramMemoryTechnologyDTOs = new ArrayList<RamMemoryTechnologyDTO>();
		for (RamMemoryTechnology ramMemoryTechnology : ramMemoryTechnologyModels) {
			ramMemoryTechnologyDTOs
					.add((RamMemoryTechnologyDTO) ramMemoryTechnologyConverter.toDTO(ramMemoryTechnology));
		}
		return ramMemoryTechnologyDTOs;
	}
}
