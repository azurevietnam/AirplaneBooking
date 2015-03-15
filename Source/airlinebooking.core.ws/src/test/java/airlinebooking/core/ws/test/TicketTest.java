package airlinebooking.core.ws.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airlinebooking.core.ws.dao.TicketDao;
import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class TicketTest {
	@Autowired
	TicketDao ticketDao;
	@Test
	public void createEntity(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 29);
		Date fromTime = cal.getTime();
		
		Calendar cal2 = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 29);
		Date toTime = cal2.getTime();
		
		Ticket ticket = new Ticket();
		ticket.setAirlineType(AirlineType.VNAIRLINE);
		ticket.setBreakpointNumber(0);
		ticket.setDestinationCode("HAN");
		ticket.setOriginationCode("SGN");
		ticket.setFromTime(fromTime);
		ticket.setToTime(toTime);
		ticketDao.createTicket(ticket);
		
		System.out.println(ticket.getId());
	}
}
