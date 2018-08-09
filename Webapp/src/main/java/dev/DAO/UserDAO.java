package dev.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.DAO.entity.Users;

@Repository("UserDAO")
@Transactional
public class UserDAO {
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Users> getList() {
		List<Users> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Users.class);
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	public Users getItem(Integer id) {
		Users user = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			user = (Users) session.get(Users.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return user;
	}

	public Boolean insert(Users user) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}

	public Boolean update(Users user) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
	
	public Users checkAuth(String email, String password) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Users.class);
			cr.add(Restrictions.eq("email", email).ignoreCase());
			cr.add(Restrictions.eq("password", password).ignoreCase());
			return (Users) cr.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
