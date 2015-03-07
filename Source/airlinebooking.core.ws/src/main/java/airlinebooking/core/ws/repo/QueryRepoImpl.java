package airlinebooking.core.ws.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import airlinebooking.core.ws.exception.DataAccessException;

@Repository
public class QueryRepoImpl implements QueryRepo {
	@Autowired
	CrudRepo crudRepo;
	
	@Autowired
	SelectRepo queryRepo;
	
	@Override
	@Transactional
	public <T> T create(T object) throws DataAccessException {
		return crudRepo.create(object);
	}

	@Override
	@Transactional
	public void update(Object object) throws DataAccessException {
		crudRepo.update(object);
	}

	@Override
	@Transactional
	public void delete(Object object) throws DataAccessException {
		crudRepo.delete(object);
	}

	@Override
	@Transactional
	public <T> T getEntityById(Class<T> clazz, Serializable id) throws DataAccessException {
		return queryRepo.getEntityById(clazz, id);
	}

	@Override
	public <T> T getEntityByHQL(String hql, List<Object> params) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
