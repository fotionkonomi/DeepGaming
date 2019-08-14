package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.ChipsetRepository;
import al.edu.fti.gaming.models.Chipset;

@Repository
public class ChipsetRepositoryImpl implements ChipsetRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public int add(Chipset chipset) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(chipset);
			tx.commit();
			idOrNotSuccessful = chipset.getIdChipset();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<Chipset> getAllChipsets() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT c FROM Chipset c order by c.id desc");
		return query.list();
	}

	@Override
	public Chipset getChipsetById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select c from Chipset c where c.idChipset = :id");
		query.setInteger("id", id);
		return (Chipset) query.uniqueResult();
	}

	@Override
	public boolean update(Chipset chipset) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(chipset);
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
	public List<Chipset> getChipsetsByCompany(String companyName) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(
				"SELECT ch FROM Chipset ch INNER JOIN ch.companyThatCreatedThisChipset c where c.companyName = :companyName ");
		query.setString("companyName", companyName);
		return query.list();
	}

}
