package arilinebooking.core.ws.webbot;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.TicketFlightDetail;
import airlinebooking.core.ws.model.TicketParserParam;
import airlinebooking.core.ws.model.TicketPriceDetail;
import airlinebooking.core.ws.model.helper.HtmlResultMH;
import airlinebooking.core.ws.model.helper.TicketInforMH;

public class CrawlerJetImpl extends Crawler {
	private static final String STOP_FLIGHT_ORI = "stop_flight_ori";
	private static final String STOP_FLIGHT_DES = "stop_flight_des";
	
	@Override
	public List<TicketInforMH> getTicketInfor(HtmlResultMH htmlResultMH, List<TicketParserParam> parserPathList, String oriCode,
			String desCode, Date pickedDate, AirlineType airlineType) throws ParseException {
		List<TicketInforMH> ticketInforMHList = new ArrayList<TicketInforMH>();
		
		if (!htmlResultMH.getHtmlResult().isEmpty()) {
			Document contentDocument = Jsoup.parse(htmlResultMH.getHtmlResult());
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
					ticket.setFromTime(converToTime(pickedDate, fromTimeElements.get(index).text(), formatTime));
					ticket.setToTime(converToTime(pickedDate, toTimeElements.get(index).text(), formatTime));
					ticket.setDurationTime(getDurationTimeInMinute(ticket.getFromTime(), ticket.getToTime()));
					
					// New instance TicketPriceDetail then add to List<TicketPriceDetail>
					TicketPriceDetail ticketPriceDetail = new TicketPriceDetail();
					ticketPriceDetail.setTicketPrice(convertToTicketPrice(ticketPriceElements.get(index).text().replaceAll("[a-zA-Z\\s]", ""), "[0-9,]+"));
					ticketPriceDetail.setTotal(ticketPriceDetail.getTicketPrice());
					List<TicketPriceDetail> ticketPriceDetailList = new ArrayList<TicketPriceDetail>();
					ticketPriceDetailList.add(ticketPriceDetail);
					
					// List<TicketFlightDetail>
					List<TicketFlightDetail> ticketFlightDetailList = new ArrayList<TicketFlightDetail>();
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
						
						ticketFlightDetailList.add(ticketFlightDetail);
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
							
							ticketFlightDetailList.add(ticketFlightDetail);
						}
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
