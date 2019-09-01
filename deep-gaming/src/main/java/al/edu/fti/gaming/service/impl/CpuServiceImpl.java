package al.edu.fti.gaming.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.CpuRepository;
import al.edu.fti.gaming.dto.CpuArchitectureDTO;
import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.CpuFamilyDTO;
import al.edu.fti.gaming.dto.CpuSocketDTO;
import al.edu.fti.gaming.models.CPU;
import al.edu.fti.gaming.service.CpuArchitectureService;
import al.edu.fti.gaming.service.CpuFamilyService;
import al.edu.fti.gaming.service.CpuService;
import al.edu.fti.gaming.service.CpuSocketService;

@Service
@Transactional
public class CpuServiceImpl implements CpuService {

	@Autowired
	private CpuRepository cpuRepository;

	@Autowired
	@Qualifier("cpuConverter")
	private Converter cpuConverter;

	@Autowired
	private CpuFamilyService cpuFamilyService;

	@Autowired
	private CpuArchitectureService cpuArchitectureService;

	@Autowired
	private CpuSocketService cpuSocketService;

	@Override
	public int add(CpuDTO cpuDTO) {
		CPU cpu = (CPU) cpuConverter.toModel(cpuDTO);
		int retVal = cpuRepository.add(cpu);
		if (retVal != 0) {
			cpuDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public Map<Integer, String> getCpuFamiliesByCompanyName(String company) {
		List<CpuFamilyDTO> cpuFamiliesList = cpuFamilyService.getCpuFamiliesByCompany(company);
		Map<Integer, String> cpuFamilies = new HashMap<Integer, String>();
		for (CpuFamilyDTO cpuFamilyDTO : cpuFamiliesList) {
			cpuFamilies.put(cpuFamilyDTO.getId(), cpuFamilyDTO.getName());
		}
		return cpuFamilies;
	}

	@Override
	public Map<Integer, String> getCpuArchitecturesByCompanyName(String company) {
		List<CpuArchitectureDTO> cpuArchitecturesList = cpuArchitectureService.getCpuArchitecturesByCompany(company);
		Map<Integer, String> cpuArchitectures = new HashMap<Integer, String>();
		for (CpuArchitectureDTO cpuArchitectureDTO : cpuArchitecturesList) {
			cpuArchitectures.put(cpuArchitectureDTO.getId(), cpuArchitectureDTO.getName());
		}
		return cpuArchitectures;
	}

	@Override
	public Map<Integer, String> getCpuSocketsByCompanyName(String company) {
		List<CpuSocketDTO> cpuSocketsList = cpuSocketService.getCpuSocketsByCompany(company);
		Map<Integer, String> cpuSockets = new HashMap<Integer, String>();
		for (CpuSocketDTO cpuSocketDTO : cpuSocketsList) {
			cpuSockets.put(cpuSocketDTO.getId(), cpuSocketDTO.getName());

		}
		return cpuSockets;
	}

}
