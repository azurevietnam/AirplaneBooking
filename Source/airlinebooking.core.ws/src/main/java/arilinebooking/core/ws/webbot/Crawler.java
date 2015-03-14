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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.TicketParserParam;
import airlinebooking.core.ws.model.helper.HtmlResultMH;
import airlinebooking.core.ws.model.helper.TicketInforMH;

public abstract class Crawler {
	
	public static final String FLIGHT_CODE = "flight_code";
	public static final String FROM_TIME = "from_time";
	public static final String TO_TIME = "to_time";
	public static final String BREAKPOINT_NUMBER = "breakpoint_number";
	public static final String TICKET_PRICE = "ticket_price";
	
	public abstract List<TicketInforMH> getTicketInfor(
			HtmlResultMH htmlResultMH, List<TicketParserParam> parserPathList,
			String oriCode, String desCode, Date pickedDate,
			AirlineType airlineType) throws ParseException;
	
	public Elements getElementsAtIndex(Document document, String parserPath, Integer index){
		Elements resultElements;
		String charBeReplaced = "?";
		
		parserPath = parserPath.replaceAll(charBeReplaced, index.toString());
		
		resultElements = document.select(parserPath);
		
		return resultElements;
	}
	
	public  Date converToTime(Date pickedDate, String time, String formatTime){
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
	
	public int convertToTicketPrice(String ticketPriceStr, String pattern) throws ParseException {
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
	
	// This code is tie to Jsoup technology TOO MUCH !
	public HashMap<String, Object> getHashMapListFromHtmlResult(
			HtmlResultMH htmlResultMH, List<TicketParserParam> parserPathList) {
		HashMap<String, Object> resultHashMap = new HashMap<String, Object>();
		Document doc = Jsoup.parse(htmlResultMH.getHtmlResult());
		
		for (TicketParserParam ticketParserParam : parserPathList) {
			if (ticketParserParam.getHaveParameter() == 0){
				Elements elements = doc.select(ticketParserParam.getSelectorPath());

				if (ticketParserParam.getTicketTypeCode() == "" || ticketParserParam.getTicketTypeCode() == null) {
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
}
