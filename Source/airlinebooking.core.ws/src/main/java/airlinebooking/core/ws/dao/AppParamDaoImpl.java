package airlinebooking.core.ws.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.AppParam;
import airlinebooking.core.ws.repo.QueryRepo;

@Repository
public class AppParamDaoImpl implements AppParamDao{
	@Autowired
	QueryRepo repository;
	
	@Override
	public AppParam getAccountById(int id) throws DataAccessException {
		return repository.getEntityById(AppParam.class, id);
	}

	@Override
	public void updateAccount(AppParam app) throws DataAccessException {
		repository.update(app);
		
	}
}
