package al.edu.fti.gaming.service.impl;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.MotherboardConverter;
import al.edu.fti.gaming.dao.MotherboardRepository;
import al.edu.fti.gaming.dto.MotherboardDTO;
import al.edu.fti.gaming.exception.MotherboardNotFoundException;
import al.edu.fti.gaming.models.Motherboard;
import al.edu.fti.gaming.service.GeneralService;
import al.edu.fti.gaming.service.MotherboardService;
import al.edu.fti.gaming.service.ProductTypeService;

@Service
@Transactional
public class MotherboardServiceImpl implements MotherboardService {

	@Autowired
	private MotherboardRepository motherboardRepository;

	@Autowired
	@Qualifier("motherboardConverter")
	private MotherboardConverter motherboardConverter;

	@Autowired
	private GeneralService generalService;

	@Autowired
	private ProductTypeService productTypeService;

	@Override
	public int add(MotherboardDTO motherboardDTO) {
		Motherboard motherboard = (Motherboard) motherboardConverter.toModel(motherboardDTO);
		int retVal = motherboardRepository.add(motherboard);
		if (retVal != 0) {
			motherboardDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public void preMotherboardSave(MotherboardDTO motherboardDTO) throws ParseException {
		generalService.convertStringToDate(motherboardDTO);
		motherboardDTO.setProductType(productTypeService.getMotherboardProductType());
		motherboardDTO.setUploadDate(new Date());
		motherboardDTO.setEditedDate(new Date());
	}

	@Override
	public MotherboardDTO getMotherboardById(int id) {
		Motherboard motherboard = motherboardRepository.getMotherboardById(id);
		if (motherboard == null) {
			throw new MotherboardNotFoundException(id);
		} else {
			return (MotherboardDTO) motherboardConverter.toDTO(motherboard);
		}
	}
}
