package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.OperatingSystemType;

public interface OperatingSystemTypeRepository {

	int add(OperatingSystemType operatingSystemType);

	List<OperatingSystemType> getAllOperatingSystemTypes();

	OperatingSystemType getOperatingSystemTypeById(int id);

	boolean update(OperatingSystemType operatingSystemType);

	List<OperatingSystemType> getAllOperatingSystemTypesThatHaveOperatingSystems();

	List<OperatingSystemType> getAllOperatingSystemTypesByCompanyName(String companyName);
}
