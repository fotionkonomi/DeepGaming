package al.edu.fti.gaming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.MotherboardConverter;
import al.edu.fti.gaming.dao.MotherboardRepository;
import al.edu.fti.gaming.dto.MotherboardDTO;
import al.edu.fti.gaming.models.Motherboard;
import al.edu.fti.gaming.service.MotherboardService;

@Service
@Transactional
public class MotherboardServiceImpl implements MotherboardService {

	@Autowired
	private MotherboardRepository motherboardRepository;

	@Autowired
	@Qualifier("motherboardConverter")
	private MotherboardConverter motherboardConverter;

	@Override
	public int add(MotherboardDTO motherboardDTO) {
		Motherboard motherboard = (Motherboard) motherboardConverter.toModel(motherboardDTO);
		int retVal = motherboardRepository.add(motherboard);
		if (retVal != 0) {
			motherboardDTO.setId(retVal);
		}
		return retVal;

	}

}
