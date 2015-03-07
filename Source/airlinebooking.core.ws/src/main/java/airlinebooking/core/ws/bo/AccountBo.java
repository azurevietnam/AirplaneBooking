package airlinebooking.core.ws.bo;

import airlinebooking.core.ws.model.Account;

public interface AccountBo {
	Account findByUsername(String userName);
}
