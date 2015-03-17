package arilinebooking.core.ws.webbot;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import airlinebooking.common.enumtype.AirlineType;
import airlinebooking.common.model.Ticket;
import airlinebooking.common.model.TicketFlightDetail;
import airlinebooking.common.model.TicketParserParam;
import airlinebooking.common.model.TicketPriceDetail;

public class CrawlerVNAImpl extends Crawler {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTicketInfor(String htmlResultString, List<TicketParserParam> parserPathList, String oriCode,
			String desCode, Date pickedDate, AirlineType airlineType) throws ParseException {

		List<Ticket> tickets = new ArrayList<Ticket>();

		if (!htmlResultString.isEmpty()) {
			Document contentDocument = Jsoup.parse(htmlResultString);
			HashMap<String, Object> objectHashMap = getHashMapListFromHtmlResult(contentDocument, parserPathList);
			
			if (!objectHashMap.isEmpty()) {
				
				final String formatTime = "HH:mm";
				final String partternTicketPrice = "[0-9,]+";
				
//				Elements flightCodeElements = (Elements) objectHashMap.get(FLIGHT_CODE);
				Elements fromTimeElements = new Elements();
				Elements toTimeElements = new Elements();
				Elements breakpointElements = new Elements();
				
				if (objectHashMap.get(FROM_TIME) != null)
					fromTimeElements = (Elements) objectHashMap.get(FROM_TIME);
				if (objectHashMap.get(TO_TIME) != null)
					toTimeElements = (Elements) objectHashMap.get(TO_TIME);
				if (objectHashMap.get(BREAKPOINT_NUMBER) != null)
					breakpointElements = (Elements) objectHashMap.get(BREAKPOINT_NUMBER);
				
				HashMap<String, Elements> ticketPriceElements = new HashMap<String, Elements>();
				if (objectHashMap.get(TICKET_PRICE) != null){
					ticketPriceElements = (HashMap<String, Elements>) objectHashMap.get(TICKET_PRICE);
				}
				
				int numberObject = 0;
				TicketParserParam flightCodeTicketParserParam = new TicketParserParam();
				for (TicketParserParam ticketParserParamElement : parserPathList) {
					String ticketCodeType = ticketParserParamElement.getCodeType();
					if (ticketCodeType.equals(FLIGHT_CODE)){
						flightCodeTicketParserParam = ticketParserParamElement;
						break;
					}
				}
				
				if (!fromTimeElements.isEmpty() && fromTimeElements != null)
					numberObject = fromTimeElements.size();
				
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
					
					// List<TicketFlightDetail>
					List<TicketFlightDetail> ticketFlightDetails = new ArrayList<TicketFlightDetail>();
					Elements flightCodeElements = getElementsFromParserPathParameter(contentDocument, flightCodeTicketParserParam, index + 1);
//					ticket.setBreakpointNumber(flightCodeElements.size() - 1);
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
	
	private int getBreakpointNumber(Elements elements, int index){
		int result = -1;
		String breakPointString = elements.get(index).text().replaceAll("[a-zA-Z\\s,()]", "");
		result = Integer.parseInt(breakPointString);
		return result;
	}

}
