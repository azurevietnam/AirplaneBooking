package airlinebooking.core.ws.model.helper;

import java.util.HashSet;
import java.util.Set;

import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.TicketFlightDetail;
import airlinebooking.core.ws.model.TicketPriceDetail;

public class TicketInforMH {
	private Ticket ticket = new Ticket();
	private Set<TicketPriceDetail> ticketPriceDetailList = new HashSet<TicketPriceDetail>();
	private Set<TicketFlightDetail> ticketFlightDetailList = new HashSet<TicketFlightDetail>();
	
	public TicketInforMH(){
		
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Set<TicketPriceDetail> getTicketPriceDetailList() {
		return ticketPriceDetailList;
	}

	public void setTicketPriceDetailList(Set<TicketPriceDetail> ticketPriceDetailList) {
		this.ticketPriceDetailList = ticketPriceDetailList;
	}

	public Set<TicketFlightDetail> getTicketFlightDetailList() {
		return ticketFlightDetailList;
	}

	public void setTicketFlightDetailList(
			Set<TicketFlightDetail> ticketFlightDetailList) {
		this.ticketFlightDetailList = ticketFlightDetailList;
	}
	
}
