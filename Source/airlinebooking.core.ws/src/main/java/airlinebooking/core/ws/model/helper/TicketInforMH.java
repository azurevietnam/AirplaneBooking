package airlinebooking.core.ws.model.helper;

import java.util.ArrayList;
import java.util.List;

import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.TicketType;

public class TicketInforMH {
	private Ticket ticket = new Ticket();
	private List<TicketType> ticketTypeList = new ArrayList<TicketType>();
	
	public TicketInforMH(){}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public List<TicketType> getTicketTypeList() {
		return ticketTypeList;
	}

	public void setTicketTypeList(List<TicketType> ticketTypeList) {
		this.ticketTypeList = ticketTypeList;
	}
}
