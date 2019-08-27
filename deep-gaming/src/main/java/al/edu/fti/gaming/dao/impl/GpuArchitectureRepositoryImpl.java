package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.GpuArchitectureRepository;
import al.edu.fti.gaming.models.CpuArchitecture;
import al.edu.fti.gaming.models.GpuArchitecture;

@Repository
public class GpuArchitectureRepositoryImpl implements GpuArchitectureRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int add(GpuArchitecture gpuArchitecture) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(gpuArchitecture);
			tx.commit();
			idOrNotSuccessful = gpuArchitecture.getIdGpuArchitecture();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<GpuArchitecture> getAllGpuArchitectures() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select ga FROM GpuArchitecture ga");
		return query.list();
	}

	@Override
	public GpuArchitecture getGpuArchitectureById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT ga FROM GpuArchitecture ga WHERE ga.idGpuArchitecture = :id");
		query.setInteger("id", id);
		return (GpuArchitecture) query.uniqueResult();
	}

	@Override
	public boolean update(GpuArchitecture gpuArchitecture) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(gpuArchitecture);
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

	@Override
	public List<GpuArchitecture> getGpuArchitecturesByCompany(String companyName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"SELECT ga FROM GpuArchitecture ga INNER JOIN ga.companyOfThisGpuArchitecture c where c.companyName = :companyName");
		query.setString("companyName", companyName);
		return query.list();
	}

}
