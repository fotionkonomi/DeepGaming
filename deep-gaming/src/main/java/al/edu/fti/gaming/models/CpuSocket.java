package al.edu.fti.gaming.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cpu_socket")
/**
 * This class is mapped to the "cpu_socket" table in the database which contains
 * information about the different sockets of a CPU
 * 
 * @author kfotj
 *
 */
public class CpuSocket implements Serializable, IModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 902789566462473069L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cpu_socket", nullable = false)
	/**
	 * This variable is mapped to the primary key of the "cpu_socket" table in the
	 * database
	 */
	private Integer idCpuSocket;

	@Column(name = "socket_name", unique = true, nullable = false, length = 50)
	/**
	 * This variable is mapped to the "socket_name" field in the "cpu_socket" table
	 * in the database which contains the name of the CPU sockets. Has to be 50 or
	 * less characters long
	 */
	private String socketName;

	@Column(name = "socket_description", nullable = false, length = 65535)
	/**
	 * This variable is mapped to the "socket_description" field in the "cpu_socket"
	 * table which contains generic information of a specific type of socket
	 */
	private String socketDescription;

	@Column(name = "laptop_desktop", nullable = false)
	private Boolean laptopOrDesktop;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	/**
	 * The company which created this socket
	 */
	private Company companyThatCreatedThisSocket;

	@OneToMany(mappedBy = "socketForThisCpu")
	private List<CPU> cpusForThisSocket = new ArrayList<CPU>();

	@OneToMany(mappedBy = "cpuSocketOfThisMotherboard")
	private List<Motherboard> motherboardsThatHaveThisSocket = new ArrayList<Motherboard>();

	public CpuSocket(String socketName, String socketDescription, Boolean laptopOrDesktop) {
		super();
		this.socketName = socketName;
		this.socketDescription = socketDescription;
		this.laptopOrDesktop = laptopOrDesktop;
	}

	public CpuSocket() {

	}

	public Integer getIdCpuSocket() {
		return idCpuSocket;
	}

	public void setIdCpuSocket(Integer idCpuSocket) {
		this.idCpuSocket = idCpuSocket;
	}

	public String getSocketName() {
		return socketName;
	}

	public void setSocketName(String socketName) {
		this.socketName = socketName;
	}

	public String getSocketDescription() {
		return socketDescription;
	}

	public void setSocketDescription(String socketDescription) {
		this.socketDescription = socketDescription;
	}

	public Boolean getLaptopOrDesktop() {
		return laptopOrDesktop;
	}

	public void setLaptopOrDesktop(Boolean laptopOrDesktop) {
		this.laptopOrDesktop = laptopOrDesktop;
	}

	public Company getCompanyThatCreatedThisSocket() {
		return companyThatCreatedThisSocket;
	}

	public void setCompanyThatCreatedThisSocket(Company companyThatCreatedThisSocket) {
		this.companyThatCreatedThisSocket = companyThatCreatedThisSocket;
	}

	public List<CPU> getCpusForThisSocket() {
		return cpusForThisSocket;
	}

	public void setCpusForThisSocket(List<CPU> cpusForThisSocket) {
		this.cpusForThisSocket = cpusForThisSocket;
	}

	public List<Motherboard> getMotherboardsThatHaveThisSocket() {
		return motherboardsThatHaveThisSocket;
	}

	public void setMotherboardsThatHaveThisSocket(List<Motherboard> motherboardsThatHaveThisSocket) {
		this.motherboardsThatHaveThisSocket = motherboardsThatHaveThisSocket;
	}
	
	

}
