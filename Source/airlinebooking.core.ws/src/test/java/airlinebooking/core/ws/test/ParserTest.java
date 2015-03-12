package airlinebooking.core.ws.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airlinebooking.core.ws.dao.AppParamDao;
import airlinebooking.core.ws.dao.TicketParserParamDao;
import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.AppParam;
import airlinebooking.core.ws.model.TicketParserParam;
import airlinebooking.core.ws.model.helper.HtmlResultMH;
import arilinebooking.core.ws.webbot.Parser;
import arilinebooking.core.ws.webbot.ParserJsoupImpl;
import arilinebooking.core.ws.webbot.VNAirlineWebBot;
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
			WebBot webBotVNA = new VNAirlineWebBot();
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
}
