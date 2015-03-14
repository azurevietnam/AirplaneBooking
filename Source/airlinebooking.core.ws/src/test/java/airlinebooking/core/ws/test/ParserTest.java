package airlinebooking.core.ws.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airlinebooking.core.ws.dao.TicketParserParamDao;
import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.TicketParserParam;
import airlinebooking.core.ws.model.helper.HtmlResultMH;
import airlinebooking.core.ws.model.helper.TicketInforMH;
import arilinebooking.core.ws.webbot.Crawler;
import arilinebooking.core.ws.webbot.CrawlerVNAImpl;
import arilinebooking.core.ws.webbot.Parser;
import arilinebooking.core.ws.webbot.ParserJsoupImpl;
import arilinebooking.core.ws.webbot.WebBotVNAImpl;
import arilinebooking.core.ws.webbot.WebBot;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class ParserTest {
	@Autowired
	TicketParserParamDao ticketParserParamDao;

	@Test
	public void test(){
		try {
			List<TicketParserParam> parserPathList = ticketParserParamDao.getParserPathByAirlineType(AirlineType.VNAIRLINE);
			
			WebBot webBotVNA = new WebBotVNAImpl();
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2015);
			cal.set(Calendar.MONTH, Calendar.MARCH);
			cal.set(Calendar.DAY_OF_MONTH, 20);
			Date pickedDate = cal.getTime();
			
			HtmlResultMH htmlResult = webBotVNA.getHTML("VII", "BMV", pickedDate, 1, 0, 0);
			
			Crawler crawlerVNA = new CrawlerVNAImpl();
			List<TicketInforMH> result = crawlerVNA.getTicketInfor(htmlResult, parserPathList, "VII", "BMV", pickedDate, AirlineType.VNAIRLINE);
			
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@SuppressWarnings("unused")
	public void testWithMock(){
		try {
			Parser parserJsoup = new ParserJsoupImpl();
			
			TicketParserParam tkPP1 = new TicketParserParam();
			TicketParserParam tkPP2 = new TicketParserParam();
			TicketParserParam tkPP3 = new TicketParserParam();
			TicketParserParam tkPP4 = new TicketParserParam();
			
			/* = Setup our mock object with the expected values */
			tkPP1.setAirlineType(AirlineType.VNAIRLINE);
			tkPP1.setCodeType("from");
			tkPP1.setSelectorPath("tr.yui-dt-even > td:nth-child(3) > span.translate.wasTranslated, tr.yui-dt-odd > td:nth-child(3) > span.translate.wasTranslated");
			tkPP1.setTicketTypeCode("");
			
			tkPP2.setAirlineType(AirlineType.VNAIRLINE);
			tkPP2.setCodeType("to");
			tkPP2.setSelectorPath("tr.yui-dt-even > td:nth-child(4) > span.translate.wasTranslated, tr.yui-dt-odd > td:nth-child(4) > span.translate.wasTranslated");
			tkPP2.setTicketTypeCode("");
			
			tkPP3.setAirlineType(AirlineType.VNAIRLINE);
			tkPP3.setCodeType("amount");
			tkPP3.setSelectorPath("div.flight-list-section.flight-list > table > tbody > tr > td[fare-family-key=\"BF\"] span.prices-amount, div.flight-list-section.flight-list > table > tbody > tr > td[fare-family-key=\"BF\"] span.farefamily-cell-unavailable.translate.wasTranslated");
			tkPP3.setTicketTypeCode("TTH");
			
			tkPP4.setAirlineType(AirlineType.VNAIRLINE);
			tkPP4.setCodeType("amount");
			tkPP4.setSelectorPath("div.flight-list-section.flight-list > table > tbody > tr > td[fare-family-key=\"BS\"] span.prices-amount, div.flight-list-section.flight-list > table > tbody > tr > td[fare-family-key=\"BS\"] span.farefamily-cell-unavailable.translate.wasTranslated");
			tkPP4.setTicketTypeCode("TTD");
			
		    List<TicketParserParam> parserPathList = new ArrayList<TicketParserParam>();
		    parserPathList.add(tkPP1);
		    parserPathList.add(tkPP2);
		    parserPathList.add(tkPP3);
		    parserPathList.add(tkPP4);
		    
			File input = new File("C:/Users/nald/Desktop/united.html");
			Document doc = Jsoup.parse(input, "UTF-8");
			HtmlResultMH htmlResult = new HtmlResultMH();
			htmlResult.setHtmlResult(doc.toString());
			htmlResult.setAirlineType(AirlineType.VNAIRLINE);
			
			HashMap<String, Object> result = parserJsoup.getObjectInfor(htmlResult, parserPathList);
			
			for(Entry<String, Object> entry : result.entrySet()){
				String key = entry.getKey();
				Object value = entry.getValue();
				System.out.println("");
			}
			
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
