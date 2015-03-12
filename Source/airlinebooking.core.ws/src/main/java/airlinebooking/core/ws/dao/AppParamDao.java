package airlinebooking.core.ws.dao;


import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.AppParam;

public interface AppParamDao {
	public AppParam getAccountById(int id) throws DataAccessException;

	public void updateAccount(AppParam app) throws DataAccessException;
	
	
}
