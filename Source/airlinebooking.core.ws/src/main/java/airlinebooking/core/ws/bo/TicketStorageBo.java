package airlinebooking.core.ws.bo;

import airlinebooking.core.ws.exception.BusinessException;
import airlinebooking.core.ws.model.Ticket;

public interface TicketStorageBo {
	public Ticket getAccountById(int id) throws BusinessException;
	
	public void updateAccount(Ticket acc) throws BusinessException;
}
