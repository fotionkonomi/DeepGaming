package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.CpuRepository;
import al.edu.fti.gaming.models.CPU;
import al.edu.fti.gaming.models.CpuSocket;

@Repository
public class CpuRepositoryImpl implements CpuRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(CPU cpu) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(cpu);
			tx.commit();
			idOrNotSuccessful = cpu.getIdProduct();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	public CPU getCpuById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT c FROM CPU c WHERE c.idProduct = :id");
		query.setInteger("id", id);
		return (CPU) query.uniqueResult();
	}

	@Override
	public List<CPU> getAllCpusInStock(int page, int numberOfItemsOnThePage) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT c FROM CPU c WHERE c.quantity is not NULL or c.quantity != 0");
		if (page != 0) {
			page = page * numberOfItemsOnThePage;
		}
		query.setFirstResult(page);
		query.setMaxResults(numberOfItemsOnThePage);
		return query.list();
	}

	@Override
	public Long countOfCpusInStock() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT count(*) FROM CPU c where c.quantity is not NULL or c.quantity != 0");
		return (Long) query.uniqueResult();
	}

	@Override
	public List<CPU> getCpusByCpuFamily(Integer cpuFamilyId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT c FROM CPU c WHERE c.familyOfThisCpu.idCpuFamily = :id");
		query.setInteger("id", cpuFamilyId);
		return query.list();
	}

	@Override
	public void update(CPU cpu) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.update(cpu);

			tx.commit();
		} catch (HibernateException e) {

			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
