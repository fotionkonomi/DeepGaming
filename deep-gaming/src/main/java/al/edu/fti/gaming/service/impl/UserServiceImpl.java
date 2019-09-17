package al.edu.fti.gaming.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import al.edu.fti.gaming.converter.Converter;
import al.edu.fti.gaming.dao.RoleRepository;
import al.edu.fti.gaming.dao.UserRepository;
import al.edu.fti.gaming.dto.UserDTO;
import al.edu.fti.gaming.models.Role;
import al.edu.fti.gaming.models.User;
import al.edu.fti.gaming.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	@Qualifier("userConverter")
	private Converter userConverter;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public int add(UserDTO userDTO) throws ParseException {
		userDTO.setDateRegistered(new Date());
		userDTO.setDateEdited(new Date());
		convertStringToDate(userDTO);
		Role userRole = roleRepository.getUserRole();
		User user = (User) userConverter.toModel(userDTO);
		int retVal = this.userRepository.add(user);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.addRole(userRole);
		userRepository.update(user);
		return retVal;
	}

	@Override
	public void convertStringToDate(UserDTO userDTO) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(userDTO.getDate());
		userDTO.setDateOfBirth(date);
	}

	@Override
	public boolean doesEmailExist(String email) {
		return userRepository.doesEmailExist(email);
	}

	@Override
	public boolean doesUsernameExist(String username) {
		User user = userRepository.findUserByUsername(username);
		if (user == null) {
			return false;
		} else {
			return true;
		}

	}

}
