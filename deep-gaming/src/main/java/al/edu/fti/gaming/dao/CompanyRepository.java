package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.Company;
import al.edu.fti.gaming.models.CpuArchitecture;

public interface CompanyRepository {

	/**
	 * Returns id of the persisted object or 0 if the operation was not successful
	 * 
	 * @param company
	 * @return
	 */
	int add(Company company);

	List<Company> getAllCompanies();

	Company getCompanyById(int id);

	boolean update(Company company);
	
	List<Company> getAllCompaniesThatHaveCpuSockets();
	
	List<Company> getAllCompaniesThatHaveChipsets();
	
	List<Company> getAllCompaniesThatHaveCpuArchitectures();
	
	List<Company> getAllCompaniesThatHaveCpuFamilies();
	
    List<Company> getAllCompaniesThatHaveGpuArchitectures();
	
	List<Company> getAllCompaniesThatHaveGpuFamilies();
	
	List<Company> getAllCompaniesThatHaveOS();
	
}
