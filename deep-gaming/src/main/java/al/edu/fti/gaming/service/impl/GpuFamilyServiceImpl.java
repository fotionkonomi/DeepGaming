package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.GpuFamilyRepository;
import al.edu.fti.gaming.dto.GpuFamilyDTO;
import al.edu.fti.gaming.exception.GpuFamilyNotFoundException;
import al.edu.fti.gaming.exception.NoGpuFamilyFoundForCompanyException;
import al.edu.fti.gaming.models.GpuFamily;
import al.edu.fti.gaming.service.GpuFamilyService;

@Service
@Transactional
public class GpuFamilyServiceImpl implements GpuFamilyService {

	@Autowired
	@Qualifier("gpuFamilyConverter")
	private Converter gpuFamilyConverter;

	@Autowired
	private GpuFamilyRepository gpuFamilyRepository;

	@Override
	public int add(GpuFamilyDTO gpuFamilyDTO) {
		GpuFamily gpuFamily = (GpuFamily) gpuFamilyConverter.toModel(gpuFamilyDTO);
		int retVal = gpuFamilyRepository.add(gpuFamily);
		if (retVal != 0) {
			gpuFamilyDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<GpuFamilyDTO> getAllGpuFamilies() {
		List<GpuFamily> gpuFamilyModels = gpuFamilyRepository.getAllGpuFamilies();
		return convertList(gpuFamilyModels);
	}

	@Override
	public GpuFamilyDTO getGpuFamilyById(int id) {
		GpuFamily gpuFamily = gpuFamilyRepository.getGpuFamilyById(id);
		if (gpuFamily == null) {
			throw new GpuFamilyNotFoundException(id);
		} else {
			return (GpuFamilyDTO) gpuFamilyConverter.toDTO(gpuFamily);
		}
	}

	@Override
	public boolean update(GpuFamilyDTO gpuFamilyDTO) {
		return this.gpuFamilyRepository.update((GpuFamily) gpuFamilyConverter.toModel(gpuFamilyDTO));
	}

	@Override
	public List<GpuFamilyDTO> getGuFamiliesByCompany(String companyName) {
		List<GpuFamily> gpuFamilyModels = gpuFamilyRepository.getGpuFamiliesByCompany(companyName);
		if(gpuFamilyModels == null || gpuFamilyModels.isEmpty()) {
			throw new NoGpuFamilyFoundForCompanyException(companyName);
		}
		return convertList(gpuFamilyModels);
	}

	private List<GpuFamilyDTO> convertList(List<GpuFamily> gpuFamilyModels) {
		List<GpuFamilyDTO> gpuFamilyDTOs = new ArrayList<GpuFamilyDTO>();
		for (GpuFamily gpuFamily : gpuFamilyModels) {
			GpuFamilyDTO gpuFamilyDTO = (GpuFamilyDTO) gpuFamilyConverter.toDTO(gpuFamily);
			if (gpuFamilyDTO != null) {
				gpuFamilyDTOs.add(gpuFamilyDTO);
			} else {
				return null;
			}
		}
		return gpuFamilyDTOs;
	}

}
