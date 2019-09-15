package al.edu.fti.gaming.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import al.edu.fti.gaming.dto.CpuDTO;

public interface CpuService {

	int add(CpuDTO cpuDTO);

	ModelAndView getModelWithRequestParameters(String queryString);

	Integer getCpuArchitectureId(String queryString);

	Integer getCpuFamilyId(String queryString);

	Integer getCpuSocketId(String queryString);

	void preCpuSave(CpuDTO cpuDTO, String queryString) throws ParseException;

	CpuDTO getCpuById(int id);

	List<CpuDTO> getAllCpusInStock(int page, int numberOfItemsOnThePage);

	Long countOfCpusInStock();

	List<CpuDTO> getCpusByCpuFamily(Integer cpuFamilyId);

	void update(CpuDTO cpuDTO, int id) throws ParseException;
	
	List<CpuDTO> getAllCpus();
}
