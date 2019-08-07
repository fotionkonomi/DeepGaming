package al.edu.fti.gaming.dto;

import java.util.Date;

public class UserDTO implements IDto{

	private Integer idUser;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private Boolean gender;

	private Date dateOfBirth;

	private Date dateRegistered;

	private CpuDTO cpuOfHisComputer;

	private GpuDTO gpuOfHisComputer;

	private Double ramSizeOfHisComputer;

	public UserDTO() {
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

	public CpuDTO getCpuOfHisComputer() {
		return cpuOfHisComputer;
	}

	public void setCpuOfHisComputer(CpuDTO cpuOfHisComputer) {
		this.cpuOfHisComputer = cpuOfHisComputer;
	}

	public GpuDTO getGpuOfHisComputer() {
		return gpuOfHisComputer;
	}

	public void setGpuOfHisComputer(GpuDTO gpuOfHisComputer) {
		this.gpuOfHisComputer = gpuOfHisComputer;
	}

	public Double getRamSizeOfHisComputer() {
		return ramSizeOfHisComputer;
	}

	public void setRamSizeOfHisComputer(Double ramSizeOfHisComputer) {
		this.ramSizeOfHisComputer = ramSizeOfHisComputer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpuOfHisComputer == null) ? 0 : cpuOfHisComputer.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((dateRegistered == null) ? 0 : dateRegistered.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((gpuOfHisComputer == null) ? 0 : gpuOfHisComputer.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((ramSizeOfHisComputer == null) ? 0 : ramSizeOfHisComputer.hashCode());
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
		UserDTO other = (UserDTO) obj;
		if (cpuOfHisComputer == null) {
			if (other.cpuOfHisComputer != null)
				return false;
		} else if (!cpuOfHisComputer.equals(other.cpuOfHisComputer))
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
		if (ramSizeOfHisComputer == null) {
			if (other.ramSizeOfHisComputer != null)
				return false;
		} else if (!ramSizeOfHisComputer.equals(other.ramSizeOfHisComputer))
			return false;
		return true;
	}

}