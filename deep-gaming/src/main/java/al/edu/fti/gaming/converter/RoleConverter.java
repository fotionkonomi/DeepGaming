package al.edu.fti.gaming.converter;

import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.dto.RoleDTO;
import al.edu.fti.gaming.models.IModel;
import al.edu.fti.gaming.models.Role;

@Component
public class RoleConverter implements Converter {

	@Override
	public IModel toModel(IDto dtoObject) {
		RoleDTO roleDTO = (RoleDTO) dtoObject;
		Role role = new Role();
		role.setRoleId(roleDTO.getId());
		role.setRoleDescription(roleDTO.getDescription());
		role.setRoleName(roleDTO.getName());
		return role;
	}

	@Override
	public IDto toDTO(IModel modelObject) {
		Role role = new Role();
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setId(role.getRoleId());
		roleDTO.setDescription(role.getRoleDescription());
		roleDTO.setName(role.getRoleName());
		return roleDTO;
	}

}
