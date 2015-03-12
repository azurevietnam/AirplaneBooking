package arilinebooking.core.ws.webbot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.jsoup.select.Elements;

import airlinebooking.core.ws.model.helper.TicketInforRawMH;

public class TicketInforRawMakerImpl implements TicketInforRawMaker {

	@Override
	public List<TicketInforRawMH> convertParserToTicketInforMH(
			HashMap<String, Object> objectConvertHashMap) {

		List<TicketInforRawMH> ticketInforMHList = new ArrayList<TicketInforRawMH>();

		int numberObject = 0;

		if (!objectConvertHashMap.isEmpty()) {
			Elements flightCodeElements = (Elements) objectConvertHashMap
					.get("flight_code");
			Elements fromTimeElements = (Elements) objectConvertHashMap
					.get("from_time");
			Elements toTimeCodeElements = (Elements) objectConvertHashMap
					.get("to_time");
			@SuppressWarnings("unchecked")
			HashMap<String, Elements> amountElements = (HashMap<String, Elements>) objectConvertHashMap
					.get("amount");

			if (!flightCodeElements.isEmpty() && flightCodeElements != null)
				numberObject = flightCodeElements.size();

			for (int index = 0; index < numberObject; index++) {
				TicketInforRawMH ticketInforMH = new TicketInforRawMH();
				ticketInforMH.setFlightCode(flightCodeElements.get(index).text());
				ticketInforMH.setFromTime(fromTimeElements.get(index).text());
				ticketInforMH.setToTime(toTimeCodeElements.get(index).text());
				
				HashMap<String, String> ticketPrice = new HashMap<String, String>();
				for(Entry<String, Elements> entry : amountElements.entrySet()){
					Elements e = entry.getValue();
					ticketPrice.put(entry.getKey(), e.get(index).text());
				}
				ticketInforMH.setTicketPriceByType(ticketPrice);
				
				ticketInforMHList.add(ticketInforMH);
			}
		}
		return ticketInforMHList;
	}

}
