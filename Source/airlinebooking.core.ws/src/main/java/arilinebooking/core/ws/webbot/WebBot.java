package arilinebooking.core.ws.webbot;

import java.util.Date;

import airlinebooking.core.ws.model.helper.HtmlResultMH;

/**
 * WebBot interface
 * @author ledona
 *
 */
public interface WebBot {
	
	/**
	 * Get html result from website
	 * @param oriCode origination's code
	 * @param desCode destination's code
	 * @param pickedDate picked date to flight
	 * @param adultNumber adult number
	 * @param childrenNumber children number
	 * @param infantNumber infant number
	 * @return HtmlResultMH object
	 */
	public HtmlResultMH getHTML(String oriCode, String desCode, Date pickedDate, int adultNumber, int childrenNumber, int infantNumber) throws Exception;
}
