package airlinebooking.core.ws.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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
			
			Parser parserJsoup = new ParserJsoupImpl();
			WebBot webBotVNA = new WebBotVNAImpl();
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, 2015);
			cal.set(Calendar.MONTH, Calendar.MARCH);
			cal.set(Calendar.DAY_OF_MONTH, 25);
			Date pickedDate = cal.getTime();
			
			HtmlResultMH htmlResult = webBotVNA.getHTML("SGN", "DAD", pickedDate, 1, 0, 0);
			
			@SuppressWarnings("unused")
			HashMap<String, Object> result = parserJsoup.getObjectInfor(htmlResult, parserPathList);
			
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
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
			tkPP1.setSelectorPath("[Path_for_from]");
			tkPP1.setTicketTypeCode("");
			
			tkPP2.setAirlineType(AirlineType.VNAIRLINE);
			tkPP2.setCodeType("to");
			tkPP2.setSelectorPath("[Path_for_to]");
			tkPP2.setTicketTypeCode("");
			
			tkPP3.setAirlineType(AirlineType.VNAIRLINE);
			tkPP3.setCodeType("amount");
			tkPP3.setSelectorPath("[Path_for_amount_TTH]");
			tkPP3.setTicketTypeCode("TTH");
			
			tkPP4.setAirlineType(AirlineType.VNAIRLINE);
			tkPP4.setCodeType("amount");
			tkPP4.setSelectorPath("[Path_for_TTD]");
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
			
			@SuppressWarnings("unused")
			HashMap<String, Object> result = parserJsoup.getObjectInfor(htmlResult, parserPathList);
			
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
