package airlinebooking.core.ws.repo;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airlinebooking.core.ws.exception.DataAccessException;

@Repository
public class SelectRepoImpl extends AbstractQueryRepo implements SelectRepo {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public <T> T getEntityById(Class<T> clazz, Serializable id)
			throws DataAccessException {
		try {
			Session session = sessionFactory.getCurrentSession();
			return clazz.cast(session.get(clazz, id));
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getEntityByHQL(String hql, List<Object> params)
			throws DataAccessException {
		try {

			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			addParameters(query, params);
			query.setCacheable(true);
			query.setMaxResults(1);
			return (T) query.uniqueResult();
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getListByHQL(String hql, List<Object> params)
			throws DataAccessException {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(hql);
			addParameters(query, params);
			query.setCacheable(true);
			return query.list();
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public <T> List<T> getListBySQL(Class<T> clazz, String sql,
			List<Object> params) throws DataAccessException {
		return getListBySQL(clazz, sql, params, null, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> getListBySQL(Class<T> clazz, String sql,
			List<Object> params, List<Class<?>> synchronizedClass,
			Integer maxResult) throws DataAccessException {
		try {
			Session session = sessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery(sql);
			addParameters(query, params);
			addSynchronizedClass(query, synchronizedClass);
			query.setCacheable(true);
			query.addEntity(clazz);

			if (maxResult != null && maxResult > 0) {
				query.setMaxResults(maxResult);
			}

			return query.list();
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}
}
