package al.edu.fti.gaming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import al.edu.fti.gaming.controller.ProductTypeConverter;
import al.edu.fti.gaming.dao.ProductTypeRepository;
import al.edu.fti.gaming.dto.ProductTypeDTO;
import al.edu.fti.gaming.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	@Autowired
	@Qualifier("productTypeConverter")
	private ProductTypeConverter productTypeConverter;
	
	@Override
	public ProductTypeDTO getCpuProductType() {
		return (ProductTypeDTO) productTypeConverter.toDTO(productTypeRepository.getCpuProductType());
	}

	@Override
	public ProductTypeDTO getGpuProductType() {
		return (ProductTypeDTO) productTypeConverter.toDTO(productTypeRepository.getGpuProductType());

	}

	@Override
	public ProductTypeDTO getGameProductType() {
		return (ProductTypeDTO) productTypeConverter.toDTO(productTypeRepository.getGameProductType());

	}

	@Override
	public ProductTypeDTO getMotherboardProductType() {
		return (ProductTypeDTO) productTypeConverter.toDTO(productTypeRepository.getMotherboardProductType());

	}

}
