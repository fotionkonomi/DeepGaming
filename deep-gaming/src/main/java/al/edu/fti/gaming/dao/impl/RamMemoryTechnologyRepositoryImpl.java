package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.RamMemoryTechnologyRepository;
import al.edu.fti.gaming.models.RamMemoryTechnology;

@Repository
public class RamMemoryTechnologyRepositoryImpl implements RamMemoryTechnologyRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int add(RamMemoryTechnology ramMemoryTechnology) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(ramMemoryTechnology);
			tx.commit();
			idOrNotSuccessful = ramMemoryTechnology.getIdRamMemoryTechnology();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<RamMemoryTechnology> getAllRamMemoryTechnologies() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select rmt FROM RamMemoryTechnology rmt");
		return query.list();
	}

	@Override
	public RamMemoryTechnology getRamMemoryTechnologyById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT rmt FROM RamMemoryTechnology rmt WHERE rmt.idRamMemoryTechnology = :id");
		query.setInteger("id", id);
		return (RamMemoryTechnology) query.uniqueResult();
	}

	@Override
	public boolean update(RamMemoryTechnology ramMemoryTechnology) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(ramMemoryTechnology);
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
