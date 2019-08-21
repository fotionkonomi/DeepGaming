package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.CpuFamilyRepository;
import al.edu.fti.gaming.models.CpuArchitecture;
import al.edu.fti.gaming.models.CpuFamily;

@Repository
public class CpuFamilyRepositoryImpl implements CpuFamilyRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int add(CpuFamily cpuFamily) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(cpuFamily);
			tx.commit();
			idOrNotSuccessful = cpuFamily.getIdCpuFamily();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<CpuFamily> getAllCpuFamilies() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select cf FROM CpuFamily cf");
		return query.list();
	}

	@Override
	public CpuFamily getCpuFamilyById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT cf FROM CpuFamily cf WHERE cf.idCpuFamily = :id");
		query.setInteger("id", id);
		return (CpuFamily) query.uniqueResult();
	}

	@Override
	public boolean update(CpuFamily cpuFamily) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(cpuFamily);
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
	public List<CpuFamily> getCpuFamiliesByCompany(String companyName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"SELECT cf FROM CpuFamily cf INNER JOIN cf.companyOfThisCpuFamily c where c.companyName = :companyName");
		query.setString("companyName", companyName);
		return query.list();
	}

}
