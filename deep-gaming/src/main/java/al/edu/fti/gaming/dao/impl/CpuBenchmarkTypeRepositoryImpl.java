package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.CpuBenchmarkTypeRepository;
import al.edu.fti.gaming.models.CpuBenchmarkType;

@Repository
public class CpuBenchmarkTypeRepositoryImpl implements CpuBenchmarkTypeRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int add(CpuBenchmarkType benchmarkType) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(benchmarkType);
			tx.commit();
			idOrNotSuccessful = benchmarkType.getIdCpuBenchmarkType();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
			e.printStackTrace();
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<CpuBenchmarkType> getAllBenchmarkTypes() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select cbt FROM CpuBenchmarkType cbt");
		return query.list();
	}

	@Override
	public CpuBenchmarkType getBenchmarkTypeById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT cbt FROM CpuBenchmarkType cbt WHERE cbt.idCpuBenchmarkType = :id");
		query.setInteger("id", id);
		return (CpuBenchmarkType) query.uniqueResult();
	}

	@Override
	public boolean update(CpuBenchmarkType benchmarkType) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(benchmarkType);
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
