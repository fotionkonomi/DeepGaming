package al.edu.fti.gaming.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import al.edu.fti.gaming.dao.RoleRepository;
import al.edu.fti.gaming.models.Role;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Role getAdminRole() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT r FROM Role r WHERE r.roleName = :roleName");
		query.setString("roleName", "Admin");
		return (Role) query.uniqueResult();
	}

	@Override
	public Role getUserRole() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("SELECT r FROM Role r WHERE r.roleName = :roleName");
		query.setString("roleName", "User");
		return (Role) query.uniqueResult();
	}
}
