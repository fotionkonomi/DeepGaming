package al.edu.fti.gaming.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.GameRepository;
import al.edu.fti.gaming.models.Game;

@Repository
public class GameRepositoryImpl implements GameRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(Game game) {
		Session session = sessionFactory.openSession();
		int idOrNotSuccessful;
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.save(game);
			tx.commit();
			idOrNotSuccessful = game.getIdProduct();
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
	public Game getGameById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT g FROM Game g WHERE g.idProduct = :id");
		query.setInteger("id", id);
		return (Game) query.uniqueResult();
	}

	@Override
	public Long countGames() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("SELECT count(*) FROM Game m WHERE m.quantity is not NULL or m.quantity != 0");
		return (Long) query.uniqueResult();
	}

	@Override
	public List<Game> getAllGamesInStock(int page, int numberOfItemsOnThePage) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT m FROM Game m WHERE m.quantity is not NULL or m.quantity != 0");
		if (page != 0) {
			page = page * numberOfItemsOnThePage;
		}
		query.setFirstResult(page);
		query.setMaxResults(numberOfItemsOnThePage);

		return query.list();
	}

}