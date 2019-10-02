package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.CartRepository;
import al.edu.fti.gaming.models.Cart;
import al.edu.fti.gaming.models.CartItem;
import al.edu.fti.gaming.models.User;

@Repository
public class CartRepositoryImpl implements CartRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int addCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cart);
		return cart.getIdCart();

	}

	@Override
	public Cart notReservedCartOfAUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT c FROM Cart c WHERE c.user.idUser = :id AND c.reserved = :reserved");
		query.setInteger("id", user.getIdUser());
		query.setInteger("reserved", 0);
		return (Cart) query.uniqueResult();

	}

	@Override
	public List<CartItem> cartItemsOfACart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT ci FROM CartItem ci WHERE ci.cart.idCart = :idCart");
		query.setInteger("idCart", cart.getIdCart());
		return query.list();
	}

	@Override
	public void addCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
	}

	@Override
	public CartItem getCartItemById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT ci FROM CartItem ci WHERE ci.id = :id");
		query.setInteger("id", id);
		return (CartItem) query.uniqueResult();
	}

	@Override
	public void deleteCartItem(CartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
	}

	@Override
	public void updateCart(Cart cart) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cart);
	}

	@Override
	public List<Cart> getAllReservations() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT c FROM Cart c WHERE c.reserved = :reserved");
		query.setInteger("reserved", 1);
		return query.list();
	}

	@Override
	public Cart getCartById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT c FROM Cart c WHERE c.id = :id");
		query.setInteger("id", id);
		return (Cart) query.uniqueResult();
	}
}
