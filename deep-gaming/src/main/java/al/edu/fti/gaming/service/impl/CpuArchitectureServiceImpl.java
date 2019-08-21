package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.CompanyRepository;
import al.edu.fti.gaming.dao.CpuArchitectureRepository;
import al.edu.fti.gaming.dto.CpuArchitectureDTO;
import al.edu.fti.gaming.dto.CpuSocketDTO;
import al.edu.fti.gaming.exception.CpuArchitectureNotFoundException;
import al.edu.fti.gaming.exception.NoCpuArchitecturesFoundForCompanyException;
import al.edu.fti.gaming.models.CpuArchitecture;
import al.edu.fti.gaming.models.CpuSocket;
import al.edu.fti.gaming.service.CpuArchitectureService;

@Service
@Transactional
public class CpuArchitectureServiceImpl implements CpuArchitectureService {

	@Autowired
	@Qualifier("cpuArchitectureConverter")
	private Converter cpuArchitectureConverter;

	@Autowired
	private CpuArchitectureRepository cpuArchitectureRepository;

	@Override
	public int add(CpuArchitectureDTO cpuArchitectureDTO) {
		CpuArchitecture cpuArchitecture = (CpuArchitecture) cpuArchitectureConverter.toModel(cpuArchitectureDTO);
		int retVal = cpuArchitectureRepository.add(cpuArchitecture);
		if (retVal != 0) {
			cpuArchitectureDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<CpuArchitectureDTO> getAllCpuArchitectures() {
		List<CpuArchitecture> cpuArchitectureModels = cpuArchitectureRepository.getAllCpuArchitectures();
		return convertList(cpuArchitectureModels);
	}

	@Override
	public CpuArchitectureDTO getCpuArchitectureById(int id) {
		CpuArchitecture cpuArchitecture = cpuArchitectureRepository.getCpuArchitectureById(id);
		if (cpuArchitecture == null) {
			throw new CpuArchitectureNotFoundException(id);
		} else {
			return (CpuArchitectureDTO) cpuArchitectureConverter.toDTO(cpuArchitecture);
		}
	}

	@Override
	public boolean update(CpuArchitectureDTO cpuArchitectureDTO) {
		return this.cpuArchitectureRepository
				.update((CpuArchitecture) cpuArchitectureConverter.toModel(cpuArchitectureDTO));
	}

	@Override
	public List<CpuArchitectureDTO> getCpuArchitecturesByCompany(String companyName) {
		List<CpuArchitecture> cpuArchitectureModels = cpuArchitectureRepository
				.getCpuArchitecturesByCompany(companyName);
		if(cpuArchitectureModels == null || cpuArchitectureModels.isEmpty()) {
			throw new NoCpuArchitecturesFoundForCompanyException(companyName);
		}
		return convertList(cpuArchitectureModels);
	}

	private List<CpuArchitectureDTO> convertList(List<CpuArchitecture> cpuArchitectureModels) {
		List<CpuArchitectureDTO> cpuArchitectureDTOs = new ArrayList<CpuArchitectureDTO>();
		for (CpuArchitecture cpuArchitecture : cpuArchitectureModels) {
			CpuArchitectureDTO cpuArchitectureDTO = (CpuArchitectureDTO) cpuArchitectureConverter
					.toDTO(cpuArchitecture);
			if (cpuArchitectureDTO != null) {
				cpuArchitectureDTOs.add(cpuArchitectureDTO);
			} else {
				return null;
			}
		}
		return cpuArchitectureDTOs;

	}

}
