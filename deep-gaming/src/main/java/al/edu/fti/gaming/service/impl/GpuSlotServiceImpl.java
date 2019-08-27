package al.edu.fti.gaming.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.GpuSlotRepository;
import al.edu.fti.gaming.dto.GpuSlotDTO;
import al.edu.fti.gaming.exception.GpuSlotNotFoundException;
import al.edu.fti.gaming.models.GpuSlot;
import al.edu.fti.gaming.service.GpuSlotService;

@Service
@Transactional
public class GpuSlotServiceImpl implements GpuSlotService {

	@Autowired
	@Qualifier("gpuSlotConverter")
	private Converter gpuSlotConverter;

	@Autowired
	private GpuSlotRepository gpuSlotRepository;

	@Override
	public int add(GpuSlotDTO gpuSlotDTO) {
		GpuSlot gpuSlot = (GpuSlot) gpuSlotConverter.toModel(gpuSlotDTO);
		int retVal = this.gpuSlotRepository.add(gpuSlot);
		if (retVal != 0) {
			gpuSlotDTO.setId(retVal);
		}
		return retVal;
	}

	@Override
	public List<GpuSlotDTO> getAllGpuSlots() {
		List<GpuSlot> gpuSlotModels = gpuSlotRepository.allGpuSlots();
		return convertList(gpuSlotModels);
	}

	@Override
	public GpuSlotDTO getGpuSlotById(int id) {
		GpuSlot gpuSlot = gpuSlotRepository.getGpuSlotById(id);
		if (gpuSlot == null) {
			throw new GpuSlotNotFoundException(id);
		} else {
			return (GpuSlotDTO) gpuSlotConverter.toDTO(gpuSlot);
		}
	}

	@Override
	public boolean update(GpuSlotDTO gpuSlotDTO) {
		return this.gpuSlotRepository.update((GpuSlot) gpuSlotConverter.toModel(gpuSlotDTO));
	}

	private List<GpuSlotDTO> convertList(List<GpuSlot> gpuSlotModels) {
		List<GpuSlotDTO> gpuSlotDTOs = new ArrayList<GpuSlotDTO>();
		for (GpuSlot gpuSlot : gpuSlotModels) {
			gpuSlotDTOs.add((GpuSlotDTO) gpuSlotConverter.toDTO(gpuSlot));
		}
		return gpuSlotDTOs;
	}

}
