package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.CategoryOfGameRepository;
import al.edu.fti.gaming.models.CategoryOfGame;

@Repository
public class CategoryOfGameRepositoryImpl implements CategoryOfGameRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public int add(CategoryOfGame categoryOfGame) {
		Session session = sessionFactory.getCurrentSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(categoryOfGame);
			tx.commit();
			idOrNotSuccessful = categoryOfGame.getIdCategory();
		} catch (HibernateException e) {
			tx.rollback();
			idOrNotSuccessful = 0;
		} finally {
			session.close();
		}
		return idOrNotSuccessful;
	}

	@Override
	public List<CategoryOfGame> getAllCategories() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select c from CategoryOfGame c order by c.id desc");
		return query.list();

	}

	@Override
	public CategoryOfGame getCategoryById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("Select c from CategoryOfGame c where c.id = :id");
		query.setInteger("id", id);
		return (CategoryOfGame) query.uniqueResult();
	}

	@Override
	public boolean update(CategoryOfGame categoryOfGame) {
		Session session = sessionFactory.getCurrentSession();
		boolean successfulOrNot;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.update(categoryOfGame);
			tx.commit();
			successfulOrNot = true;
		} catch (HibernateException e) {
			tx.rollback();
			successfulOrNot = false;
		} finally {
			session.close();
		}
		return successfulOrNot;
	}

}
