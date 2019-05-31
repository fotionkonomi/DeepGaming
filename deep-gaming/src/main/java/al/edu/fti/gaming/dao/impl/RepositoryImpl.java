package al.edu.fti.gaming.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import al.edu.fti.gaming.dao.Repository;
import al.edu.fti.gaming.models.EsrbRatings;

@org.springframework.stereotype.Repository
@Transactional
public class RepositoryImpl implements Repository {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void add(EsrbRatings esrbRating) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(esrbRating);
	}

}
