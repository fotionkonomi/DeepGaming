package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.GpuSlot;

public interface GpuSlotRepository {

	int add(GpuSlot gpuSlot );
	
	List<GpuSlot> allGpuSlots();
	
	GpuSlot getGpuSlotById(int id);
	
	boolean update(GpuSlot gpuSlot);
	
}
