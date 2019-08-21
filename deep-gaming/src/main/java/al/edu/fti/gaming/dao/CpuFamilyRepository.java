package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.CpuFamily;

public interface CpuFamilyRepository {

	int add(CpuFamily cpuFamily);
	
	List<CpuFamily> getAllCpuFamilies();
	
	CpuFamily getCpuFamilyById(int id);
	
	boolean update(CpuFamily cpuFamily);
	
	List<CpuFamily> getCpuFamiliesByCompany(String companyName);
}
