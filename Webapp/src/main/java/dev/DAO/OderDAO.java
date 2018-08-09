package dev.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.DAO.entity.Oders;

@Repository("OderDAO")
@Transactional
public class OderDAO {
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Oders> findAll() {
		List<Oders> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Oders.class);
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Oders findOne(Integer id) {
		Oders item = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			item = (Oders) session.get(Oders.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	public Boolean insert(Oders oders) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(oders);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean update(Oders oders) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(oders);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}

	public Boolean merge(Oders oders) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.merge(oders);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean delete(Integer id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Object object = session.load(Oders.class, id);
			session.delete(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
