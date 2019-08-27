package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.GpuArchitectureRepository;
import al.edu.fti.gaming.dto.GpuArchitectureDTO;
import al.edu.fti.gaming.exception.GpuArchitectureNotFoundException;
import al.edu.fti.gaming.exception.NoGpuArchitecturesFoundForCompanyException;
import al.edu.fti.gaming.models.GpuArchitecture;
import al.edu.fti.gaming.service.GpuArchitectureService;

@Service
@Transactional
public class GpuArchitectureServiceImpl implements GpuArchitectureService{

	@Autowired
	@Qualifier("gpuArchitectureConverter")
	private Converter gpuArchitectureConverter;
	
	@Autowired
	private GpuArchitectureRepository gpuArchitectureRepository;
	
	@Override
	public int add(GpuArchitectureDTO gpuArchitectureDTO) {
		GpuArchitecture gpuArchitecture = (GpuArchitecture) gpuArchitectureConverter.toModel(gpuArchitectureDTO);
		int retVal = gpuArchitectureRepository.add(gpuArchitecture);
		if(retVal != 0) {
			gpuArchitectureDTO.setId(retVal);
		}
		return retVal;
		
	}

	@Override
	public List<GpuArchitectureDTO> getAllGpuArchitectures() {
		List<GpuArchitecture> gpuArchitectureModels = gpuArchitectureRepository.getAllGpuArchitectures();
		return convertList(gpuArchitectureModels);
	}

	@Override
	public GpuArchitectureDTO getGpuArchitectureById(int id) {
		GpuArchitecture gpuArchitecture = gpuArchitectureRepository.getGpuArchitectureById(id);
		if (gpuArchitecture == null) {
			throw new GpuArchitectureNotFoundException(id);
		} else {
			return (GpuArchitectureDTO) gpuArchitectureConverter.toDTO(gpuArchitecture);
		}
	}

	@Override
	public boolean update(GpuArchitectureDTO gpuArchitectureDTO) {
		return this.gpuArchitectureRepository
				.update((GpuArchitecture) gpuArchitectureConverter.toModel(gpuArchitectureDTO));
	}

	@Override
	public List<GpuArchitectureDTO> getGpuArchitecturesByCompany(String companyName) {
		List<GpuArchitecture> gpuArchitectureModels = gpuArchitectureRepository
				.getGpuArchitecturesByCompany(companyName);
		if(gpuArchitectureModels == null || gpuArchitectureModels.isEmpty()) {
			throw new NoGpuArchitecturesFoundForCompanyException(companyName);
		}
		return convertList(gpuArchitectureModels);
	}

	private List<GpuArchitectureDTO> convertList(List<GpuArchitecture> gpuArchitectureModels) {
		List<GpuArchitectureDTO> gpuArchitectureDTOs = new ArrayList<GpuArchitectureDTO>();
		for (GpuArchitecture gpuArchitecture : gpuArchitectureModels) {
			GpuArchitectureDTO gpuArchitectureDTO = (GpuArchitectureDTO) gpuArchitectureConverter
					.toDTO(gpuArchitecture);
			if (gpuArchitectureDTO != null) {
				gpuArchitectureDTOs.add(gpuArchitectureDTO);
			} else {
				return null;
			}
		}
		return gpuArchitectureDTOs;

	}

}
