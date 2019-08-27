package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.StorageTypeRepository;
import al.edu.fti.gaming.models.MotherboardFormFactor;
import al.edu.fti.gaming.models.StorageType;

@Repository
public class StorageTypeRepositoryImpl implements StorageTypeRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(StorageType storageType) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(storageType);
			tx.commit();
			idOrNotSuccessful = storageType.getIdStorageType();
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
	public List<StorageType> getAllStorageTypes() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select st FROM StorageType st");
		return query.list();
	}

	@Override
	public StorageType getStorageTypeById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT st FROM StorageType st WHERE st.idStorageType = :id");
		query.setInteger("id", id);
		return (StorageType) query.uniqueResult();
	}

	@Override
	public boolean update(StorageType storageType) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(storageType);
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
