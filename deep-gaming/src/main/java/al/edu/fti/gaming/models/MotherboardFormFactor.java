package al.edu.fti.gaming.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "motherboard_form_factor")
public class MotherboardFormFactor implements Serializable, IModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7025612209309057593L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_motherboard_form_factor", nullable = false)
	private Integer idMotherboardFormFactor;

	@Column(name = "motherboard_form_factor_name", unique = true, nullable = false, length = 50)
	private String motherboardFormFactorName;

	@Column(name = "motherboard_form_factor_description", nullable = false, length = 65535)
	private String motherboardFormFactorDescription;

	@OneToMany(mappedBy = "formFactorOfThisMotherboard")
	private List<Motherboard> motherboardsThatHaveThisFormFactor = new ArrayList<Motherboard>();

	public MotherboardFormFactor(Integer idMotherboardFormFactor, String motherboardFormFactorName,
			String motherboardFormFactorDescription, List<Motherboard> motherboardsThatHaveThisFormFactor) {
		super();
		this.idMotherboardFormFactor = idMotherboardFormFactor;
		this.motherboardFormFactorName = motherboardFormFactorName;
		this.motherboardFormFactorDescription = motherboardFormFactorDescription;
		this.motherboardsThatHaveThisFormFactor = motherboardsThatHaveThisFormFactor;
	}

	public MotherboardFormFactor() {

	}

	public Integer getIdMotherboardFormFactor() {
		return idMotherboardFormFactor;
	}

	public void setIdMotherboardFormFactor(Integer idMotherboardFormFactor) {
		this.idMotherboardFormFactor = idMotherboardFormFactor;
	}

	public String getMotherboardFormFactorName() {
		return motherboardFormFactorName;
	}

	public void setMotherboardFormFactorName(String motherboardFormFactorName) {
		this.motherboardFormFactorName = motherboardFormFactorName;
	}

	public String getMotherboardFormFactorDescription() {
		return motherboardFormFactorDescription;
	}

	public void setMotherboardFormFactorDescription(String motherboardFormFactorDescription) {
		this.motherboardFormFactorDescription = motherboardFormFactorDescription;
	}

	public List<Motherboard> getMotherboardsThatHaveThisFormFactor() {
		return motherboardsThatHaveThisFormFactor;
	}

	public void setMotherboardsThatHaveThisFormFactor(List<Motherboard> motherboardsThatHaveThisFormFactor) {
		this.motherboardsThatHaveThisFormFactor = motherboardsThatHaveThisFormFactor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMotherboardFormFactor == null) ? 0 : idMotherboardFormFactor.hashCode());
		result = prime * result
				+ ((motherboardFormFactorDescription == null) ? 0 : motherboardFormFactorDescription.hashCode());
		result = prime * result + ((motherboardFormFactorName == null) ? 0 : motherboardFormFactorName.hashCode());
		result = prime * result
				+ ((motherboardsThatHaveThisFormFactor == null) ? 0 : motherboardsThatHaveThisFormFactor.hashCode());
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
		MotherboardFormFactor other = (MotherboardFormFactor) obj;
		if (idMotherboardFormFactor == null) {
			if (other.idMotherboardFormFactor != null)
				return false;
		} else if (!idMotherboardFormFactor.equals(other.idMotherboardFormFactor))
			return false;
		if (motherboardFormFactorDescription == null) {
			if (other.motherboardFormFactorDescription != null)
				return false;
		} else if (!motherboardFormFactorDescription.equals(other.motherboardFormFactorDescription))
			return false;
		if (motherboardFormFactorName == null) {
			if (other.motherboardFormFactorName != null)
				return false;
		} else if (!motherboardFormFactorName.equals(other.motherboardFormFactorName))
			return false;
		if (motherboardsThatHaveThisFormFactor == null) {
			if (other.motherboardsThatHaveThisFormFactor != null)
				return false;
		} else if (!motherboardsThatHaveThisFormFactor.equals(other.motherboardsThatHaveThisFormFactor))
			return false;
		return true;
	}

}
