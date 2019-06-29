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
@Table(name = "direct_x")
/**
 * This class is mapped to the "direct_x" table in the database and it contains
 * information for all DirectX technologies
 * 
 * @author kfotj
 *
 */
public class DirectX implements Serializable, IModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2892811188256036901L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_direct_x", nullable = false)
	/**
	 * Celesi primar ne tabelen "direct_x" ne bazen e te dhenave
	 */
	private Integer idDirectX;

	@Column(name = "direct_x_type", unique = true, nullable = false, length = 50)
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

	@OneToMany(mappedBy = "directXMinimum")
	private List<Game> gamesThatHaveThisDirectXAsMinimum = new ArrayList<Game>();

	public DirectX(Integer idDirectX, String directXType, String directXDescription, List<GPU> gpusOfThisDirectX,
			List<Game> gamesThatHaveThisDirectXAsMinimum) {
		super();
		this.idDirectX = idDirectX;
		this.directXType = directXType;
		this.directXDescription = directXDescription;
		this.gpusOfThisDirectX = gpusOfThisDirectX;
		this.gamesThatHaveThisDirectXAsMinimum = gamesThatHaveThisDirectXAsMinimum;
	}

	public DirectX() {

	}

	public Integer getIdDirectX() {
		return idDirectX;
	}

	public void setIdDirectX(Integer idDirectX) {
		this.idDirectX = idDirectX;
	}

	public String getDirectXType() {
		return directXType;
	}

	public void setDirectXType(String directXType) {
		this.directXType = directXType;
	}

	public String getDirectXDescription() {
		return directXDescription;
	}

	public void setDirectXDescription(String directXDescription) {
		this.directXDescription = directXDescription;
	}

	public List<GPU> getGpusOfThisDirectX() {
		return gpusOfThisDirectX;
	}

	public void setGpusOfThisDirectX(List<GPU> gpusOfThisDirectX) {
		this.gpusOfThisDirectX = gpusOfThisDirectX;
	}

	public List<Game> getGamesThatHaveThisDirectXAsMinimum() {
		return gamesThatHaveThisDirectXAsMinimum;
	}

	public void setGamesThatHaveThisDirectXAsMinimum(List<Game> gamesThatHaveThisDirectXAsMinimum) {
		this.gamesThatHaveThisDirectXAsMinimum = gamesThatHaveThisDirectXAsMinimum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((directXDescription == null) ? 0 : directXDescription.hashCode());
		result = prime * result + ((directXType == null) ? 0 : directXType.hashCode());
		result = prime * result
				+ ((gamesThatHaveThisDirectXAsMinimum == null) ? 0 : gamesThatHaveThisDirectXAsMinimum.hashCode());
		result = prime * result + ((gpusOfThisDirectX == null) ? 0 : gpusOfThisDirectX.hashCode());
		result = prime * result + ((idDirectX == null) ? 0 : idDirectX.hashCode());
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
		DirectX other = (DirectX) obj;
		if (directXDescription == null) {
			if (other.directXDescription != null)
				return false;
		} else if (!directXDescription.equals(other.directXDescription))
			return false;
		if (directXType == null) {
			if (other.directXType != null)
				return false;
		} else if (!directXType.equals(other.directXType))
			return false;
		if (gamesThatHaveThisDirectXAsMinimum == null) {
			if (other.gamesThatHaveThisDirectXAsMinimum != null)
				return false;
		} else if (!gamesThatHaveThisDirectXAsMinimum.equals(other.gamesThatHaveThisDirectXAsMinimum))
			return false;
		if (gpusOfThisDirectX == null) {
			if (other.gpusOfThisDirectX != null)
				return false;
		} else if (!gpusOfThisDirectX.equals(other.gpusOfThisDirectX))
			return false;
		if (idDirectX == null) {
			if (other.idDirectX != null)
				return false;
		} else if (!idDirectX.equals(other.idDirectX))
			return false;
		return true;
	}

}
