package airlinebooking.core.ws.model.helper;

import airlinebooking.core.ws.enumtype.AirlineType;

/**
 * Represent for HtmlResult include 
 * String htmlResult contents final html page to parse
 * and AirlineType
 * @author ledona
 *
 */
public class HtmlResultMH {
	/** Content final html page to parse */
	private String htmlResult;
	/** Airline type */
	private AirlineType airlineType;
	
	/**
	 * Default constructor
	 * set htmlResult is ""
	 */
	public HtmlResultMH(){
		htmlResult = "";
	}
	
	/**
	 * Get htmlResult
	 * @return htmlResult String
	 */
	public String getHtmlResult() {
		return htmlResult;
	}
	
	/**
	 * Set htmlResult
	 * @param htmlResult String htmlResult
	 */
	public void setHtmlResult(String htmlResult) {
		this.htmlResult = htmlResult;
	}
	
	/**
	 * Get airline type
	 * @return AirlineType type
	 */
	public AirlineType getAirlineType() {
		return airlineType;
	}
	
	/**
	 * Set airline type
	 * @param airlineType
	 */
	public void setAirlineType(AirlineType airlineType) {
		this.airlineType = airlineType;
	}
}
