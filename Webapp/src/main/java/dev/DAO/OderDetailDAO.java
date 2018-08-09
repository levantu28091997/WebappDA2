package dev.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.DAO.entity.OderDetails;

@Repository("OderDetailDAO")
@Transactional
public class OderDetailDAO {
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<OderDetails> findAll() {
		List<OderDetails> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(OderDetails.class);
			return criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	public OderDetails findOne(Integer id) {
		OderDetails item = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			item = (OderDetails) session.get(OderDetails.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return item;
	}

	public Boolean insert(OderDetails oderdetails) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(oderdetails);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}

	public Boolean update(OderDetails oderdetails) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(oderdetails);
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
			Object object = session.load(OderDetails.class, id);
			session.delete(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}
}
