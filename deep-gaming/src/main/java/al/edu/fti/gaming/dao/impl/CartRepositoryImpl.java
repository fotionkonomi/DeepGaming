package al.edu.fti.gaming.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.CartRepository;
import al.edu.fti.gaming.models.Cart;
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
}
