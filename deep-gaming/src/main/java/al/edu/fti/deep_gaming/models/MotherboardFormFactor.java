package al.edu.fti.deep_gaming.models;

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
public class MotherboardFormFactor {

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

}
