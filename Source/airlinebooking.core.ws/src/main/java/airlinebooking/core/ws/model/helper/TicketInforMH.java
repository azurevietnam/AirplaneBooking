package airlinebooking.core.ws.model.helper;

import java.util.ArrayList;
import java.util.List;

import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.TicketPriceDetail;

public class TicketInforMH {
	private Ticket ticket = new Ticket();
	private List<TicketPriceDetail> ticketTypeList = new ArrayList<TicketPriceDetail>();
	
	public TicketInforMH(){}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public List<TicketPriceDetail> getTicketTypeList() {
		return ticketTypeList;
	}

	public void setTicketTypeList(List<TicketPriceDetail> ticketTypeList) {
		this.ticketTypeList = ticketTypeList;
	}
}
