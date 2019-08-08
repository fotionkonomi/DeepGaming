package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.CpuSocketRepository;
import al.edu.fti.gaming.models.CpuSocket;

@Repository
public class CpuSocketRepositoryImpl implements CpuSocketRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public int add(CpuSocket cpuSocket) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(cpuSocket);
			tx.commit();
			idOrNotSuccessful = cpuSocket.getIdCpuSocket();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<CpuSocket> getAllCpuSockets() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select cs FROM CpuSocket cs");
		return query.list();
	}

	@Override
	public CpuSocket getCpuSocketById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT cs FROM CpuSocket cs WHERE cs.idCpuSocket = :id");
		query.setInteger("id", id);
		return (CpuSocket) query.uniqueResult();
	}

	@Override
	public boolean update(CpuSocket cpuSocket) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(cpuSocket);
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
