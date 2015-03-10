package arilinebooking.core.ws.webbot;

import java.io.IOException;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import airlinebooking.core.ws.helper.DateHelper;

public class VNAirlineWebBot implements WebBot {

	int timeOut = 10*1000; //set timeout jsoup connection to get data is 10s
	String userAgent = "Mozilla";
	
	@Override
	public String getHTML(String oriCode, String desCode, Date pickedDate, int adultNumber, int childrenNumber, int infantNumber) {
		
		// Convert Date pickedDate to String format 'yyyy-MM-dd'
		String pickedDateFormat = DateHelper.convertDateToString(pickedDate, "yyyy-MM-dd");
		
		String url = "https://wl-prod.sabresonicweb.com/SSW2010/B3QE/webqtrip.html?searchType=NORMAL&journeySpan=OW"
				+ "&origin=" + oriCode
				+ "&destination=" + desCode
				+ "&departureDate=" + pickedDateFormat
				+ "&numAdults=" + adultNumber
				+ "&numChildren=" + childrenNumber
				+ "&numInfants=" + infantNumber
				+ "&alternativeLandingPage=true&promoCode=&lang=vi_VN";
		try
		{
			Document doc = Jsoup.connect(url)
					.userAgent(userAgent)
					.timeout(timeOut)
					.get();
			return doc.toString();
		}
		catch(IOException e){
			System.out.println(e.toString());
			return "";
		}
	}
}
