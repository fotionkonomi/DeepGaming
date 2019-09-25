package al.edu.fti.gaming.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.ProductTypeRepository;
import al.edu.fti.gaming.models.ProductType;

@Repository
public class ProductTypeRepositoryImpl implements ProductTypeRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ProductType getCpuProductType() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT pt FROM ProductType pt WHERE pt.productType = :productType");
		query.setString("productType", "Cpu");
		return (ProductType)query.uniqueResult();

	}

	@Override
	public ProductType getGpuProductType() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT pt FROM ProductType pt WHERE pt.productType = :productType");
		query.setString("productType", "Gpu");
		return (ProductType)query.uniqueResult();

	}

	@Override
	public ProductType getGameProductType() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT pt FROM ProductType pt WHERE pt.productType = :productType");
		query.setString("productType", "Game");
		return (ProductType)query.uniqueResult();

	}

	@Override
	public ProductType getMotherboardProductType() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT pt FROM ProductType pt WHERE pt.productType = :productType");
		query.setString("productType", "Motherboard");
		return (ProductType)query.uniqueResult();

	}

}
