package airlinebooking.core.ws.model.helper;

import java.util.ArrayList;
import java.util.List;

import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.TicketFlightDetail;
import airlinebooking.core.ws.model.TicketPriceDetail;

public class TicketInforMH {
	private Ticket ticket = new Ticket();
	private List<TicketPriceDetail> ticketPriceDetailList = new ArrayList<TicketPriceDetail>();
	private List<TicketFlightDetail> ticketFlightDetailList = new ArrayList<TicketFlightDetail>();
	
	public TicketInforMH(){
		
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public List<TicketPriceDetail> getTicketPriceDetailList() {
		return ticketPriceDetailList;
	}

	public void setTicketPriceDetailList(List<TicketPriceDetail> ticketPriceDetailList) {
		this.ticketPriceDetailList = ticketPriceDetailList;
	}

	public List<TicketFlightDetail> getTicketFlightDetailList() {
		return ticketFlightDetailList;
	}

	public void setTicketFlightDetailList(
			List<TicketFlightDetail> ticketFlightDetailList) {
		this.ticketFlightDetailList = ticketFlightDetailList;
	}
	
}
