package arilinebooking.core.ws.webbot;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.TicketFlightDetail;
import airlinebooking.core.ws.model.TicketParserParam;
import airlinebooking.core.ws.model.TicketPriceDetail;
import airlinebooking.core.ws.model.helper.TicketInforMH;

public class CrawlerVNAImpl extends Crawler {

	@Override
	public List<TicketInforMH> getTicketInfor(String htmlResultString, List<TicketParserParam> parserPathList, String oriCode,
			String desCode, Date pickedDate, AirlineType airlineType) throws ParseException {

		List<TicketInforMH> ticketInforMHList = new ArrayList<TicketInforMH>();

		if (!htmlResultString.isEmpty()) {
			Document contentDocument = Jsoup.parse(htmlResultString);
			HashMap<String, Object> objectHashMap = getHashMapListFromHtmlResult(contentDocument, parserPathList);
			
			if (!objectHashMap.isEmpty()) {
				
				final String formatTime = "HH:mm";
				final String partternTicketPrice = "[0-9,]+";
				
				Elements flightCodeElements = (Elements) objectHashMap.get(FLIGHT_CODE);
				Elements fromTimeElements = (Elements) objectHashMap.get(FROM_TIME);
				Elements toTimeElements = (Elements) objectHashMap.get(TO_TIME);
				Elements breakpointElements = (Elements) objectHashMap.get(BREAKPOINT_NUMBER);
				@SuppressWarnings("unchecked")
				HashMap<String, Elements> ticketPriceElements = (HashMap<String, Elements>) objectHashMap.get(TICKET_PRICE);
				
				int numberObject = 0;
				
				if (!flightCodeElements.isEmpty() && flightCodeElements != null)
					numberObject = flightCodeElements.size();
				
				for (int index = 0; index < numberObject; index++) {
					Ticket ticket = new Ticket();
					ticket.setAirlineType(airlineType);
					ticket.setPickedDate(pickedDate);
					ticket.setOriginationCode(oriCode);
					ticket.setDestinationCode(desCode);
					ticket.setBreakpointNumber(getBreakpointNumber(breakpointElements, index));
					ticket.setFromTime(convertToTime(pickedDate, fromTimeElements.get(index).text(), formatTime));
					ticket.setToTime(convertToTime(pickedDate, toTimeElements.get(index).text(), formatTime));
					ticket.setDurationTime(getDurationTimeInMinute(ticket.getFromTime(), ticket.getToTime()));
					
					TicketFlightDetail ticketFlightDetail = new TicketFlightDetail();
					ticketFlightDetail.setFlightCode(flightCodeElements.get(index).text());
					ticketFlightDetail.setOriginationCode(ticket.getOriginationCode());
					ticketFlightDetail.setDestinationCode(ticket.getDestinationCode());
					ticketFlightDetail.setFromTime(ticket.getToTime());
					ticketFlightDetail.setToTime(ticket.getToTime());
					ticketFlightDetail.setDurationTime(ticket.getDurationTime());
					
					Set<TicketFlightDetail> ticketFlightDetailList = new HashSet<TicketFlightDetail>();
					ticketFlightDetailList.add(ticketFlightDetail);
					
					Set<TicketPriceDetail> ticketPriceDetailList = new HashSet<TicketPriceDetail>();
					for(Entry<String, Elements> ticketPriceElement : ticketPriceElements.entrySet()){
						TicketPriceDetail ticketPriceDetail = new TicketPriceDetail();
						Elements priceElements = ticketPriceElement.getValue();
						
						ticketPriceDetail.setTicketTypeCode(ticketPriceElement.getKey());
						ticketPriceDetail.setTicketPrice(convertToTicketPrice(priceElements.get(index).text(), partternTicketPrice));
						ticketPriceDetail.setTotal(ticketPriceDetail.getTicketPrice());
						ticketPriceDetailList.add(ticketPriceDetail);
					}
					
					TicketInforMH ticketInforMH = new TicketInforMH();
					ticketInforMH.setTicket(ticket);
					ticketInforMH.setTicketPriceDetailList(ticketPriceDetailList);
					ticketInforMH.setTicketFlightDetailList(ticketFlightDetailList);
					
					ticketInforMHList.add(ticketInforMH);
				}
			}
		}

		return ticketInforMHList;
	}

}
