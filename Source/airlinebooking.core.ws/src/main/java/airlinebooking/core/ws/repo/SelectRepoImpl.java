package airlinebooking.core.ws.repo;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
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

}
