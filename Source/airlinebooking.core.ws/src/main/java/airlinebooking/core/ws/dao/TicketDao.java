package airlinebooking.core.ws.dao;

import java.util.List;

import airlinebooking.common.exception.DataAccessException;
import airlinebooking.common.model.Ticket;

public interface TicketDao {
	public Ticket createTicket(Ticket ticket);
	
	public Ticket getTicketById(int id) throws DataAccessException;
	
	public void saveListTickets(List<Ticket> tickets) throws DataAccessException;
	
	public void deleteTicket(Ticket ticket) throws DataAccessException;
}
