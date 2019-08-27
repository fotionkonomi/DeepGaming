package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.OperatingSystemTypeRepository;
import al.edu.fti.gaming.models.GpuFamily;
import al.edu.fti.gaming.models.OperatingSystemType;

@Repository
public class OperatingSystemTypeRepositoryImpl implements OperatingSystemTypeRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(OperatingSystemType operatingSystemType) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(operatingSystemType);
			tx.commit();
			idOrNotSuccessful = operatingSystemType.getIdOperatingSystemType();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<OperatingSystemType> getAllOperatingSystemTypes() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select ost FROM OperatingSystemType ost");
		return query.list();
	}

	@Override
	public OperatingSystemType getOperatingSystemTypeById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("SELECT ost FROM OperatingSystemType ost WHERE ost.idOperatingSystemType = :id");
		query.setInteger("id", id);
		return (OperatingSystemType) query.uniqueResult();
	}

	@Override
	public boolean update(OperatingSystemType operatingSystemType) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(operatingSystemType);
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
	public List<OperatingSystemType> getAllOperatingSystemTypesThatHaveOperatingSystems() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("SELECT ost FROM OperatingSystemType ost INNER JOIN ost.operatingSystemsOfThisType");
		return query.list();
	}

	@Override
	public List<OperatingSystemType> getAllOperatingSystemTypesByCompanyName(String companyName) {
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("SELECT ost FROM OperatingSystemType ost INNER JOIN ost.companyOfThisOS c Where c.companyName = :companyName");
		query.setParameter("companyName", companyName);
		return query.list();
	}

}
