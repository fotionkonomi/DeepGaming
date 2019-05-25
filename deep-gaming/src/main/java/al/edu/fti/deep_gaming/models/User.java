package al.edu.fti.deep_gaming.models;

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
public class User {

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
}
