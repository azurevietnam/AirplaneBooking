package arilinebooking.core.ws.webbot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.TicketType;
import airlinebooking.core.ws.model.helper.TicketInforMH;
import airlinebooking.core.ws.model.helper.TicketInforRawMH;

public class ConverterVNAImpl extends Converter {

	@Override
	public List<TicketInforMH> makeTicketInfor(
			List<TicketInforRawMH> ticketInforRawMHList, String oriCode,
			String desCode, Date pickedDate, AirlineType airlineType) {
		List<TicketInforMH> ticketInforMHList = new ArrayList<TicketInforMH>();
		
		for (TicketInforRawMH ticketInforRawMH : ticketInforRawMHList) {
			TicketInforMH ticketInforMH = new TicketInforMH();
			Ticket ticket = new Ticket();
			List<TicketType> ticketTypeList = new ArrayList<TicketType>();
			
			ticket.setAirlineType(airlineType);
			ticket.setOriginCode(oriCode);
			ticket.setDestinationCode(desCode);
			ticket.setFromDate(pickedDate);
			ticket.setToDate(pickedDate);
			ticket.setFlightCode(ticketInforRawMH.getFlightCode());
			ticket.setFromTime(addTimeStringToDate(pickedDate, ticketInforRawMH.getFromTime(), "HH:mm"));
			ticket.setToTime(addTimeStringToDate(pickedDate, ticketInforRawMH.getToTime(), "HH:mm"));
			
			for(Entry<String, String> entry : ticketInforRawMH.getTicketPriceByType().entrySet()){
				TicketType ticketType = new TicketType();
				ticketType.setTicket(ticket);
				ticketType.setTicketTypeCode(entry.getKey());
				ticketType.setAmountString(entry.getValue());
				
				ticketTypeList.add(ticketType);
			}
			
			ticketInforMH.setTicket(ticket);
			ticketInforMH.setTicketTypeList(ticketTypeList);
			ticketInforMHList.add(ticketInforMH);
		}
		
		return ticketInforMHList;
	}

}
