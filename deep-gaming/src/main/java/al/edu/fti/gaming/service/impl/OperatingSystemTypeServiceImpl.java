package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.OperatingSystemTypeRepository;
import al.edu.fti.gaming.dto.OperatingSystemTypeDTO;
import al.edu.fti.gaming.exception.NoOperatingSystemFoundForCompanyException;
import al.edu.fti.gaming.exception.OperatingSystemNotFoundException;
import al.edu.fti.gaming.models.OperatingSystemType;
import al.edu.fti.gaming.service.OperatingSystemTypeService;

@Service
@Transactional
public class OperatingSystemTypeServiceImpl implements OperatingSystemTypeService {

	@Autowired
	@Qualifier("operatingSystemTypeConverter")
	private Converter operatingSystemTypeConverter;

	@Autowired
	private OperatingSystemTypeRepository operatingSystemTypeRepository;

	@Override
	public int add(OperatingSystemTypeDTO operatingSystemTypeDTO) {
		OperatingSystemType operatingSystemType = (OperatingSystemType) operatingSystemTypeConverter
				.toModel(operatingSystemTypeDTO);
		int retVal = this.operatingSystemTypeRepository.add(operatingSystemType);
		if (retVal != 0) {
			operatingSystemTypeDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<OperatingSystemTypeDTO> getOperatingSystemTypes() {
		List<OperatingSystemType> operatingSystemTypeModels = operatingSystemTypeRepository
				.getAllOperatingSystemTypes();
		return convertList(operatingSystemTypeModels);
	}

	@Override
	public OperatingSystemTypeDTO getOperatingSystemTypeById(int id) {
		OperatingSystemType operatingSystemType = operatingSystemTypeRepository.getOperatingSystemTypeById(id);
		if (operatingSystemType == null) {
			throw new OperatingSystemNotFoundException(id);
		} else {
			return (OperatingSystemTypeDTO) operatingSystemTypeConverter.toDTO(operatingSystemType);
		}
	}

	@Override
	public boolean update(OperatingSystemTypeDTO operatingSystemTypeDTO) {
		return this.operatingSystemTypeRepository
				.update((OperatingSystemType) operatingSystemTypeConverter.toModel(operatingSystemTypeDTO));
	}

	@Override
	public List<OperatingSystemTypeDTO> getAllOperatingSystemTypesThatHaveOperatingSystems() {
		List<OperatingSystemType> operatingSystemTypeModels = operatingSystemTypeRepository.getAllOperatingSystemTypesThatHaveOperatingSystems();
		return convertList(operatingSystemTypeModels);
	}

	

	@Override
	public List<OperatingSystemTypeDTO> getAllOperatingSystemTypesByCompanyName(String companyName) {
		List<OperatingSystemType> operatingSystemTypeModels = operatingSystemTypeRepository.getAllOperatingSystemTypesByCompanyName(companyName);
		if(operatingSystemTypeModels == null || operatingSystemTypeModels.isEmpty()) {
			throw new NoOperatingSystemFoundForCompanyException(companyName);
		} 
		return convertList(operatingSystemTypeModels);
	}
	
	private List<OperatingSystemTypeDTO> convertList(List<OperatingSystemType> operatingSystemTypeModels) {
		List<OperatingSystemTypeDTO> operatingSystemTypeDTOs = new ArrayList<OperatingSystemTypeDTO>();
		for (OperatingSystemType operatingSystemType : operatingSystemTypeModels) {
			OperatingSystemTypeDTO operatingSystemTypeDTO = (OperatingSystemTypeDTO) operatingSystemTypeConverter
					.toDTO(operatingSystemType);
			operatingSystemTypeDTOs.add(operatingSystemTypeDTO);
		}
		return operatingSystemTypeDTOs;
	}
}
