package arilinebooking.core.ws.webbot;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.enumtype.YesNoType;
import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.TicketParserParam;

public abstract class Crawler {
	
	public static final String FLIGHT_CODE = "flight_code";
	public static final String FROM_TIME = "from_time";
	public static final String TO_TIME = "to_time";
	public static final String BREAKPOINT_NUMBER = "breakpoint_number";
	public static final String TICKET_PRICE = "ticket_price";
	
	public abstract List<Ticket> getTicketInfor(String htmlResultString, List<TicketParserParam> parserPathList,
			String oriCode, String desCode, Date pickedDate, AirlineType airlineType) throws ParseException;
	
	public  Date convertToTime(Date pickedDate, String time, String formatTime){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String inputDateStr = dateFormat.format(pickedDate);
		
		String outputDateStr = inputDateStr + " " + time;
		String formatString = "dd/MM/yyyy" + " " + formatTime;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
		
		try
        {
            Date date = simpleDateFormat.parse(outputDateStr);
            return date;
        }
        catch (ParseException ex)
        {
        	return null;
        }
	}
	
	public int convertToMoneyFormatUS(String ticketPriceStr, String pattern) throws ParseException {
		int result = -1;
		if(Pattern.matches(pattern, ticketPriceStr)){
			NumberFormat format = NumberFormat.getInstance(Locale.US);
			Number number = 0;
			number = format.parse(ticketPriceStr);
			result = number.intValue();
		}
		return result;
	}
	
	public int getDurationTimeInMinute(Date fromTime, Date toTime){
		return 0;
	}
	
	public int getBreakpointNumber(Elements elements, int index){
		int result = -1;
		if(Pattern.matches("[0-9,]+", elements.get(index).text())){
			result = Integer.parseInt(elements.get(index).text());
		}
		return result;
	}
	
	public HashMap<String, Object> getHashMapListFromHtmlResult(Document contentDocument, List<TicketParserParam> parserPathList) {
		HashMap<String, Object> resultHashMap = new HashMap<String, Object>();
		
		for (TicketParserParam ticketParserParam : parserPathList) {
			if (ticketParserParam.getHaveParameter() == YesNoType.NO){
				// Get paraserParam not have parameter
				Elements elements = contentDocument.select(ticketParserParam.getSelectorPath());

				if (ticketParserParam.getHaveMultiValue() == YesNoType.NO) {
					// HashMap<String, Elements>
					resultHashMap.put(ticketParserParam.getCodeType(), elements);
				} else {
					// HashMap<String, HashMap<String, Elements>>
					if (!elements.isEmpty()) {
						if (resultHashMap.get(ticketParserParam.getCodeType()) != null) {
							@SuppressWarnings("unchecked")
							HashMap<String, Object> hashMapListOld = (HashMap<String, Object>) resultHashMap.get(ticketParserParam.getCodeType());
							hashMapListOld.put(ticketParserParam.getTicketTypeCode(),elements);
							resultHashMap.put(ticketParserParam.getCodeType(),hashMapListOld);
						} else {
							HashMap<String, Object> hashMapListNew = new HashMap<String, Object>();
							hashMapListNew.put(ticketParserParam.getTicketTypeCode(), elements);
							resultHashMap.put(ticketParserParam.getCodeType(), hashMapListNew);
						}
					}
				}
			}
		}
		return resultHashMap;
	}
	
	public Elements getElementsFromParserPathParameter(Document contentDocument, TicketParserParam parserPathWitParameter, Integer index){
		Elements resultElements = new Elements();
		
		String newParserPath = parserPathWitParameter.getSelectorPath().replaceAll("\\?", index.toString());
		resultElements = contentDocument.select(newParserPath);
		
		return resultElements;
	}
}
