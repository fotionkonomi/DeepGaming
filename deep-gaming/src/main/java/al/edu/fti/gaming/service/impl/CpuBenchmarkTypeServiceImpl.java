package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.CpuBenchmarkTypeRepository;
import al.edu.fti.gaming.dto.CpuBenchmarkDTO;
import al.edu.fti.gaming.dto.CpuBenchmarkTypeDTO;
import al.edu.fti.gaming.exception.CpuBenchmarkTypeNotFoundException;
import al.edu.fti.gaming.models.CpuBenchmarkType;
import al.edu.fti.gaming.service.CpuBenchmarkTypeService;

@Service
@Transactional
public class CpuBenchmarkTypeServiceImpl implements CpuBenchmarkTypeService {

	@Autowired
	@Qualifier("cpuBenchmarkTypeConverter")
	private Converter benchmarkTypeConverter;

	@Autowired
	private CpuBenchmarkTypeRepository benchmarkTypeRepository;

	@Override
	public int add(CpuBenchmarkTypeDTO benchmarkTypeDTO) {
		CpuBenchmarkType benchmarkType = (CpuBenchmarkType) benchmarkTypeConverter.toModel(benchmarkTypeDTO);
		int retVal = benchmarkTypeRepository.add(benchmarkType);
		if (retVal != 0) {
			benchmarkTypeDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<CpuBenchmarkTypeDTO> getAllBenchmarkTypes() {
		List<CpuBenchmarkType> benchmarkTypes = benchmarkTypeRepository.getAllBenchmarkTypes();
		return convertList(benchmarkTypes);
	}

	@Override
	public CpuBenchmarkTypeDTO getBenchmarkTypeById(int id) {
		CpuBenchmarkType benchmarkType = benchmarkTypeRepository.getBenchmarkTypeById(id);
		if (benchmarkType == null) {
			throw new CpuBenchmarkTypeNotFoundException(id);
		} else {
			return (CpuBenchmarkTypeDTO) benchmarkTypeConverter.toDTO(benchmarkType);
		}
	}

	@Override
	public boolean update(CpuBenchmarkTypeDTO benchmarkTypeDTO) {
		return benchmarkTypeRepository.update((CpuBenchmarkType) benchmarkTypeConverter.toModel(benchmarkTypeDTO));
	}

	private List<CpuBenchmarkTypeDTO> convertList(List<CpuBenchmarkType> benchmarkTypes) {
		List<CpuBenchmarkTypeDTO> benchmarkTypeDTOs = new ArrayList<CpuBenchmarkTypeDTO>();
		for (CpuBenchmarkType benchmarkType : benchmarkTypes) {
			benchmarkTypeDTOs.add((CpuBenchmarkTypeDTO) benchmarkTypeConverter.toDTO(benchmarkType));
		}
		return benchmarkTypeDTOs;
	}

}
