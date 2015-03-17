package airlinebooking.common.bo;

import airlinebooking.common.exception.BusinessException;
import airlinebooking.common.model.Account;

public interface AccountBo {
	Account findByUsername(String userName);
	
	public Account getAccountById(int id) throws BusinessException;
	
	public void updateAccount(Account acc) throws BusinessException;
}
