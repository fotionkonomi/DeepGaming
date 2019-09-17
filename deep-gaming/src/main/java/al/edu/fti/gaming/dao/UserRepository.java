package al.edu.fti.gaming.dao;

import al.edu.fti.gaming.models.User;

public interface UserRepository {

	int add(User user);
	
	boolean update(User user);
	
	User findUserByUsername(String username);
	
	boolean doesEmailExist(String email);
}
