package arilinebooking.core.ws.webbot;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class VNAirlineWebBot implements WebBot {

	@Override
	public String getHTML() {
		try
		{
			Document doc = Jsoup.connect("http://vietnamairlines.com/")
					.userAgent("Mozilla")
					.timeout(20*1000)
					.get();
			System.out.println("");
		}
		catch(IOException e){
			
		}
		return null;
	}

}
