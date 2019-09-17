package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.GpuRepository;
import al.edu.fti.gaming.models.GPU;

@Repository
public class GpuRepositoryImpl implements GpuRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(GPU gpu) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(gpu);
			tx.commit();
			idOrNotSuccessful = gpu.getIdProduct();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public GPU getGpuById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT g FROM GPU g WHERE g.idProduct = :id");
		query.setInteger("id", id);
		return (GPU) query.uniqueResult();
	}

	@Override
	public List<GPU> getAllGpusInStock(int page, int numberOfItemsOnThePage) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT g FROM GPU g WHERE g.quantity is not NULL or g.quantity != 0");
		if (page != 0) {
			page = page * numberOfItemsOnThePage;
		}
		query.setFirstResult(page);
		query.setMaxResults(numberOfItemsOnThePage);
		return query.list();
	}

	@Override
	public Long countOfGpusInStock() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT count(*) FROM GPU g where g.quantity is not NULL or g.quantity != 0");
		return (Long) query.uniqueResult();
	}

	@Override
	public List<GPU> getGpuByGpuFamily(Integer gpuFamilyId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT g FROM GPU g WHERE g.familyOfThisGpu.idGpuFamily = :id");
		query.setInteger("id", gpuFamilyId);
		return query.list();
	}

	@Override
	public void update(GPU gpu) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.update(gpu);

			tx.commit();
		} catch (HibernateException e) {

			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public List<GPU> getAllGpus() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT g FROM GPU g");
		return query.list();
	}

}
