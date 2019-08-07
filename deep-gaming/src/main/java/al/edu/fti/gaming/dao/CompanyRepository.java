package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.Company;

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
}
