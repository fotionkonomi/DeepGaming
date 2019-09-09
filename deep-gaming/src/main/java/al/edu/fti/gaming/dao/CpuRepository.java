package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.CPU;

public interface CpuRepository {

	int add(CPU cpu);

	CPU getCpuById(int id);

	List<CPU> getAllCpusInStock(int page, int numberOfItemsOnThePage);

	Long countOfCpusInStock();

	List<CPU> getCpusByCpuFamily(Integer cpuFamilyId);
	
	void update(CPU cpu);
	
}
