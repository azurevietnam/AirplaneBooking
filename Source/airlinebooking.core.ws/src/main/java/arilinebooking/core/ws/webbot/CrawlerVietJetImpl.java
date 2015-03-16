package arilinebooking.core.ws.webbot;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.TicketFlightDetail;
import airlinebooking.core.ws.model.TicketParserParam;
import airlinebooking.core.ws.model.TicketPriceDetail;

public class CrawlerVietJetImpl extends Crawler {

	@Override
	public List<Ticket> getTicketInfor(String htmlResultString, List<TicketParserParam> parserPathList, String oriCode,
			String desCode, Date pickedDate, AirlineType airlineType) throws ParseException {
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		if (!htmlResultString.isEmpty()) {
			Document contentDocument = Jsoup.parse(htmlResultString);
			HashMap<String, Object> objectHashMap = getHashMapListFromHtmlResult(contentDocument, parserPathList);
			
			if (!objectHashMap.isEmpty()) {
				
				final String formatTime = "HH:mm";
				final Integer breakPointNumberDefault = 0;
				final String patternTime = "[a-zA-Z\\s]";
				final String partternTicketPrice = "[0-9,]+";
				
				Elements flightCodeElements = (Elements) objectHashMap.get(FLIGHT_CODE);
				Elements fromTimeElements = (Elements) objectHashMap.get(FROM_TIME);
				Elements toTimeElements = (Elements) objectHashMap.get(TO_TIME);
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
					ticket.setBreakpointNumber(breakPointNumberDefault);
					ticket.setFromTime(convertToTime(pickedDate, fromTimeElements.get(index).text().replaceAll(patternTime, ""), formatTime));
					ticket.setToTime(convertToTime(pickedDate, toTimeElements.get(index).text().replaceAll(patternTime, ""), formatTime));
					ticket.setDurationTime(getDurationTimeInMinute(ticket.getFromTime(), ticket.getToTime()));
					
					TicketFlightDetail ticketFlightDetail = new TicketFlightDetail();
					ticketFlightDetail.setFlightCode(flightCodeElements.get(index).text());
					ticketFlightDetail.setOriginationCode(ticket.getOriginationCode());
					ticketFlightDetail.setDestinationCode(ticket.getDestinationCode());
					ticketFlightDetail.setFromTime(ticket.getToTime());
					ticketFlightDetail.setToTime(ticket.getToTime());
					ticketFlightDetail.setDurationTime(ticket.getDurationTime());
					
					List<TicketFlightDetail> ticketFlightDetails = new ArrayList<TicketFlightDetail>();
					ticketFlightDetails.add(ticketFlightDetail);
					
					List<TicketPriceDetail> ticketPriceDetails = new ArrayList<TicketPriceDetail>();
					for(Entry<String, Elements> ticketPriceElement : ticketPriceElements.entrySet()){
						TicketPriceDetail ticketPriceDetail = new TicketPriceDetail();
						Elements priceElements = ticketPriceElement.getValue();
						
						ticketPriceDetail.setTicketTypeCode(ticketPriceElement.getKey());
						ticketPriceDetail.setTicketPrice(convertToMoneyFormatUS(priceElements.get(index).text(), partternTicketPrice));
						ticketPriceDetail.setTotal(ticketPriceDetail.getTicketPrice());
						ticketPriceDetails.add(ticketPriceDetail);
					}
					ticket.setTicketFlightDetails(ticketFlightDetails);
					ticket.setTicketPriceDetails(ticketPriceDetails);
					
					tickets.add(ticket);
					
				}
			}
		}
		
		return tickets;
	}

}
