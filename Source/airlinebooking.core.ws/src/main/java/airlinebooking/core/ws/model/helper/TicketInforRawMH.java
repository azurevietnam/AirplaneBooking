package airlinebooking.core.ws.model.helper;

import java.util.HashMap;

public class TicketInforRawMH {
	private String flightCode;
	private String fromTime;
	private String toTime;
	private HashMap<String, String> ticketPriceByType = new HashMap<String, String>();
	
	public TicketInforRawMH(){}
	
	public String getFlightCode() {
		return flightCode;
	}
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	public HashMap<String, String> getTicketPriceByType() {
		return ticketPriceByType;
	}
	public void setTicketPriceByType(HashMap<String, String> ticketPriceByType) {
		this.ticketPriceByType = ticketPriceByType;
	}
	
}
