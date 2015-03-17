package airlinebooking.core.ws.repo;

import airlinebooking.common.exception.DataAccessException;

public interface CrudRepo {
	<T> T create(T object) throws DataAccessException;

	void update(Object object) throws DataAccessException;

	void delete(Object object) throws DataAccessException;
}
