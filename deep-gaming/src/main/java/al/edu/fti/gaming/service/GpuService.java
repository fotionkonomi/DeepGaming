package al.edu.fti.gaming.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.dto.GpuDTO;

public interface GpuService {

	int add(GpuDTO gpuDTO);
	
	ModelAndView getModelWithRequestParameters(String queryString);
	
	Integer getGpuArchitectureId(String queryString);
	
	Integer getGpuFamilyId(String queryString);
	
	Integer getGpuSlotId(String queryString);
	
	void preGpuSave(GpuDTO gpuDTO, String queryString) throws ParseException;
	
	GpuDTO getGpuById(int id);
	
	List<GpuDTO> getAllGpusInStock(int page, int numberOfItemsOnThePage);
	
	Long countOfGpusInStock();
	
	List<GpuDTO> getAllGpus();
	
	List<GpuDTO> getGpusByFamily(Integer gpuFamilyId);
	
	void update(GpuDTO gpuDTO, int id) throws ParseException;
	
	Map<Integer, String> getAllMemoryTechnologiesMap();
	
	Map<Integer, String> getAllGpuSlotsMap();
	
	Map<Integer, String> getDirectXsMap();
	
	Map<Integer, String> getAllCpusMap();
	
	Map<Integer, String> getAllGpusMap();
}
