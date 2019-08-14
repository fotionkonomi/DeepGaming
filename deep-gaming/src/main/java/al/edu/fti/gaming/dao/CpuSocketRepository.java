package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.CpuSocket;

public interface CpuSocketRepository {

	int add(CpuSocket cpuSocket);
	
	List<CpuSocket> getAllCpuSockets();
	
	CpuSocket getCpuSocketById(int id);
	
	boolean update(CpuSocket cpuSocket);
	
	List<CpuSocket> getCpuSocketsByCompany(String companyName);
	
}
