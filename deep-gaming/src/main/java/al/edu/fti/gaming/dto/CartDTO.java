package al.edu.fti.gaming.dto;

import java.io.Serializable;

public class CartDTO implements Serializable, IDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2779005992205341693L;

	private Integer id;

	private UserDTO user;
	
	private Integer reserved;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Integer getReserved() {
		return reserved;
	}

	public void setReserved(Integer reserved) {
		this.reserved = reserved;
	}

}
