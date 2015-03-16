package airlinebooking.core.ws.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airlinebooking.core.ws.dao.TicketDao;
import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.TicketFlightDetail;
import airlinebooking.core.ws.model.TicketPriceDetail;
import airlinebooking.core.ws.model.helper.TicketInforMH;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class TicketTest {
	@Autowired
	TicketDao ticketDao;
	@Test
	public void saveListTicketInforMH() throws DataAccessException{
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
		
		TicketFlightDetail ticketFlightDetail = new TicketFlightDetail();
		ticketFlightDetail.setDestinationCode("SGN");
		ticketFlightDetail.setTicket(ticket);
		ticketFlightDetail.setDestinationCode("HNA");
		ticketFlightDetail.setFlightCode("Dona");
		
		TicketPriceDetail ticketPriceDetail = new TicketPriceDetail();
		ticketPriceDetail.setTicket(ticket);
		ticketPriceDetail.setTicketPrice(100000);
		
		List<TicketFlightDetail> ticketFlightDetails = new ArrayList<TicketFlightDetail>();
		List<TicketPriceDetail> ticketPriceDetails = new ArrayList<TicketPriceDetail>();
		ticketFlightDetails.add(ticketFlightDetail);
		ticketPriceDetails.add(ticketPriceDetail);
		
		ticket.setTicketFlightDetails(ticketFlightDetails);
		ticket.setTicketPriceDetails(ticketPriceDetails);
		
		TicketInforMH ticketInforMH = new TicketInforMH();
		ticketInforMH.setTicket(ticket);
		List<TicketInforMH> ticketInforMHList = new ArrayList<TicketInforMH>();
		ticketInforMHList.add(ticketInforMH);
		
		ticketDao.saveListTickets(ticketInforMHList);
		
		System.out.println(ticket.getId());
	}
	
	@Test
	public void createTicket() throws DataAccessException{
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
		
		TicketFlightDetail ticketFlightDetail = new TicketFlightDetail();
		ticketFlightDetail.setDestinationCode("SGN");
		ticketFlightDetail.setTicket(ticket);
		ticketFlightDetail.setDestinationCode("HNA");
		ticketFlightDetail.setFlightCode("Dona");
		
		TicketPriceDetail ticketPriceDetail = new TicketPriceDetail();
		ticketPriceDetail.setTicket(ticket);
		ticketPriceDetail.setTicketPrice(100000);
		
		List<TicketFlightDetail> ticketFlightDetails = new ArrayList<TicketFlightDetail>();
		List<TicketPriceDetail> ticketPriceDetails = new ArrayList<TicketPriceDetail>();
		ticketFlightDetails.add(ticketFlightDetail);
		ticketPriceDetails.add(ticketPriceDetail);
		
		ticket.setTicketFlightDetails(ticketFlightDetails);
		ticket.setTicketPriceDetails(ticketPriceDetails);
		
		ticketDao.createTicket(ticket);
		
		System.out.println(ticket.getId());
	}
	
	@Test
	public void deleteTicket() throws DataAccessException{
		Ticket ticket = ticketDao.getTicketById(22);
		ticketDao.deleteTicket(ticket);
		
		System.out.println(ticket.getId());
	}
}
