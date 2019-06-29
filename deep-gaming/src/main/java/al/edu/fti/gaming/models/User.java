package al.edu.fti.gaming.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User implements Serializable, IModel {

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

	@Column(name = "gender")
	private Boolean gender;

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

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "id_user") }, inverseJoinColumns = {
			@JoinColumn(name = "id_role") })
	private Set<Role> roles = new HashSet<Role>();

	@OneToMany(mappedBy = "suggestedBy")
	private List<Product> productsSuggested;

	@OneToMany(mappedBy = "approvedBy")
	private List<Product> productsApproved;

	public User(Integer idUser, String firstName, String lastName, String email, String username, String password,
			Boolean gender, Date dateOfBirth, Date dateRegistered, Date dateEdited, CPU cpuOfHisComputer,
			GPU gpuOfHisComputer, Double ramSizeOfHisComputer, Set<Role> roles, List<Product> productsSuggested,
			List<Product> productsApproved) {
		super();
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.dateRegistered = dateRegistered;
		this.dateEdited = dateEdited;
		this.cpuOfHisComputer = cpuOfHisComputer;
		this.gpuOfHisComputer = gpuOfHisComputer;
		this.ramSizeOfHisComputer = ramSizeOfHisComputer;
		this.roles = roles;
		this.productsSuggested = productsSuggested;
		this.productsApproved = productsApproved;
	}

	public User() {
		super();
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

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
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

	public List<Product> getProductsSuggested() {
		return productsSuggested;
	}

	public void setProductsSuggested(List<Product> productsSuggested) {
		this.productsSuggested = productsSuggested;
	}

	public List<Product> getProductsApproved() {
		return productsApproved;
	}

	public void setProductsApproved(List<Product> productsApproved) {
		this.productsApproved = productsApproved;
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
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((gpuOfHisComputer == null) ? 0 : gpuOfHisComputer.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((productsApproved == null) ? 0 : productsApproved.hashCode());
		result = prime * result + ((productsSuggested == null) ? 0 : productsSuggested.hashCode());
		result = prime * result + ((ramSizeOfHisComputer == null) ? 0 : ramSizeOfHisComputer.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
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
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
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
		if (productsApproved == null) {
			if (other.productsApproved != null)
				return false;
		} else if (!productsApproved.equals(other.productsApproved))
			return false;
		if (productsSuggested == null) {
			if (other.productsSuggested != null)
				return false;
		} else if (!productsSuggested.equals(other.productsSuggested))
			return false;
		if (ramSizeOfHisComputer == null) {
			if (other.ramSizeOfHisComputer != null)
				return false;
		} else if (!ramSizeOfHisComputer.equals(other.ramSizeOfHisComputer))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
