package arilinebooking.core.ws.webbot;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.helper.TicketInforMH;
import airlinebooking.core.ws.model.helper.TicketInforRawMH;

public abstract class Converter {
	public abstract List<TicketInforMH> makeTicketInfor(
			List<TicketInforRawMH> ticketInforRawMHList, String oriCode,
			String desCode, Date pickedDate, AirlineType airlineType);
	
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
}
