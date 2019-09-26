package al.edu.fti.gaming.dao.impl;

import org.hibernate.HibernateException;
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
}
