package al.edu.fti.gaming.service;

import java.util.Map;

import al.edu.fti.gaming.dto.CpuDTO;

public interface CpuService {

	int add(CpuDTO cpuDTO);
	
	Map<Integer, String> getCpuFamiliesByCompanyName(String company);

	Map<Integer, String> getCpuArchitecturesByCompanyName(String company);

	Map<Integer, String> getCpuSocketsByCompanyName(String company);
}
