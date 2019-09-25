package al.edu.fti.gaming.service;

import al.edu.fti.gaming.dto.ProductTypeDTO;

public interface ProductTypeService {

	ProductTypeDTO getCpuProductType();

	ProductTypeDTO getGpuProductType();

	ProductTypeDTO getGameProductType();

	ProductTypeDTO getMotherboardProductType();}
