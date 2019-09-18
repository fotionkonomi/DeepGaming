package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.DirectXRepository;
import al.edu.fti.gaming.models.DirectX;

@Repository
public class DirectXRepositoryImpl implements DirectXRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(DirectX directX) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(directX);
			tx.commit();
			idOrNotSuccessful = directX.getIdDirectX();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<DirectX> getAllDirectXs() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select dx FROM DirectX dx");
		return query.list();
	}

	@Override
	public DirectX getDirectXById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("SELECT dx FROM DirectX dx WHERE dx.idDirectX = :id");
		query.setInteger("id", id);
		return (DirectX) query.uniqueResult();
	}

	@Override
	public boolean update(DirectX directX) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(directX);
			session.getTransaction().commit();
			successfulOrNot = true;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			successfulOrNot = false;
		} finally {
			session.close();
		}
		return successfulOrNot;
	}

}
