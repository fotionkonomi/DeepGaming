package al.edu.fti.gaming.service;

import java.util.List;
import java.util.Map;

import al.edu.fti.gaming.dto.CpuSocketDTO;

public interface CpuSocketService {

	int add(CpuSocketDTO cpuSocketDTO);

	List<CpuSocketDTO> getAllCpuSockets();

	CpuSocketDTO getCpuSocketById(int id);

	boolean update(CpuSocketDTO cpuSocketDTO);

	List<CpuSocketDTO> getCpuSocketsByCompany(String companyName);

	Map<Integer, String> getAllCpuSocketsMap();

}
