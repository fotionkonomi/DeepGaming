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
@Table(name = "direct_x")
/**
 * This class is mapped to the "direct_x" table in the database and it contains
 * information for all DirectX technologies
 * 
 * @author kfotj
 *
 */
public class DirectX {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_direct_x", nullable = false)
	/**
	 * Celesi primar ne tabelen "direct_x" ne bazen e te dhenave
	 */
	private Integer idDirectX;

	@Column(name = "direct_x_type", nullable = false, length = 50)
	/**
	 * Variabli ben lidhjen me fushen "direct_x_type" te tabeles "direct_x" ne bazen
	 * e te dhenave e cila mban informacion rreth emrit te tipit te direct_x
	 */
	private String directXType;

	@Column(name = "direct_x_description", nullable = false, length = 65535)
	/**
	 * Variabli ben lidhjen me fushen "direct_x_description" te tabeles "direct_x"
	 * ne bazen e te dhenave e cila mban informacione te pergjithshme per nje lloj
	 * direct x
	 */
	private String directXDescription;

	@OneToMany(mappedBy = "maximumDirectXSupportedByThisGpu")
	private List<GPU> gpusOfThisDirectX = new ArrayList<GPU>();

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
