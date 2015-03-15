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

import airlinebooking.core.ws.helper.DateHelper;
import arilinebooking.core.ws.webbot.WebBot;
import arilinebooking.core.ws.webbot.WebBotJetImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class WebBotJetTest {
	@Test
	public void getHTMLTestJet() throws Exception{
		WebBot vn = new WebBotJetImpl();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 29);
		Date pickedDate = cal.getTime();
		
		String htmlResult = vn.getHtmlResult("SGN", "HAN", pickedDate, 1, 0, 0);
		Document doc = Jsoup.parse(htmlResult);
		Elements elements = doc.select("div.fares > table.domestic tr:not(tr.starter-options.alt tr.business-options) > td:nth-child(2) > strong");
		for (Element element : elements){
			System.out.println(element.text());
		}
		System.out.println("Done");
	}
	
	@Test
	public void testDate()throws Exception
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 27);
		Date pickedDate = cal.getTime();
		
		String pickedDateFormat = DateHelper.convertDateToString(pickedDate, "dd");
		String pickedDateFormat2 = DateHelper.convertDateToString(pickedDate, "yyyy-MM");
		System.out.println(pickedDateFormat);
		System.out.println(pickedDateFormat2);
	}
	
	@Test
	public void getHTMLByFileJetstar() throws IOException{
		File input = new File("/Users/Dona/Desktop/jetstar.html");
		Document doc = Jsoup.parse(input, "UTF-8");
		Elements elements = doc.select("div.fares > table.domestic tr:not(tr.starter-options.alt tr.business-options):nth-child(10) div.flights > dl:nth-child(2n+1) > dd:nth-child(2)");
		for (Element element : elements){
			System.out.println(element.text());
		}
		System.out.println("Done");
	}
}
