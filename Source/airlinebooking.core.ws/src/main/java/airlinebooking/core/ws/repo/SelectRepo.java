package airlinebooking.core.ws.repo;

import java.io.Serializable;
import java.util.List;

import airlinebooking.common.exception.DataAccessException;

public interface SelectRepo {
	<T> T loadEntityById(Class<T> clazz, Serializable id)  throws DataAccessException;
	
	<T> T getEntityById(Class<T> clazz, Serializable id)
			throws DataAccessException;

	<T> T getEntityByHQL(String hql, List<Object> params)
			throws DataAccessException;

	public <T> List<T> getListByHQL(String hql, List<Object> params)
			throws DataAccessException;

	public <T> List<T> getListBySQL(Class<T> clazz, String sql,
			List<Object> params) throws DataAccessException;
	
	public <T> List<T> getListBySQL(Class<T> clazz, String sql,
			List<Object> params, List<Class<?>> synchronizedClass,
			Integer maxResult) throws DataAccessException;
}
