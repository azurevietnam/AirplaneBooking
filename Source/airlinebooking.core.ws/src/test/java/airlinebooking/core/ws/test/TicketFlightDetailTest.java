package airlinebooking.core.ws.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airlinebooking.core.ws.dao.TicketDao;
import airlinebooking.core.ws.dao.TicketFlightDetailDao;
import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.TicketFlightDetail;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class TicketFlightDetailTest {
	@Autowired
	TicketFlightDetailDao ticketFlightDetailDao;
	
	@Autowired
	TicketDao ticketDao;
	@Test
	public void createEntity() throws DataAccessException{
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
		
//		Ticket ticket = new Ticket();
//		ticket.setAirlineType(AirlineType.JETSTAR);
//		ticket.setBreakpointNumber(0);
//		ticket.setDestinationCode("HAN");
//		ticket.setOriginationCode("SGN");
//		ticket.setFromTime(fromTime);
//		ticket.setToTime(toTime);
		
		Ticket ticket = ticketDao.getTicketById(2);
		
		TicketFlightDetail ticketFlightDetail = new TicketFlightDetail();
		ticketFlightDetail.setTicket(ticket);
		ticketFlightDetail.setDestinationCode("SGN");
		ticketFlightDetail.setDestinationCode("HNA");
		ticketFlightDetail.setFlightCode("Dona");
		ticketFlightDetailDao.createTicketFlightDetail(ticketFlightDetail);
		
		System.out.println(ticketFlightDetail.getId());
	}
}
