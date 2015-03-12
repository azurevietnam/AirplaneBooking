package arilinebooking.core.ws.webbot;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.helper.TicketInforMH;
import airlinebooking.core.ws.model.helper.TicketInforRawMH;

public abstract class Converter {
	public abstract List<TicketInforMH> makeTicketInfor(
			List<TicketInforRawMH> ticketInforRawMHList, String oriCode,
			String desCode, Date pickedDate, AirlineType airlineType) throws ParseException;
	
	public  Date addTimeStringToDate(Date inputDate, String time, String formatTime){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String inputDateStr = dateFormat.format(inputDate);
		
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
	
	public int convertAmountStringToAmount(String amountString, String pattern) throws ParseException {
		int result = -1;
		if(Pattern.matches(pattern, amountString)){
			NumberFormat format = NumberFormat.getInstance(Locale.US);
			Number number = 0;
			number = format.parse(amountString);
			result = number.intValue();
		}
		return result;
	}
}
