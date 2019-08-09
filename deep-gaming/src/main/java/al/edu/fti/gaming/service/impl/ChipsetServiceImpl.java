package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.ChipsetRepository;
import al.edu.fti.gaming.dto.ChipsetDTO;
import al.edu.fti.gaming.exception.ChipsetNotFoundException;
import al.edu.fti.gaming.models.Chipset;
import al.edu.fti.gaming.service.ChipsetService;

@Service
@Transactional
public class ChipsetServiceImpl implements ChipsetService {

	@Autowired
	private ChipsetRepository chipsetRepository;

	@Autowired
	@Qualifier("chipsetConverter")
	private Converter chipsetConverter;

	@Override
	public int add(ChipsetDTO chipsetDTO) {
		Chipset chipset = (Chipset) chipsetConverter.toModel(chipsetDTO);
		int retVal = this.chipsetRepository.add(chipset);
		if (retVal != 0) {
			chipsetDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<ChipsetDTO> getAllChipsets() {
		List<Chipset> chipsetModels = chipsetRepository.getAllChipsets();
		List<ChipsetDTO> chipsetDTOs = new ArrayList<ChipsetDTO>();
		for (Chipset chipset : chipsetModels) {
			ChipsetDTO chipsetDTO = (ChipsetDTO) chipsetConverter.toDTO(chipset);
			chipsetDTOs.add(chipsetDTO);
		}
		return chipsetDTOs;
	}

	@Override
	public ChipsetDTO getChipsetById(int id) {
		Chipset chipset = chipsetRepository.getChipsetById(id);
		if (chipset == null) {
			throw new ChipsetNotFoundException(id);
		} else {
			return (ChipsetDTO) chipsetConverter.toDTO(chipset);
		}
	}

	@Override
	public boolean update(ChipsetDTO chipsetDTO) {
		return this.chipsetRepository.update((Chipset) chipsetConverter.toModel(chipsetDTO));
	}

}
