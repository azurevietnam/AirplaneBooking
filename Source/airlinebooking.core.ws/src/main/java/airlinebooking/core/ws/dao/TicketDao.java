package airlinebooking.core.ws.dao;

import java.util.List;

import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.helper.TicketInforMH;

public interface TicketDao {
	public Ticket createTicket(Ticket ticket);
	
	public Ticket getTicketById(int id) throws DataAccessException;
	
	public void saveListTicketInforMH(List<TicketInforMH> ticketInforMHList) throws DataAccessException;
}
