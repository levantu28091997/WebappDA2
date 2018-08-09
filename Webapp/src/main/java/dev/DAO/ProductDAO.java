package dev.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.DAO.entity.Product;

@Repository("ProductDAO")
@Transactional
public class ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	CategoryDAO categoryDAO;

	private Integer page = 0, maxRows = 0;

	public void setPage(Integer page) {
		this.page = page - 1;
	}

	public Double getPage() {
		return Math.ceil(count() / 10);
	}

	public void setRows(Integer maxRows) {
		this.maxRows = maxRows;
	}

	public Long count() {
		return (Long) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setProjection(Projections.rowCount()).uniqueResult();
	}

	/**
	 * Get List
	 * 
	 * @return {@link List}
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getList() {
		List<Product> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(Product.class);
			if (page != 0)
				criteria.setFirstResult(page * maxRows);
			if (maxRows != 0)
				criteria.setMaxResults(maxRows);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Get One Item
	 * 
	 * @param id
	 * @return {@link List}
	 */
	public Product getItem(Integer id) {
		Product product = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			product = (Product) session.get(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;
	}

	/**
	 * Insert One Item
	 * 
	 * @param product
	 * @return {@link Boolean}
	 */
	public Boolean insert(Product product) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Update One Item
	 * 
	 * @param product
	 * @param id
	 * @return {@link Boolean}
	 */
	public Boolean update(Product product) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Delete One Item
	 * 
	 * @param id
	 * @return {@link Boolean}
	 */
	public Boolean delete(Integer id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Object object = session.load(Product.class, id);
			session.delete(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// Get New Products maxresult = 4
	@SuppressWarnings("unchecked")
	public List<Product> getNewProducts() {
		List<Product> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM Product P ORDER BY P.id ASC";
			Query query = session.createQuery(hql);
			query.setMaxResults(4);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// Get Popular oderby viewed maxresult = 4
	@SuppressWarnings("unchecked")
	public List<Product> getPopularProducts() {
		List<Product> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM Product P ORDER BY P.id DESC";
			Query query = session.createQuery(hql);
			query.setMaxResults(4);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// Get List Product by product.cate_id
	@SuppressWarnings("unchecked")
	public List<Product> getProducts(Integer id) {
		List<Product> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "FROM Product P WHERE P.category.id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}


	@SuppressWarnings("unchecked")
	public List<Product> getByIDCate(Integer id) {
		List<Product> list = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Product.class);
			cr.add(Restrictions.eq("cate_id", id));
			list = cr.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
