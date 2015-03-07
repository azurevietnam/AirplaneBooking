package airlinebooking.core.ws.repo;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airlinebooking.core.ws.exception.DataAccessException;

@Repository
public class SelectRepoImpl implements SelectRepo {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public <T> T getEntityById(Class<T> clazz, Serializable id) throws DataAccessException {
		try {
			Session session = sessionFactory.getCurrentSession();
			return clazz.cast(session.get(clazz, id));
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public <T> T getEntityByHQL(String hql, List<Object> params) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
