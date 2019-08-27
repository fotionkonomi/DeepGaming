package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.EsrbRatingsRepository;
import al.edu.fti.gaming.models.EsrbRatings;

@Repository
public class EsrbRatingsRepositoryImpl implements EsrbRatingsRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public int add(EsrbRatings esrbRatings) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(esrbRatings);
			tx.commit();
			idOrNotSuccessful = esrbRatings.getIdEsrbRating();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<EsrbRatings> getAllEsrbRatings() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select er from EsrbRatings er");
		return query.list();

	}

	@Override
	public EsrbRatings getEsrbRatingsById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select er from EsrbRatings er WHERE er.idEsrbRating = :id");
		query.setParameter("id", id);
		return (EsrbRatings)query.uniqueResult();

	}

	@Override
	public boolean update(EsrbRatings esrbRatings) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.update(esrbRatings);
			tx.commit();
			successfulOrNot = true;
		} catch (HibernateException e) {
			tx.rollback();
			successfulOrNot = false;
		} finally {
			session.close();
		}
		return successfulOrNot;
	}

}
