package al.edu.fti.deep_gaming.models;

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
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false)
	/**
	 * This variable is mapped to the primary key of the "role" table in the
	 * database
	 */
	private Integer roleId;

	@Column(name = "role_name", nullable = false, length = 50)
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
}
