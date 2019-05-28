package al.edu.fti.deep_gaming.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "company")
/**
 * Klasa Company sherben per te specifikuar cila kompani ka krijuar nje prej
 * produkteve qe ndodhen ne sistem
 * 
 * @author kfotj
 *
 */
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_company", nullable = false)
	/**
	 * Çelesi primar ne tabelen "company" ne bazen e te dhenave, i cili
	 * autoinkrementohet
	 */
	private Integer idCompany;

	@Column(name = "company_name", nullable = false, length = 50, unique = true)
	/**
	 * Variabli lidhet me fushen "company_name" ne bazen e te dhenave, e cila mban
	 * informacion rreth emrit te kompanise
	 */
	private String companyName;

	@Column(name = "company_description", nullable = false, length = 65535)
	/**
	 * Variabli lidhet me fushen "company_description" ne bazen e te dhenave, e cila
	 * mban informacion per te pershkruar kompanine
	 */
	private String companyDescription;

	@Column(name = "date_of_creation", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	/**
	 * Variabli lidhet me fushen "date_of_creation" ne bazen e te dhenave, e cila
	 * mban informacion rreth dates kur kompania eshte formuar
	 */
	private Date dateOfCreation;

	@Column(name = "hyperlink", nullable = false, length = 255)
	/**
	 * Variabli lidhet me fushen "hyperlink" ne bazen e te dhenave dhe mban nje link
	 * qe perdoruesi mund ta perdore per te pare me shume informacion rreth
	 * kompanise se ajo e ofruar ne sistemin tone
	 */
	private String hyperlink;

	@OneToMany(mappedBy = "companyOfThisCpuFamily")
	/**
	 * CPU Families that are created by this company
	 */
	private List<CpuFamily> cpuFamiliesOfThisCompany = new ArrayList<>();

	@OneToMany(mappedBy = "companyOfThisGpuFamily")
	/**
	 * GPU Families that are created by this company
	 */
	private List<GpuFamily> gpuFamiliesOfThisCompany = new ArrayList<>();

	@OneToMany(mappedBy = "companyOfThisCpuArchitecture")
	/**
	 * CPU architectures that are created by this company
	 */
	private List<CpuArchitecture> cpuArchitecturesOfThisCompany = new ArrayList<>();

	@OneToMany(mappedBy = "companyOfThisGpuArchitecture")
	/**
	 * GPU architectures that are created by this company
	 */
	private List<GpuArchitecture> gpuArchitecturesOfThisCompany = new ArrayList<>();

	@OneToMany(mappedBy = "companyThatCreatedThisSocket")
	/**
	 * CPU sockets that are created by this company
	 */
	private List<CpuSocket> cpuSocketsOfThisCompany = new ArrayList<>();

	@OneToMany(mappedBy = "companyThatCreatedThisChipset")
	private List<Chipset> chipsetsOfThisCompany = new ArrayList<>();

	@OneToMany(mappedBy = "companyOfThisMotherboard")
	private List<Motherboard> motherboardsOfThisCompany = new ArrayList<Motherboard>();

	@OneToMany(mappedBy = "companyOfThisPowerSupply")
	private List<PowerSupply> powerSuppliesOfThisCompany = new ArrayList<PowerSupply>();

	@OneToMany(mappedBy = "companyOfThisStorage")
	private List<Storage> storagesOfThisCompany = new ArrayList<Storage>();

	@OneToMany(mappedBy = "ramSticksCompany")
	private List<Ram> ramsOfThisCompany = new ArrayList<Ram>();

	@OneToMany(mappedBy = "companyOfThisOS")
	private List<OperatingSystemType> operatingSystemsOfThisCompany = new ArrayList<OperatingSystemType>();
	/* Konstruktor me parametra */
	// ----------
	// ----------
	// ----------
	/* Konstruktori me parametra */

	/* Konstruktor pa parametra */
	// ----------
	// ----------
	// ----------
	/* Konstruktori pa parametra */

	/* Getter setterat e tjere */
	// ----------
	// ----------
	// ----------
	/* Getter setterat e tjere */

	/* toString */
	// -----
	// -----
	// -----
	/* toString */

	/* hashCode */
	// -----
	// -----
	// -----
	/* hashCode */

	/* equals */
	// -----
	// -----
	// -----
	/* equals */

}
