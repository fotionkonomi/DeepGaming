package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.MotherboardRepository;
import al.edu.fti.gaming.models.Motherboard;

@Repository
public class MotherboardRepositoryImpl implements MotherboardRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(Motherboard motherboard) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(motherboard);
			tx.commit();
			idOrNotSuccessful = motherboard.getIdProduct();
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
	public Motherboard getMotherboardById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT m FROM Motherboard m WHERE m.idProduct = :idProduct");
		query.setInteger("idProduct", id);
		return (Motherboard) query.uniqueResult();
	}

	@Override
	public Long countMotherboardsInStock() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("SELECT count(*) FROM Motherboard m WHERE m.quantity is not NULL or m.quantity != 0");
		return (Long) query.uniqueResult();
	}

	@Override
	public List<Motherboard> getAllMotherboardsInStock(int page, int numberOfItemsOnThePage) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("SELECT m FROM Motherboard m WHERE m.quantity is not NULL or m.quantity != 0");
		if (page != 0) {
			page = page * numberOfItemsOnThePage;
		}
		query.setFirstResult(page);
		query.setMaxResults(numberOfItemsOnThePage);

		return query.list();
	}

	@Override
	public void update(Motherboard motherboard) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.update(motherboard);
			tx.commit();
		} catch (HibernateException e) {

			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}		
	}
}
