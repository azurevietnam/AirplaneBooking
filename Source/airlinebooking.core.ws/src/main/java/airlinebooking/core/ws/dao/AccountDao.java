package airlinebooking.core.ws.dao;

import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.Account;

public interface AccountDao {
	Account findByUsername(String userName);
	
	public Account getAccountById(int id) throws DataAccessException;
	
	public void updateAccount(Account acc) throws DataAccessException;
}
