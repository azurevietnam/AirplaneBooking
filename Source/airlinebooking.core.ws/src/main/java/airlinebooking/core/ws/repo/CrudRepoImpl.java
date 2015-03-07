package airlinebooking.core.ws.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airlinebooking.core.ws.exception.DataAccessException;

@Repository
public class CrudRepoImpl implements CrudRepo {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public <T> T create(T object) throws DataAccessException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(object);
			return (T) object;
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public void update(Object object) throws DataAccessException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.merge(object);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

	@Override
	public void delete(Object object) throws DataAccessException {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(object);
		} catch (Exception e) {
			throw new DataAccessException(e);
		}
	}

}
