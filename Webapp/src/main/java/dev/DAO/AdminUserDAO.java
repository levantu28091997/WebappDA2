package dev.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.DAO.entity.AdminUser;

@Repository("AdminUserDAO")
@Transactional
public class AdminUserDAO {
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<AdminUser> getList() {
		List<AdminUser> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(AdminUser.class);
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	public Boolean update(AdminUser adminuser) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(adminuser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}

	public AdminUser getItem(Integer id) {
		AdminUser adminuser = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			adminuser = (AdminUser) session.get(AdminUser.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return adminuser;
	}

	public Boolean checkAuth(String email, String password) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(AdminUser.class);
			cr.add(Restrictions.eq("email", email).ignoreCase());
			cr.add(Restrictions.eq("password", password).ignoreCase());
			return !cr.list().isEmpty();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
