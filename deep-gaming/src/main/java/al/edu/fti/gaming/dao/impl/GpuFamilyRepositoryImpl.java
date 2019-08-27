package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.GpuFamilyRepository;
import al.edu.fti.gaming.models.GpuFamily;

@Repository
public class GpuFamilyRepositoryImpl implements GpuFamilyRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int add(GpuFamily gpuFamily) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(gpuFamily);
			tx.commit();
			idOrNotSuccessful = gpuFamily.getIdGpuFamily();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<GpuFamily> getAllGpuFamilies() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select gf FROM GpuFamily gf");
		return query.list();
	}

	@Override
	public GpuFamily getGpuFamilyById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT gf FROM GpuFamily gf WHERE gf.idGpuFamily = :id");
		query.setInteger("id", id);
		return (GpuFamily) query.uniqueResult();
	}

	@Override
	public boolean update(GpuFamily gpuFamily) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(gpuFamily);
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
	public List<GpuFamily> getGpuFamiliesByCompany(String companyName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"SELECT gf FROM GpuFamily gf INNER JOIN gf.companyOfThisGpuFamily c where c.companyName = :companyName");
		query.setString("companyName", companyName);
		return query.list();
	}

}
