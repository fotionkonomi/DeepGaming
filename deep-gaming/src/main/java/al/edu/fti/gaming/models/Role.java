package al.edu.fti.gaming.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
/**
 * This class is mapped to the "role" table in the database which contains
 * information regarding the different roles that the users can have in this
 * system
 * 
 * @author kfotj
 *
 */
public class Role implements Serializable, IModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6292448599198811070L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false)
	/**
	 * This variable is mapped to the primary key of the "role" table in the
	 * database
	 */
	private Integer roleId;

	@Column(name = "role_name", unique = true, nullable = false, length = 50)
	/**
	 * This variable is mapped to the "role_name" field in the "role" table in the
	 * database which contains the names of different roles of the system
	 */
	private String roleName;

	@Column(name = "role_description", nullable = false, length = 65535)
	/**
	 * This variable is mapped to the "role_description" field in the "role" table
	 * in the database which contains generic information regarding the roles of the
	 * system
	 */
	private String roleDescription;

	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();

	public Role(Integer roleId, String roleName, String roleDescription, Set<User> users) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.users = users;
	}

	public Role() {

	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleDescription == null) ? 0 : roleDescription.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (roleDescription == null) {
			if (other.roleDescription != null)
				return false;
		} else if (!roleDescription.equals(other.roleDescription))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
	
		return true;
	}

}
