package airlinebooking.core.ws.bo;

import airlinebooking.core.ws.exception.BusinessException;
import airlinebooking.core.ws.model.TicketStorage;

public interface TicketStorageBo {
	public TicketStorage getAccountById(int id) throws BusinessException;
	
	public void updateAccount(TicketStorage acc) throws BusinessException;
}
