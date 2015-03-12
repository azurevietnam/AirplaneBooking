package airlinebooking.core.ws.model.helper;

import java.util.ArrayList;
import java.util.List;

import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.TicketType;


public class TicketInforMH {
	private List<Ticket> ticketStorageList;
	private List<TicketType> ticketTypeList;
	public TicketInforMH() {
		ticketStorageList = new ArrayList<Ticket>();
		ticketTypeList = new ArrayList<TicketType>();
	}
	public List<Ticket> getTicketStorageList() {
		return ticketStorageList;
	}
	public void setTicketStorageList(List<Ticket> ticketStorageList) {
		this.ticketStorageList = ticketStorageList;
	}
	public List<TicketType> getTicketTypeList() {
		return ticketTypeList;
	}
	public void setTicketTypeList(List<TicketType> ticketTypeList) {
		this.ticketTypeList = ticketTypeList;
	}
	
}
