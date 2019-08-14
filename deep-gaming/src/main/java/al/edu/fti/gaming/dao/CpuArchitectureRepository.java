package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.CpuArchitecture;


public interface CpuArchitectureRepository {
	
	int add(CpuArchitecture cpuArchitecture);

	List<CpuArchitecture> getAllCpuArchitectures();

	CpuArchitecture getCpuArchitectureById(int id);

	boolean update(CpuArchitecture cpuArchitecture);
}
