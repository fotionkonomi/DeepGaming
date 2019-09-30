package al.edu.fti.gaming.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.MotherboardConverter;
import al.edu.fti.gaming.dao.MotherboardRepository;
import al.edu.fti.gaming.dto.MotherboardDTO;
import al.edu.fti.gaming.exception.MotherboardNotFoundException;
import al.edu.fti.gaming.exception.ProductsNotFoundException;
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
	public MotherboardDTO getMotherboardById(int id) {
		Motherboard motherboard = motherboardRepository.getMotherboardById(id);
		if (motherboard == null) {
			throw new MotherboardNotFoundException(id);
		} else {
			return (MotherboardDTO) motherboardConverter.toDTO(motherboard);
		}
	}

	@Override
	public Long countMotherboardsInStock() {
		return motherboardRepository.countMotherboardsInStock();
	}

	@Override
	public List<MotherboardDTO> getAllMotherboardsInStock(int page, int numberOfItemsOnThePage) {
		page--;
		List<Motherboard> motherboardModels = motherboardRepository.getAllMotherboardsInStock(page,
				numberOfItemsOnThePage);
		if (motherboardModels == null || motherboardModels.isEmpty()) {
			throw new ProductsNotFoundException();
		}
		return convertList(motherboardModels);
	}

	private List<MotherboardDTO> convertList(List<Motherboard> motherboardModels) {
		List<MotherboardDTO> motherboardDTOs = new ArrayList<MotherboardDTO>();
		for (Motherboard motherboard : motherboardModels) {
			MotherboardDTO motherboardDTO = (MotherboardDTO) motherboardConverter.toDTO(motherboard);
			motherboardDTOs.add(motherboardDTO);
		}
		return motherboardDTOs;
	}

	@Override
	public void update(MotherboardDTO motherboardDTO, int id) throws ParseException {
		Motherboard motherboard = motherboardRepository.getMotherboardById(id);
		motherboardDTO.setId(id);
		generalService.convertStringToDate(motherboardDTO);
		motherboardDTO.setProductType(productTypeService.getMotherboardProductType());
		motherboardDTO.setEditedDate(new Date());
		motherboardDTO.setUploadDate(motherboard.getUploadDate());
		motherboardRepository.update((Motherboard) motherboardConverter.toModel(motherboardDTO));
	}
	

	@Override
	public void preMotherboardSave(MotherboardDTO motherboardDTO) throws ParseException {
		generalService.convertStringToDate(motherboardDTO);
		motherboardDTO.setProductType(productTypeService.getMotherboardProductType());
		motherboardDTO.setUploadDate(new Date());
		motherboardDTO.setEditedDate(new Date());
	}
}
