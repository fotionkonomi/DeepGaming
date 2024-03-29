package al.edu.fti.gaming.service;

import java.util.List;
import java.util.Map;

import al.edu.fti.gaming.dto.GpuSlotDTO;

public interface GpuSlotService {

	int add(GpuSlotDTO gpuSlotDTO);
	
	List<GpuSlotDTO> getAllGpuSlots();
	
	GpuSlotDTO getGpuSlotById(int id);
	
	boolean update(GpuSlotDTO gpuSlotDTO);
	
	Map<Integer, String> getAllGpuSlotsMap();

}
