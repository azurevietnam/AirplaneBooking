package airlinebooking.core.ws.bo;

import org.springframework.beans.factory.annotation.Autowired;

import airlinebooking.core.ws.dao.AccountDao;
import airlinebooking.core.ws.model.Account;

public class AccountBoImpl implements AccountBo {

	@Autowired
	AccountDao accountDao;
	
	public Account findByUsername(String userName) {
		// TODO Auto-generated method stub
		return accountDao.findByUsername(userName);
	}

}
