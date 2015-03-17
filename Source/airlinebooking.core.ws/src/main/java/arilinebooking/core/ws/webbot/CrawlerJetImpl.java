package arilinebooking.core.ws.webbot;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import airlinebooking.common.enumtype.AirlineType;
import airlinebooking.common.model.Ticket;
import airlinebooking.common.model.TicketFlightDetail;
import airlinebooking.common.model.TicketParserParam;
import airlinebooking.common.model.TicketPriceDetail;
import airlinebooking.common.model.helper.TicketInforMH;

public class CrawlerJetImpl extends Crawler {
	private static final String STOP_FLIGHT_ORI = "stop_flight_ori";
	private static final String STOP_FLIGHT_DES = "stop_flight_des";
	
	@Override
	public List<Ticket> getTicketInfor(String htmlResultString, List<TicketParserParam> parserPathList, String oriCode,
			String desCode, Date pickedDate, AirlineType airlineType) throws ParseException {
		List<Ticket> tickets = new ArrayList<Ticket>();
		
		if (!htmlResultString.isEmpty()) {
			Document contentDocument = Jsoup.parse(htmlResultString);
			HashMap<String, Object> objectHashMap = getHashMapListFromHtmlResult(contentDocument, parserPathList);
			
			if (!objectHashMap.isEmpty()) {
				final String formatTime = "HH:mm";
				
				Elements fromTimeElements = (Elements) objectHashMap.get(FROM_TIME);
				Elements toTimeElements = (Elements) objectHashMap.get(TO_TIME);
				Elements ticketPriceElements = (Elements) objectHashMap.get(TICKET_PRICE);
				
				int numberObject = 0;
				TicketParserParam flightCodeTicketParserParam = new TicketParserParam();
				TicketParserParam stopFlightOriTicketParserParam = new TicketParserParam();
				TicketParserParam stopFlightDesTicketParserParam = new TicketParserParam();
				for (TicketParserParam ticketParserParamElement : parserPathList) {
					String ticketCodeType = ticketParserParamElement.getCodeType();
					if (ticketCodeType.equals(FLIGHT_CODE)){
						flightCodeTicketParserParam = ticketParserParamElement;
					}
					if (ticketCodeType.equals(STOP_FLIGHT_ORI)){
						stopFlightOriTicketParserParam = ticketParserParamElement;
					}
					if (ticketCodeType.equals(STOP_FLIGHT_DES)){
						stopFlightDesTicketParserParam = ticketParserParamElement;
					}
				}
				
				if (!fromTimeElements.isEmpty() && fromTimeElements != null)
					numberObject = fromTimeElements.size();
				
				for (int index = 0; index < numberObject; index++) {
					// New instance Ticket
					Ticket ticket = new Ticket();
					ticket.setAirlineType(airlineType);
					ticket.setPickedDate(pickedDate);
					ticket.setOriginationCode(oriCode);
					ticket.setDestinationCode(desCode);
					ticket.setFromTime(convertToTime(pickedDate, fromTimeElements.get(index).text(), formatTime));
					ticket.setToTime(convertToTime(pickedDate, getTimeFormatHHmm(toTimeElements.get(index).text()), formatTime));
					ticket.setDurationTime(getDurationTimeInMinute(ticket.getFromTime(), ticket.getToTime()));
					
					// New instance TicketPriceDetail then add to List<TicketPriceDetail>
					TicketPriceDetail ticketPriceDetail = new TicketPriceDetail();
					ticketPriceDetail.setTicketPrice(convertToMoneyFormatUS(ticketPriceElements.get(index).text().replaceAll("[a-zA-Z\\s]", ""), "[0-9,]+"));
					ticketPriceDetail.setTotal(ticketPriceDetail.getTicketPrice());
					ticketPriceDetail.setTicket(ticket);
					List<TicketPriceDetail> ticketPriceDetails = new ArrayList<TicketPriceDetail>();
					ticketPriceDetails.add(ticketPriceDetail);
					
					// List<TicketFlightDetail>
					List<TicketFlightDetail> ticketFlightDetails = new ArrayList<TicketFlightDetail>();
					Elements flightCodeElements = getElementsFromParserPathParameter(contentDocument, flightCodeTicketParserParam, index + 1);
					ticket.setBreakpointNumber(flightCodeElements.size() - 1);
					if(ticket.getBreakpointNumber() <= 0){
						// Don't have breakpoint
						TicketFlightDetail ticketFlightDetail = new TicketFlightDetail();
						ticketFlightDetail.setDestinationCode(ticket.getDestinationCode());
						ticketFlightDetail.setOriginationCode(ticket.getOriginationCode());
						ticketFlightDetail.setDurationTime(ticket.getDurationTime());
						ticketFlightDetail.setFromTime(ticket.getFromTime());
						ticketFlightDetail.setToTime(ticket.getToTime());
						ticketFlightDetail.setFlightCode(flightCodeElements.first().text());
						ticketFlightDetail.setTicket(ticket);
						
						ticketFlightDetails.add(ticketFlightDetail);
					}
					else{
						// Have breakpoint
						for (Element flightCodeElement : flightCodeElements) {
							TicketFlightDetail ticketFlightDetail = new TicketFlightDetail();
							ticketFlightDetail.setDestinationCode(ticket.getDestinationCode());
							ticketFlightDetail.setOriginationCode(ticket.getOriginationCode());
							ticketFlightDetail.setDurationTime(ticket.getDurationTime());
							ticketFlightDetail.setFromTime(ticket.getFromTime());
							ticketFlightDetail.setToTime(ticket.getToTime());
							ticketFlightDetail.setFlightCode(flightCodeElement.text());
							ticketFlightDetail.setTicket(ticket);
							
							ticketFlightDetails.add(ticketFlightDetail);
						}
					}
					ticket.setTicketFlightDetails(ticketFlightDetails);
					ticket.setTicketPriceDetails(ticketPriceDetails);
					
					tickets.add(ticket);
					
				}
			}
		}
		
		return tickets;
	}
	
	private String getTimeFormatHHmm(String timeString){
		// Example: convert "0:40 (+1)" to "0:40"
		timeString = timeString.substring(0, timeString.indexOf(":") + 3);
		return timeString;
	}
}
