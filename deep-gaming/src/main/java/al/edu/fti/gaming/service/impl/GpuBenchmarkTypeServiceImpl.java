package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.GpuBenchmarkTypeRepository;
import al.edu.fti.gaming.dto.GpuBenchmarkTypeDTO;
import al.edu.fti.gaming.exception.GpuBenchmarkTypeNotFoundException;
import al.edu.fti.gaming.models.GpuBenchmarkType;
import al.edu.fti.gaming.service.GpuBenchmarkTypeService;

@Service
@Transactional
public class GpuBenchmarkTypeServiceImpl implements GpuBenchmarkTypeService {
	@Autowired
	@Qualifier("gpuBenchmarkTypeConverter")
	private Converter benchmarkTypeConverter;

	@Autowired
	private GpuBenchmarkTypeRepository benchmarkTypeRepository;
	
	@Override
	public int add(GpuBenchmarkTypeDTO benchmarkTypeDTO) {
		GpuBenchmarkType benchmarkType = (GpuBenchmarkType) benchmarkTypeConverter.toModel(benchmarkTypeDTO);
		int retVal = benchmarkTypeRepository.add(benchmarkType);
		if (retVal != 0) {
			benchmarkTypeDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<GpuBenchmarkTypeDTO> getAllBenchmarkTypes() {
		List<GpuBenchmarkType> benchmarkTypes = benchmarkTypeRepository.getAllBenchmarkTypes();
		return convertList(benchmarkTypes);
	}

	@Override
	public GpuBenchmarkTypeDTO getBenchmarkTypeById(int id) {
		GpuBenchmarkType benchmarkType = benchmarkTypeRepository.getBenchmarkTypeById(id);
		if (benchmarkType == null) {
			throw new GpuBenchmarkTypeNotFoundException(id);
		} else {
			return (GpuBenchmarkTypeDTO) benchmarkTypeConverter.toDTO(benchmarkType);
		}
	}

	@Override
	public boolean update(GpuBenchmarkTypeDTO benchmarkTypeDTO) {
		return benchmarkTypeRepository.update((GpuBenchmarkType) benchmarkTypeConverter.toModel(benchmarkTypeDTO));
	}

	private List<GpuBenchmarkTypeDTO> convertList(List<GpuBenchmarkType> benchmarkTypes) {
		List<GpuBenchmarkTypeDTO> benchmarkTypeDTOs = new ArrayList<GpuBenchmarkTypeDTO>();
		for (GpuBenchmarkType benchmarkType : benchmarkTypes) {
			benchmarkTypeDTOs.add((GpuBenchmarkTypeDTO) benchmarkTypeConverter.toDTO(benchmarkType));
		}
		return benchmarkTypeDTOs;
	}
}
