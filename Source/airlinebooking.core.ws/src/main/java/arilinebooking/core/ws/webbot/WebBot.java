package arilinebooking.core.ws.webbot;

import java.util.Date;

public interface WebBot {
	
	public String getHTML(String oriCode, String desCode, Date pickedDate, int adultNumber, int childrenNumber, int infantNumber);
}
