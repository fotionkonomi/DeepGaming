package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.CpuFamilyRepository;
import al.edu.fti.gaming.dto.CpuFamilyDTO;
import al.edu.fti.gaming.exception.CpuFamilyNotFoundException;
import al.edu.fti.gaming.exception.NoCpuFamilyFoundForCompanyException;
import al.edu.fti.gaming.models.CpuFamily;
import al.edu.fti.gaming.service.CpuFamilyService;

@Service
@Transactional
public class CpuFamilyServiceImpl implements CpuFamilyService {

	@Autowired
	@Qualifier("cpuFamilyConverter")
	private Converter cpuFamilyConverter;

	@Autowired
	private CpuFamilyRepository cpuFamilyRepository;

	@Override
	public int add(CpuFamilyDTO cpuFamilyDTO) {
		CpuFamily cpuFamily = (CpuFamily) cpuFamilyConverter.toModel(cpuFamilyDTO);
		int retVal = cpuFamilyRepository.add(cpuFamily);
		if (retVal != 0) {
			cpuFamilyDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<CpuFamilyDTO> getAllCpuFamilies() {
		List<CpuFamily> cpuFamilyModels = cpuFamilyRepository.getAllCpuFamilies();
		return convertList(cpuFamilyModels);
	}

	@Override
	public CpuFamilyDTO getCpuFamilyById(int id) {
		CpuFamily cpuFamily = cpuFamilyRepository.getCpuFamilyById(id);
		if (cpuFamily == null) {
			throw new CpuFamilyNotFoundException(id);
		} else {
			return (CpuFamilyDTO) cpuFamilyConverter.toDTO(cpuFamily);
		}
	}

	@Override
	public boolean update(CpuFamilyDTO cpuFamilyDTO) {
		return this.cpuFamilyRepository.update((CpuFamily) cpuFamilyConverter.toModel(cpuFamilyDTO));
	}

	@Override
	public List<CpuFamilyDTO> getCpuFamiliesByCompany(String companyName) {
		List<CpuFamily> cpuFamilyModels = cpuFamilyRepository.getCpuFamiliesByCompany(companyName);
		if(cpuFamilyModels == null || cpuFamilyModels.isEmpty()) {
			throw new NoCpuFamilyFoundForCompanyException(companyName);
		}
		return convertList(cpuFamilyModels);
	}

	private List<CpuFamilyDTO> convertList(List<CpuFamily> cpuFamilyModels) {
		List<CpuFamilyDTO> cpuFamilyDTOs = new ArrayList<CpuFamilyDTO>();
		for (CpuFamily cpuFamily : cpuFamilyModels) {
			CpuFamilyDTO cpuFamilyDTO = (CpuFamilyDTO) cpuFamilyConverter.toDTO(cpuFamily);
			if (cpuFamilyDTO != null) {
				cpuFamilyDTOs.add(cpuFamilyDTO);
			} else {
				return null;
			}
		}
		return cpuFamilyDTOs;
	}

}
