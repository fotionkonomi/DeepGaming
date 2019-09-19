package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.DirectXRepository;
import al.edu.fti.gaming.dto.DirectXDTO;
import al.edu.fti.gaming.exception.DirectXNotFoundException;
import al.edu.fti.gaming.models.DirectX;
import al.edu.fti.gaming.service.DirectXService;

@Service
@Transactional
public class DirectXServiceImpl implements DirectXService {

	@Autowired
	@Qualifier("directXConverter")
	private Converter directXConverter;

	@Autowired
	private DirectXRepository directXRepository;

	@Override
	public int add(DirectXDTO directXDTO) {
		DirectX directX = (DirectX) directXConverter.toModel(directXDTO);
		int retVal = this.directXRepository.add(directX);
		if (retVal != 0) {
			directXDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<DirectXDTO> getAllDirectXs() {
		List<DirectX> directXModels = directXRepository.getAllDirectXs();
		return convertList(directXModels);
	}

	@Override
	public DirectXDTO getDirectXById(int id) {
		DirectX directX = directXRepository.getDirectXById(id);
		if (directX == null) {
			throw new DirectXNotFoundException(id);
		} else {
			return (DirectXDTO) directXConverter.toDTO(directX);
		}
	}

	@Override
	public boolean update(DirectXDTO directXDTO) {
		return this.directXRepository.update((DirectX) directXConverter.toModel(directXDTO));
	}

	private List<DirectXDTO> convertList(List<DirectX> directXModels) {
		List<DirectXDTO> directXDTOs = new ArrayList<DirectXDTO>();
		for (DirectX directX : directXModels) {
			directXDTOs.add((DirectXDTO) directXConverter.toDTO(directX));
		}
		return directXDTOs;
	}

}