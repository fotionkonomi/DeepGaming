package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.GpuMemoryTechnologyRepository;
import al.edu.fti.gaming.models.GpuMemoryTechnology;
import al.edu.fti.gaming.models.GpuSlot;

@Repository
public class GpuMemoryTechnologyRepositoryImpl implements GpuMemoryTechnologyRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(GpuMemoryTechnology gpuMemoryTechnology) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(gpuMemoryTechnology);
			tx.commit();
			idOrNotSuccessful = gpuMemoryTechnology.getIdGpuMemoryTechnology();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<GpuMemoryTechnology> getAllGpuMemoryTechnologies() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select gmt FROM GpuMemoryTechnology gmt");
		return query.list();
	}

	@Override
	public GpuMemoryTechnology getGpuMemoryTechnologyById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT gmt FROM GpuMemoryTechnology gmt WHERE gmt.idGpuMemoryTechnology = :id");
		query.setInteger("id", id);
		return (GpuMemoryTechnology) query.uniqueResult();
	}

	@Override
	public boolean update(GpuMemoryTechnology gpuMemoryTechnology) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(gpuMemoryTechnology);
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
