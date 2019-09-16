package al.edu.fti.gaming.dao;

import al.edu.fti.gaming.models.Role;

public interface RoleRepository {

	Role getUserRole();

	Role getAdminRole();
}
