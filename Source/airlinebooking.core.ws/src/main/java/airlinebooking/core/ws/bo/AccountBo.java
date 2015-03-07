package airlinebooking.core.ws.bo;

import airlinebooking.core.ws.exception.BusinessException;
import airlinebooking.core.ws.model.Account;

public interface AccountBo {
	Account findByUsername(String userName);
	
	public Account getAccountById(int id) throws BusinessException;
	
	public void updateAccount(Account acc) throws BusinessException;
}
