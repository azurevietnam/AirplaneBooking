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
import airlinebooking.core.ws.model.helper.HtmlResultMH;
import airlinebooking.core.ws.model.helper.TicketInforMH;

public class CrawlerVNAImpl extends Crawler {

	@Override
	public List<TicketInforMH> getTicketInfor(HtmlResultMH htmlResultMH,
			List<TicketParserParam> parserPathList, String oriCode,
			String desCode, Date pickedDate, AirlineType airlineType) throws ParseException {

		List<TicketInforMH> ticketInforMHList = new ArrayList<TicketInforMH>();

		if (!htmlResultMH.getHtmlResult().isEmpty()) {
			HashMap<String, Object> objectHashMap = getHashMapListFromHtmlResult(htmlResultMH, parserPathList);
			
			if (!objectHashMap.isEmpty()) {
				final String flightCode = "flight_code";
				final String fromTime = "from_time";
				final String toTime = "to_time";
				final String breakpointNumber = "breakpoint_number";
				final String ticketPrice = "ticket_price";
				final String formatTime = "HH:mm";
				
				Elements flightCodeElements = (Elements) objectHashMap.get(flightCode);
				Elements fromTimeElements = (Elements) objectHashMap.get(fromTime);
				Elements toTimeElements = (Elements) objectHashMap.get(toTime);
				Elements breakpointElements = (Elements) objectHashMap.get(breakpointNumber);
				@SuppressWarnings("unchecked")
				HashMap<String, Elements> ticketPriceElements = (HashMap<String, Elements>) objectHashMap.get(ticketPrice);
				
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
					ticket.setFromTime(converToTime(pickedDate, fromTimeElements.get(index).text(), formatTime));
					ticket.setToTime(converToTime(pickedDate, toTimeElements.get(index).text(), formatTime));
					ticket.setDurationTime(getDurationTimeInMinute(ticket.getFromTime(), ticket.getToTime()));
					
					TicketFlightDetail ticketFlightDetail = new TicketFlightDetail();
					ticketFlightDetail.setFlightCode(flightCodeElements.get(index).text());
					ticketFlightDetail.setOriginationCode(ticket.getOriginationCode());
					ticketFlightDetail.setDestinationCode(ticket.getDestinationCode());
					ticketFlightDetail.setFromTime(ticket.getToTime());
					ticketFlightDetail.setToTime(ticket.getToTime());
					ticketFlightDetail.setDurationTime(ticket.getDurationTime());
					
					List<TicketFlightDetail> ticketFlightDetailList = new ArrayList<TicketFlightDetail>();
					ticketFlightDetailList.add(ticketFlightDetail);
					
					List<TicketPriceDetail> ticketPriceDetailList = new ArrayList<TicketPriceDetail>();
					for(Entry<String, Elements> ticketPriceElement : ticketPriceElements.entrySet()){
						TicketPriceDetail ticketPriceDetail = new TicketPriceDetail();
						Elements priceElements = ticketPriceElement.getValue();
						
						ticketPriceDetail.setTicketTypeCode(ticketPriceElement.getKey());
						ticketPriceDetail.setTicketPrice(convertToTicketPrice(priceElements.get(index).text(), "[0-9,]+"));
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

	// This code is tie to Jsoup technology TOO MUCH !
	private HashMap<String, Object> getHashMapListFromHtmlResult(
			HtmlResultMH htmlResultMH, List<TicketParserParam> parserPathList) {
		HashMap<String, Object> resultHashMap = new HashMap<String, Object>();
		Document doc = Jsoup.parse(htmlResultMH.getHtmlResult());

		for (TicketParserParam ticketParserParam : parserPathList) {
			Elements elements = doc.select(ticketParserParam.getSelectorPath());

			if (ticketParserParam.getTicketTypeCode() == "" || ticketParserParam.getTicketTypeCode() == null) {
				resultHashMap.put(ticketParserParam.getCodeType(), elements);
			} else {
				// Danh cho loai gia ve ticket_price
				if (!elements.isEmpty()) {
					if (resultHashMap.get(ticketParserParam.getCodeType()) != null) {
						@SuppressWarnings("unchecked")
						HashMap<String, Object> hashMapListOld = (HashMap<String, Object>) resultHashMap
								.get(ticketParserParam.getCodeType());
						hashMapListOld
								.put(ticketParserParam.getTicketTypeCode(),
										elements);
						resultHashMap.put(ticketParserParam.getCodeType(),
								hashMapListOld);
					} else {
						HashMap<String, Object> hashMapListNew = new HashMap<String, Object>();
						hashMapListNew
								.put(ticketParserParam.getTicketTypeCode(),
										elements);
						resultHashMap.put(ticketParserParam.getCodeType(),
								hashMapListNew);
					}
				}
			}
		}
		return resultHashMap;
	}
}
