package airlinebooking.common.bo;

import airlinebooking.common.exception.BusinessException;
import airlinebooking.common.model.Ticket;

public interface TicketStorageBo {
	public Ticket getAccountById(int id) throws BusinessException;
	
	public void updateAccount(Ticket acc) throws BusinessException;
}
