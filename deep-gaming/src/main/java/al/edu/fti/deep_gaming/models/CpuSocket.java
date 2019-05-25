package al.edu.fti.deep_gaming.models;

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
public class CpuSocket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cpu_socket", nullable = false)
	/**
	 * This variable is mapped to the primary key of the "cpu_socket" table in the
	 * database
	 */
	private Integer idCpuSocket;

	@Column(name = "socket_name", nullable = false, length = 50)
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

}
