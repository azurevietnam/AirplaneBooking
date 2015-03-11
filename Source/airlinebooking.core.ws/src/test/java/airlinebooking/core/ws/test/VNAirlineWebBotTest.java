package airlinebooking.core.ws.test;

import java.util.Calendar;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airlinebooking.core.ws.model.helper.HtmlResultMH;
import arilinebooking.core.ws.webbot.VNAirlineWebBot;
import arilinebooking.core.ws.webbot.WebBot;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class VNAirlineWebBotTest {
	@Test
	public void getHTMLByJSoup(){
		WebBot vn = new VNAirlineWebBot();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 25);
		Date pickedDate = cal.getTime();
		
		HtmlResultMH htmlResult = vn.getHTML("SGN", "DAD", pickedDate, 1, 0, 0);
		Document doc = Jsoup.parse(htmlResult.getHtmlResult());
		Elements content = doc.select("div.flight-list-section.flight-list > table > tbody > tr > td[fare-family-key=\"ES\"] span.prices-amount, div.flight-list-section.flight-list > table > tbody > tr > td[fare-family-key=\"ES\"] span.farefamily-cell-unavailable.translate.wasTranslated");
 
		System.out.println(content.text());
		System.out.println("Done");
	}
}
