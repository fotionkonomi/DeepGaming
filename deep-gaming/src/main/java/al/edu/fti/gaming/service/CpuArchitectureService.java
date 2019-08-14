package al.edu.fti.gaming.service;

import java.util.List;

import al.edu.fti.gaming.dto.CpuArchitectureDTO;


public interface CpuArchitectureService {
	int add(CpuArchitectureDTO cpuArchitectureDTO);

	List<CpuArchitectureDTO> getAllCpuArchitectures();

	CpuArchitectureDTO getCpuArchitectureById(int id);

	boolean update(CpuArchitectureDTO cpuArchitectureDTO);
}
