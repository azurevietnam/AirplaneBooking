package arilinebooking.core.ws.webbot;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.TicketParserParam;
import airlinebooking.core.ws.model.helper.HtmlResultMH;
import airlinebooking.core.ws.model.helper.TicketInforMH;

public abstract class Crawler {

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
}
