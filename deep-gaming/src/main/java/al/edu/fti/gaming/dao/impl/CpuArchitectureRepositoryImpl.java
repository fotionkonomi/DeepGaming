package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.CpuArchitectureRepository;
import al.edu.fti.gaming.models.CpuArchitecture;

@Repository
public class CpuArchitectureRepositoryImpl implements CpuArchitectureRepository {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(CpuArchitecture cpuArchitecture) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(cpuArchitecture);
			tx.commit();
			idOrNotSuccessful = cpuArchitecture.getIdCpuArchitecture();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<CpuArchitecture> getAllCpuArchitectures() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select ca FROM CpuArchitecture ca");
		return query.list();
	}

	@Override
	public CpuArchitecture getCpuArchitectureById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT ca FROM CpuArchitecture ca WHERE ca.idCpuArchitecture = :id");
		query.setInteger("id", id);
		return (CpuArchitecture) query.uniqueResult();
	}

	@Override
	public boolean update(CpuArchitecture cpuArchitecture) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(cpuArchitecture);
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
