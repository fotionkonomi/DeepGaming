package al.edu.fti.gaming.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.ProductRepository;
import al.edu.fti.gaming.models.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product getProductById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT p FROM Product p WHERE p.id = :id");
		query.setInteger("id", id);
		return (Product) query.uniqueResult();
	}

	@Override
	public void updateProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
	}
}
