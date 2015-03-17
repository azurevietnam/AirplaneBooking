package airlinebooking.core.ws.dao;

import airlinebooking.common.exception.DataAccessException;
import airlinebooking.common.model.Account;

public interface AccountDao {
	Account findByUsername(String userName);
	
	public Account getAccountById(int id) throws DataAccessException;
	
	public void updateAccount(Account acc) throws DataAccessException;
}
