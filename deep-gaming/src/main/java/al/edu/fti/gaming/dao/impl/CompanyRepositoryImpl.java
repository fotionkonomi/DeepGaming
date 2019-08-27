package al.edu.fti.gaming.dao.impl;

import java.util.ArrayList;
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
import al.edu.fti.gaming.models.CpuArchitecture;

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

	@Override
	public List<Company> getAllCompaniesThatHaveCpuSockets() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT DISTINCT c FROM Company c INNER JOIN c.cpuSocketsOfThisCompany");
		return query.list();
	}

	@Override
	public List<Company> getAllCompaniesThatHaveChipsets() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT DISTINCT c FROM Company c INNER JOIN c.chipsetsOfThisCompany");
		return query.list();
	}

	@Override
	public List<Company> getAllCompaniesThatHaveCpuArchitectures() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT DISTINCT c FROM Company c INNER JOIN c.cpuArchitecturesOfThisCompany");
		return query.list();
	}

	@Override
	public List<Company> getAllCompaniesThatHaveCpuFamilies() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT DISTINCT c FROM Company c INNER JOIN c.cpuFamiliesOfThisCompany");
		return query.list();
	}

	@Override
	public List<Company> getAllCompaniesThatHaveGpuArchitectures() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT DISTINCT c FROM Company c INNER JOIN c.gpuArchitecturesOfThisCompany");
		return query.list();
	}

	@Override
	public List<Company> getAllCompaniesThatHaveGpuFamilies() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT DISTINCT c FROM Company c INNER JOIN c.gpuFamiliesOfThisCompany");
		return query.list();
	}

	@Override
	public List<Company> getAllCompaniesThatHaveOS() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT DISTINCT c FROM Company c INNER JOIN c.operatingSystemsOfThisCompany");
		return query.list();
	}

}
