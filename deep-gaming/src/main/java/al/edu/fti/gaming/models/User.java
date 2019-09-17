package al.edu.fti.gaming.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User implements Serializable, IModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5204101086984279131L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user", nullable = false)
	private Integer idUser;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@Column(name = "email", nullable = false, length = 320, unique = true)
	private String email;

	@Column(name = "user_name", nullable = false, length = 50, unique = true)
	private String username;

	@Column(name = "password", nullable = false, length = 255)
	private String password;

	@Column(name = "date_of_birth", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfBirth;

	@Column(name = "date_registered", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRegistered;

	@Column(name = "date_edited", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEdited;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu")
	private CPU cpuOfHisComputer;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu")
	private GPU gpuOfHisComputer;

	@Column(name = "ram_size")
	private Double ramSizeOfHisComputer;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "id_user") }, inverseJoinColumns = {
			@JoinColumn(name = "id_role") })
	private Set<Role> roles = new HashSet<Role>();

	public void addRole(Role role) {
		this.roles.add(role);
		role.getUsers().add(this);

	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public Date getDateEdited() {
		return dateEdited;
	}

	public void setDateEdited(Date dateEdited) {
		this.dateEdited = dateEdited;
	}

	public CPU getCpuOfHisComputer() {
		return cpuOfHisComputer;
	}

	public void setCpuOfHisComputer(CPU cpuOfHisComputer) {
		this.cpuOfHisComputer = cpuOfHisComputer;
	}

	public GPU getGpuOfHisComputer() {
		return gpuOfHisComputer;
	}

	public void setGpuOfHisComputer(GPU gpuOfHisComputer) {
		this.gpuOfHisComputer = gpuOfHisComputer;
	}

	public Double getRamSizeOfHisComputer() {
		return ramSizeOfHisComputer;
	}

	public void setRamSizeOfHisComputer(Double ramSizeOfHisComputer) {
		this.ramSizeOfHisComputer = ramSizeOfHisComputer;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpuOfHisComputer == null) ? 0 : cpuOfHisComputer.hashCode());
		result = prime * result + ((dateEdited == null) ? 0 : dateEdited.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((dateRegistered == null) ? 0 : dateRegistered.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gpuOfHisComputer == null) ? 0 : gpuOfHisComputer.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((ramSizeOfHisComputer == null) ? 0 : ramSizeOfHisComputer.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (cpuOfHisComputer == null) {
			if (other.cpuOfHisComputer != null)
				return false;
		} else if (!cpuOfHisComputer.equals(other.cpuOfHisComputer))
			return false;
		if (dateEdited == null) {
			if (other.dateEdited != null)
				return false;
		} else if (!dateEdited.equals(other.dateEdited))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (dateRegistered == null) {
			if (other.dateRegistered != null)
				return false;
		} else if (!dateRegistered.equals(other.dateRegistered))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gpuOfHisComputer == null) {
			if (other.gpuOfHisComputer != null)
				return false;
		} else if (!gpuOfHisComputer.equals(other.gpuOfHisComputer))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (ramSizeOfHisComputer == null) {
			if (other.ramSizeOfHisComputer != null)
				return false;
		} else if (!ramSizeOfHisComputer.equals(other.ramSizeOfHisComputer))
			return false;
		
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", dateOfBirth=" + dateOfBirth + ", dateRegistered=" + dateRegistered
				+ ", dateEdited=" + dateEdited + ", cpuOfHisComputer=" + cpuOfHisComputer + ", gpuOfHisComputer="
				+ gpuOfHisComputer + ", ramSizeOfHisComputer=" + ramSizeOfHisComputer + ", roles=" + roles + "]";
	}

}
