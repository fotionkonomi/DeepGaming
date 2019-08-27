package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.GpuSlotRepository;
import al.edu.fti.gaming.models.GpuSlot;

@Repository
public class GpuSlotRepositoryImpl implements GpuSlotRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(GpuSlot gpuSlot) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(gpuSlot);
			tx.commit();
			idOrNotSuccessful = gpuSlot.getIdGpuSlot();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<GpuSlot> allGpuSlots() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select gs FROM GpuSlot gs");
		return query.list();
	}

	@Override
	public GpuSlot getGpuSlotById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT gs FROM GpuSlot gs WHERE gs.idGpuSlot = :id");
		query.setInteger("id", id);
		return (GpuSlot) query.uniqueResult();
	}

	@Override
	public boolean update(GpuSlot gpuSlot) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(gpuSlot);
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
