package al.edu.fti.gaming.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CpuDTO;
import al.edu.fti.gaming.dto.GpuDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.dto.UserDTO;
import al.edu.fti.gaming.models.CPU;
import al.edu.fti.gaming.models.GPU;
import al.edu.fti.gaming.models.IModel;
import al.edu.fti.gaming.models.User;

@Component
public class UserConverter implements Converter {

	@Autowired
	@Qualifier("cpuConverter")
	private Converter cpuConverter;

	@Autowired
	@Qualifier("gpuConverter")
	private Converter gpuConverter;

	@Override
	public IDto toDTO(IModel modelObject) {
		UserDTO userDTO = new UserDTO();
		User user = (User) modelObject;
		userDTO.setIdUser(user.getIdUser());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setEmail(user.getEmail());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setDateOfBirth(user.getDateOfBirth());
		userDTO.setDateRegistered(user.getDateRegistered());
		userDTO.setDateEdited(user.getDateEdited());
		userDTO.setCpuOfHisComputer((CpuDTO) cpuConverter.toDTO(user.getCpuOfHisComputer()));
		userDTO.setGpuOfHisComputer((GpuDTO) gpuConverter.toDTO(user.getGpuOfHisComputer()));
		userDTO.setRamSizeOfHisComputer(user.getRamSizeOfHisComputer());
		return userDTO;

	}

	@Override
	public IModel toModel(IDto dtoObject) {
		UserDTO userDTO = (UserDTO) dtoObject;
		User user = new User();
		if (userDTO.getIdUser() != null) {
			user.setIdUser(userDTO.getIdUser());
		}
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setDateOfBirth(userDTO.getDateOfBirth());
		user.setDateRegistered(userDTO.getDateRegistered());
		user.setDateEdited(userDTO.getDateEdited());
		if (userDTO.getCpuOfHisComputer() != null) {
			user.setCpuOfHisComputer((CPU) cpuConverter.toModel(userDTO.getCpuOfHisComputer()));
		}
		if (userDTO.getGpuOfHisComputer() != null) {
			user.setGpuOfHisComputer((GPU) gpuConverter.toModel(userDTO.getGpuOfHisComputer()));
		}
		user.setRamSizeOfHisComputer(userDTO.getRamSizeOfHisComputer());
		return user;
	}

}
