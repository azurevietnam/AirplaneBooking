package airlinebooking.core.ws.dao;

import airlinebooking.core.ws.model.Account;

public interface AccountDao {
	Account findByUsername(String userName);
}
