package airlinebooking.core.ws.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
	public static String convertDateToString(Date pickedDate, String formatType) {
		DateFormat df = new SimpleDateFormat(formatType);
		String result = df.format(pickedDate);
		return result;
	}
}
