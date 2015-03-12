package airlinebooking.core.ws.dao;

import java.util.List;

import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.helper.TicketInforRawMH;

public interface TicketDao {
	public Ticket createTicketType(Ticket ticket);
	
	public void saveListTicketInforMH(List<TicketInforRawMH> ticketInforMHList);
	
}
