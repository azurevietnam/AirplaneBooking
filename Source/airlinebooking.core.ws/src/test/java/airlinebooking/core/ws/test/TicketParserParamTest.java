package airlinebooking.core.ws.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airlinebooking.core.ws.dao.TicketParserParamDao;
import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.TicketParserParam;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class TicketParserParamTest {

	@Autowired
	TicketParserParamDao ticketParserParamDao;
	
	@Test
	public void getListByHQL(){
		try {
			@SuppressWarnings("unused")
			List<TicketParserParam> result = ticketParserParamDao.getParserPathByAirlineType(AirlineType.VNAIRLINE);
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getEntityById(){
		try {
			@SuppressWarnings("unused")
			TicketParserParam entity = ticketParserParamDao.getTicketParserParamById(1);
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
