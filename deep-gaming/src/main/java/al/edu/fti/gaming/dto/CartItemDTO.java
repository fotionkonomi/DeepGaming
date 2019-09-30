package al.edu.fti.gaming.dto;

import java.io.Serializable;

public class CartItemDTO implements IDto, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6874173077918238309L;

	private Integer id;
	private ProductDTO product;
	private Integer quantity;
	private CartDTO idCart;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public CartDTO getIdCart() {
		return idCart;
	}

	public void setIdCart(CartDTO idCart) {
		this.idCart = idCart;
	}

}
