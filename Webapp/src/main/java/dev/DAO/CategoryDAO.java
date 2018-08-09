package dev.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.DAO.entity.Categories;

@Repository("CategoryDAO")
@Transactional
public class CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Categories> getList() {
		List<Categories> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Categories.class);
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Categories> getlistCate() {
		List<Categories> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM Categories C ORDER BY C.id DESC";
			Query query = session.createQuery(hql);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Categories getItem(Integer id) {
		Categories categories = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			categories = (Categories) session.get(Categories.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return categories;
	}

	public Boolean insert(Categories categories) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(categories);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}

	public Boolean update(Categories categories) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(categories);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}

	public Boolean delete(Integer id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Object object = session.load(Categories.class, id);
			session.delete(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}

}
