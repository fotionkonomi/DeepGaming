package al.edu.fti.gaming.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.UserRepository;
import al.edu.fti.gaming.models.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(User user) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(user);
			tx.commit();
			idOrNotSuccessful = user.getIdUser();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public boolean update(User user) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(user);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Override
	public User findUserByUsername(String username) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("SELECT u FROM User u WHERE u.username = :username");
			query.setString("username", username);
			return (User) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
}
