package airlinebooking.core.ws.test;

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
import arilinebooking.core.ws.webbot.WebBotVietJetImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class WebBotTest {
	@Test
	public void testWebBotVietJet() throws Exception{
		WebBot vn = new WebBotVietJetImpl();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 30);
		Date pickedDate = cal.getTime();
		
		String htmlResult = vn.getHtmlResult("HAN", "SGN", pickedDate, 1, 0, 0);
		Document doc = Jsoup.parse(htmlResult);
		Elements elements = doc.select("div.fares > table.domestic tr:not(tr.starter-options.alt tr.business-options) > td:nth-child(2) > strong");
		for (Element element : elements){
			System.out.println(element.text());
		}
		System.out.println("Done");
	}
}
