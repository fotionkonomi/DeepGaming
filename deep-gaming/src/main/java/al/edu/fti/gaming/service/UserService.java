package al.edu.fti.gaming.service;

import java.text.ParseException;

import al.edu.fti.gaming.dto.UserDTO;

public interface UserService {

	int add(UserDTO userDTO) throws ParseException;
	
    void convertStringToDate(UserDTO userDTO) throws ParseException;
    
    boolean doesEmailExist(String email);
    
    boolean doesUsernameExist(String username);
    
    UserDTO findUserByUsername(String username);
}

