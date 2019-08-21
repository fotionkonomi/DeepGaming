package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.CpuFamilyDTO;

public interface CpuFamilyService {
	int add(CpuFamilyDTO cpuFamilyDTO);

	List<CpuFamilyDTO> getAllCpuFamilies();

	CpuFamilyDTO getCpuFamilyById(int id);

	boolean update(CpuFamilyDTO cpuFamilyDTO);

	List<CpuFamilyDTO> getCpuFamiliesByCompany(String companyName);
}
