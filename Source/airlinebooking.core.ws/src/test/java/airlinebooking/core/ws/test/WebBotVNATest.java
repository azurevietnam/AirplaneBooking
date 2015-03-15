package airlinebooking.core.ws.test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import arilinebooking.core.ws.webbot.WebBot;
import arilinebooking.core.ws.webbot.WebBotVNAImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class WebBotVNATest {
	@Test
	public void getHTMLByURL() throws Exception{
		WebBot vn = new WebBotVNAImpl();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 27);
		Date pickedDate = cal.getTime();
		
		String htmlResult = vn.getHtmlResult("SGN", "DAD", pickedDate, 1, 0, 0);
		Document doc = Jsoup.parse(htmlResult);
		Elements content = doc.select("tr.yui-dt-even > td:nth-child(5), tr.yui-dt-odd > td:nth-child(5)");
 
		System.out.println(content.text());
		System.out.println("Done");
	}
	
	@Test
	public void getHTMLByFile() throws IOException{
		File input = new File("C:/Users/nald/Desktop/united.html");
		Document doc = Jsoup.parse(input, "UTF-8");
		Elements elements = doc.select("div.flight-list-section.flight-list > table > tbody > tr > td[fare-family-key=\"ES\"] span.prices-amount, div.flight-list-section.flight-list > table > tbody > tr > td[fare-family-key=\"ES\"] span.farefamily-cell-unavailable.translate.wasTranslated");
		for (Element element : elements){
			System.out.println(element.text());
		}
		System.out.println("Done");
	}
	
	
}
