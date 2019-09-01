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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((companyThatCreatedThisSocket == null) ? 0 : companyThatCreatedThisSocket.hashCode());
		result = prime * result + ((cpusForThisSocket == null) ? 0 : cpusForThisSocket.hashCode());
		result = prime * result + ((idCpuSocket == null) ? 0 : idCpuSocket.hashCode());
		result = prime * result + ((laptopOrDesktop == null) ? 0 : laptopOrDesktop.hashCode());
		result = prime * result
				+ ((motherboardsThatHaveThisSocket == null) ? 0 : motherboardsThatHaveThisSocket.hashCode());
		result = prime * result + ((socketDescription == null) ? 0 : socketDescription.hashCode());
		result = prime * result + ((socketName == null) ? 0 : socketName.hashCode());
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
		CpuSocket other = (CpuSocket) obj;
		if (companyThatCreatedThisSocket == null) {
			if (other.companyThatCreatedThisSocket != null)
				return false;
		} else if (!companyThatCreatedThisSocket.equals(other.companyThatCreatedThisSocket))
			return false;
		if (cpusForThisSocket == null) {
			if (other.cpusForThisSocket != null)
				return false;
		} else if (!cpusForThisSocket.equals(other.cpusForThisSocket))
			return false;
		if (idCpuSocket == null) {
			if (other.idCpuSocket != null)
				return false;
		} else if (!idCpuSocket.equals(other.idCpuSocket))
			return false;
		if (laptopOrDesktop == null) {
			if (other.laptopOrDesktop != null)
				return false;
		} else if (!laptopOrDesktop.equals(other.laptopOrDesktop))
			return false;
		if (motherboardsThatHaveThisSocket == null) {
			if (other.motherboardsThatHaveThisSocket != null)
				return false;
		} else if (!motherboardsThatHaveThisSocket.equals(other.motherboardsThatHaveThisSocket))
			return false;
		if (socketDescription == null) {
			if (other.socketDescription != null)
				return false;
		} else if (!socketDescription.equals(other.socketDescription))
			return false;
		if (socketName == null) {
			if (other.socketName != null)
				return false;
		} else if (!socketName.equals(other.socketName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CpuSocket [idCpuSocket=" + idCpuSocket + ", socketName=" + socketName + ", socketDescription="
				+ socketDescription + ", laptopOrDesktop=" + laptopOrDesktop + ", companyThatCreatedThisSocket="
				+ companyThatCreatedThisSocket + ", cpusForThisSocket=" + cpusForThisSocket
				+ ", motherboardsThatHaveThisSocket=" + motherboardsThatHaveThisSocket + "]";
	}
	
	

}
