package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.CompanyRepository;
import al.edu.fti.gaming.models.Company;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public int add(Company company) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(company);
			tx.commit();
			idOrNotSuccessful = company.getIdCompany();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<Company> getAllCompanies() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT c FROM Company c order by c.id desc");
		return query.list();
	}

	@Override
	public Company getCompanyById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select c from Company c where c.idCompany = :id");
		query.setInteger("id", id);
		return (Company) query.uniqueResult();
	}

	@Override
	public boolean update(Company company) {
		Session session = sessionFactory.openSession();
		boolean successfulOrNot;
		try {
			session.getTransaction().begin();
			session.update(company);
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