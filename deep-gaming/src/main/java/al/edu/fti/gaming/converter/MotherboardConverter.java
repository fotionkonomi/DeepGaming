package al.edu.fti.gaming.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.controller.ProductTypeConverter;
import al.edu.fti.gaming.dto.CompanyDTO;
import al.edu.fti.gaming.dto.CpuSocketDTO;
import al.edu.fti.gaming.dto.GpuSlotDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.dto.MotherboardDTO;
import al.edu.fti.gaming.dto.MotherboardFormFactorDTO;
import al.edu.fti.gaming.dto.ProductTypeDTO;
import al.edu.fti.gaming.models.Company;
import al.edu.fti.gaming.models.CpuSocket;
import al.edu.fti.gaming.models.GpuSlot;
import al.edu.fti.gaming.models.IModel;
import al.edu.fti.gaming.models.Motherboard;
import al.edu.fti.gaming.models.MotherboardFormFactor;
import al.edu.fti.gaming.models.ProductType;

@Component
public class MotherboardConverter implements Converter {

	@Autowired
	@Qualifier("companyConverter")
	private CompanyConverter companyConverter;

	@Autowired
	@Qualifier("cpuSocketConverter")
	private CpuSocketConverter cpuSocketConverter;

	@Autowired
	@Qualifier("motherboardFormFactorConverter")
	private MotherboardFormFactorConverter motherboardFormFactorConverter;

	@Autowired
	@Qualifier("gpuSlotConverter")
	private GpuSlotConverter gpuSlotConverter;

	@Autowired
	@Qualifier("productTypeConverter")
	private ProductTypeConverter productTypeConverter;

	@Override
	public IModel toModel(IDto dtoObject) {
		Motherboard motherboard = new Motherboard();
		MotherboardDTO motherboardDTO = (MotherboardDTO) dtoObject;
		if (motherboardDTO.getId() != null) {
			motherboard.setIdProduct(motherboard.getIdProduct());
		}
		motherboard.setProductName(motherboardDTO.getName());
		motherboard.setProductDescription(motherboardDTO.getDescription());
		motherboard.setHyperlink(motherboardDTO.getHyperlink());
		motherboard.setPrice(motherboardDTO.getPrice());
		motherboard.setQuantity(motherboardDTO.getQuantity());
		motherboard.setReleaseDate(motherboardDTO.getReleaseDate());
		motherboard.setUploadDate(motherboardDTO.getUploadDate());
		motherboard.setEditedDate(motherboardDTO.getEditedDate());
		motherboard.setProductType((ProductType) productTypeConverter.toModel(motherboardDTO.getProductType()));
		motherboard.setMaximumRamCapacity(motherboardDTO.getMaximumRamCapacity());
		motherboard.setMaximumRamSpeed(motherboardDTO.getMaximumRamSpeed());
		motherboard.setCompanyOfThisMotherboard(
				(Company) companyConverter.toModel(motherboardDTO.getCompanyOfThisMotherboard()));
		motherboard.setCpuSocketOfThisMotherboard(
				(CpuSocket) cpuSocketConverter.toModel(motherboardDTO.getCpuSocketOfThisMotherboard()));
		motherboard.setFormFactorOfThisMotherboard((MotherboardFormFactor) motherboardFormFactorConverter
				.toModel(motherboardDTO.getFormFactorOfThisMotherboard()));
		motherboard.setGpuSlot((GpuSlot) gpuSlotConverter.toModel(motherboardDTO.getGpuSlotOfThisMotherboard()));

		return motherboard;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		Motherboard motherboard = (Motherboard) modelObject;
		MotherboardDTO motherboardDTO = new MotherboardDTO();
		motherboardDTO.setId(motherboard.getIdProduct());
		motherboardDTO.setName(motherboard.getProductName());
		motherboardDTO.setDescription(motherboard.getProductDescription());
		motherboardDTO.setHyperlink(motherboard.getHyperlink());
		motherboardDTO.setPrice(motherboard.getPrice());
		motherboardDTO.setQuantity(motherboard.getQuantity());
		motherboardDTO.setReleaseDate(motherboard.getReleaseDate());
		motherboardDTO.setUploadDate(motherboard.getUploadDate());
		motherboardDTO.setEditedDate(motherboard.getEditedDate());
		motherboardDTO.setProductType((ProductTypeDTO) productTypeConverter.toDTO(motherboard.getProductType()));
		motherboardDTO.setMaximumRamCapacity(motherboard.getMaximumRamCapacity());
		motherboardDTO.setMaximumRamSpeed(motherboard.getMaximumRamSpeed());
		motherboardDTO.setCompanyOfThisMotherboard(
				(CompanyDTO) companyConverter.toDTO(motherboard.getCompanyOfThisMotherboard()));
		motherboardDTO.setCpuSocketOfThisMotherboard(
				(CpuSocketDTO) cpuSocketConverter.toDTO(motherboard.getCpuSocketOfThisMotherboard()));
		motherboardDTO.setFormFactorOfThisMotherboard((MotherboardFormFactorDTO) motherboardFormFactorConverter
				.toDTO(motherboard.getFormFactorOfThisMotherboard()));
		motherboardDTO.setGpuSlotOfThisMotherboard((GpuSlotDTO) gpuSlotConverter.toDTO(motherboard.getGpuSlot()));

		return motherboardDTO;
	}

}
