package airlinebooking.core.ws.model.helper;

import java.util.ArrayList;
import java.util.List;

import airlinebooking.core.ws.model.TicketStorage;
import airlinebooking.core.ws.model.TicketType;


public class TicketInforMH {
	private List<TicketStorage> ticketStorageList;
	private List<TicketType> ticketTypeList;
	public TicketInforMH() {
		ticketStorageList = new ArrayList<TicketStorage>();
		ticketTypeList = new ArrayList<TicketType>();
	}
	public List<TicketStorage> getTicketStorageList() {
		return ticketStorageList;
	}
	public void setTicketStorageList(List<TicketStorage> ticketStorageList) {
		this.ticketStorageList = ticketStorageList;
	}
	public List<TicketType> getTicketTypeList() {
		return ticketTypeList;
	}
	public void setTicketTypeList(List<TicketType> ticketTypeList) {
		this.ticketTypeList = ticketTypeList;
	}
	
}
