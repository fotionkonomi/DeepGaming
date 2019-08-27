package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.GpuBenchmarkTypeRepository;
import al.edu.fti.gaming.models.GpuBenchmarkType;

@Repository
public class GpuBenchmarkTypeRepositoryImpl implements GpuBenchmarkTypeRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(GpuBenchmarkType benchmarkType) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(benchmarkType);
			tx.commit();
			idOrNotSuccessful = benchmarkType.getIdGpuBenchmarkType();
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
	public List<GpuBenchmarkType> getAllBenchmarkTypes() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select gbt FROM GpuBenchmarkType gbt");
		return query.list();
	}

	@Override
	public GpuBenchmarkType getBenchmarkTypeById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT gbt FROM GpuBenchmarkType gbt WHERE gbt.idGpuBenchmarkType = :id");
		query.setInteger("id", id);
		return (GpuBenchmarkType) query.uniqueResult();
	}

	@Override
	public boolean update(GpuBenchmarkType benchmarkType) {
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
