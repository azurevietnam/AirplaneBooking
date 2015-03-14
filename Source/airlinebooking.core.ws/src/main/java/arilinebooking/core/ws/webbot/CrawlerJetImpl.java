package arilinebooking.core.ws.webbot;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.jsoup.select.Elements;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.TicketParserParam;
import airlinebooking.core.ws.model.helper.HtmlResultMH;
import airlinebooking.core.ws.model.helper.TicketInforMH;

public class CrawlerJetImpl extends Crawler {

	@Override
	public List<TicketInforMH> getTicketInfor(HtmlResultMH htmlResultMH,
			List<TicketParserParam> parserPathList, String oriCode,
			String desCode, Date pickedDate, AirlineType airlineType)
			throws ParseException {
		List<TicketInforMH> ticketInforMHList = new ArrayList<TicketInforMH>();
		if (!htmlResultMH.getHtmlResult().isEmpty()) {
			HashMap<String, Object> objectHashMap = getHashMapListFromHtmlResult(htmlResultMH, parserPathList);
			
			if (!objectHashMap.isEmpty()) {
				Elements fromTimeElements = (Elements) objectHashMap.get(FROM_TIME);
				Elements toTimeElements = (Elements) objectHashMap.get(TO_TIME);
				
				int numberObject = 0;
				
				if (!fromTimeElements.isEmpty() && fromTimeElements != null)
					numberObject = fromTimeElements.size();
				
				for (int index = 0; index < numberObject; index++) {
					Ticket ticket = new Ticket();
					ticket.setAirlineType(airlineType);
					ticket.setPickedDate(pickedDate);
					ticket.setOriginationCode(oriCode);
					ticket.setDestinationCode(desCode);
					ticket.setDurationTime(getDurationTimeInMinute(ticket.getFromTime(), ticket.getToTime()));
					
				}
			}
		}
		
		return ticketInforMHList;
	}

}
