package airlinebooking.core.ws.dao;


import airlinebooking.common.exception.DataAccessException;
import airlinebooking.common.model.AppParam;

public interface AppParamDao {
	public AppParam getAccountById(int id) throws DataAccessException;

	public void updateAccount(AppParam app) throws DataAccessException;
	
	
}
