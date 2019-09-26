package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.GpuMemoryTechnologyRepository;
import al.edu.fti.gaming.dto.GpuMemoryTechnologyDTO;
import al.edu.fti.gaming.exception.GpuMemoryTechnologyNotFoundException;
import al.edu.fti.gaming.models.GpuMemoryTechnology;
import al.edu.fti.gaming.service.GpuMemoryTechnologyService;

@Service
@Transactional
public class GpuMemoryTechnologyServiceImpl implements GpuMemoryTechnologyService {

	@Autowired
	@Qualifier("gpuMemoryTechnologyConverter")
	private Converter gpuMemoryTechnologyConverter;

	@Autowired
	private GpuMemoryTechnologyRepository gpuMemoryTechnologyRepository;

	@Override
	public int add(GpuMemoryTechnologyDTO gpuMemoryTechnologyDTO) {
		GpuMemoryTechnology gpuMemoryTechnology = (GpuMemoryTechnology) gpuMemoryTechnologyConverter
				.toModel(gpuMemoryTechnologyDTO);
		int retVal = this.gpuMemoryTechnologyRepository.add(gpuMemoryTechnology);
		if (retVal != 0) {
			gpuMemoryTechnologyDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<GpuMemoryTechnologyDTO> getAllGpuMemoryTechnologies() {
		List<GpuMemoryTechnology> gpuMemoryTechnologyModels = gpuMemoryTechnologyRepository
				.getAllGpuMemoryTechnologies();
		return convertList(gpuMemoryTechnologyModels);
	}

	@Override
	public GpuMemoryTechnologyDTO getGpuMemoryTechnologyById(int id) {
		GpuMemoryTechnology gpuMemoryTechnology = gpuMemoryTechnologyRepository.getGpuMemoryTechnologyById(id);
		if (gpuMemoryTechnology == null) {
			throw new GpuMemoryTechnologyNotFoundException(id);
		} else {
			return (GpuMemoryTechnologyDTO) gpuMemoryTechnologyConverter.toDTO(gpuMemoryTechnology);
		}
	}

	@Override
	public boolean update(GpuMemoryTechnologyDTO gpuMemoryTechnologyDTO) {
		return gpuMemoryTechnologyRepository
				.update((GpuMemoryTechnology) gpuMemoryTechnologyConverter.toModel(gpuMemoryTechnologyDTO));
	}

	private List<GpuMemoryTechnologyDTO> convertList(List<GpuMemoryTechnology> gpuMemoryTechnologyModels) {
		List<GpuMemoryTechnologyDTO> gpuMemoryTechnologyDTOs = new ArrayList<GpuMemoryTechnologyDTO>();
		for (GpuMemoryTechnology gpuMemoryTechnology : gpuMemoryTechnologyModels) {
			gpuMemoryTechnologyDTOs
					.add((GpuMemoryTechnologyDTO) gpuMemoryTechnologyConverter.toDTO(gpuMemoryTechnology));
		}
		return gpuMemoryTechnologyDTOs;
	}
	

	@Override
	public Map<Integer, String> getAllMemoryTechnologiesMap() {
		List<GpuMemoryTechnologyDTO> allMemoryTechnologies = getAllGpuMemoryTechnologies();
		Map<Integer, String> allMemoryTechnologiesMap = new HashMap<Integer, String>();
		for (GpuMemoryTechnologyDTO gpuMemoryTechnologyDTO : allMemoryTechnologies) {
			allMemoryTechnologiesMap.put(gpuMemoryTechnologyDTO.getId(), gpuMemoryTechnologyDTO.getName());
		}
		return allMemoryTechnologiesMap;
	}


}
