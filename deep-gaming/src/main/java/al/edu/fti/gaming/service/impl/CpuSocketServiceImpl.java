package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.CpuSocketRepository;
import al.edu.fti.gaming.dto.CpuSocketDTO;
import al.edu.fti.gaming.exception.CpuSocketNotFoundException;
import al.edu.fti.gaming.models.CpuSocket;
import al.edu.fti.gaming.service.CpuSocketService;

@Service
@Transactional
public class CpuSocketServiceImpl implements CpuSocketService {

	@Autowired
	@Qualifier("cpuSocketConverter")
	private Converter cpuSocketConverter;

	@Autowired
	private CpuSocketRepository cpuSocketRepository;

	@Override
	public int add(CpuSocketDTO cpuSocketDTO) {
		CpuSocket cpuSocket = (CpuSocket) cpuSocketConverter.toModel(cpuSocketDTO);
		int retVal = cpuSocketRepository.add(cpuSocket);
		if (retVal != 0) {
			cpuSocketDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<CpuSocketDTO> getAllCpuSockets() {
		List<CpuSocket> cpuSocketModels = cpuSocketRepository.getAllCpuSockets();
		List<CpuSocketDTO> cpuSocketDTOs = new ArrayList<CpuSocketDTO>();
		for (CpuSocket cpuSocket : cpuSocketModels) {
			CpuSocketDTO cpuSocketDTO = (CpuSocketDTO) cpuSocketConverter.toDTO(cpuSocket);
			if (cpuSocketDTO != null) {
				cpuSocketDTOs.add(cpuSocketDTO);
			} else {
				return null;
			}
		}
		return cpuSocketDTOs;
	}

	@Override
	public CpuSocketDTO getCpuSocketById(int id) {
		CpuSocket cpuSocket = cpuSocketRepository.getCpuSocketById(id);
		if (cpuSocket == null) {
			throw new CpuSocketNotFoundException(id);
		} else {
			return (CpuSocketDTO) cpuSocketConverter.toDTO(cpuSocket);
		}
	}

	@Override
	public boolean update(CpuSocketDTO cpuSocketDTO) {
		return this.cpuSocketRepository.update((CpuSocket) cpuSocketConverter.toModel(cpuSocketDTO));
	}

}
