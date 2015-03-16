package airlinebooking.core.ws.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.repo.QueryRepo;

@Repository
public class TicketDaoImpl implements TicketDao {

	@Autowired
	QueryRepo queryRepo;
	
	@Autowired
	TicketFlightDetailDao ticketFlightDetailDao;
	
	@Autowired
	TicketPriceDetailDao ticketPriceDetailDao;
	
	@Override
	public Ticket createTicket(Ticket ticket){
		if (ticket == null) {
			throw new IllegalArgumentException("ticketType");
		}
		try {
			queryRepo.create(ticket);
			ticket = queryRepo.getEntityById(Ticket.class, ticket.getId());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return ticket;
	}
	
	@Override
	public Ticket getTicketById(int id) throws DataAccessException {
		return queryRepo.getEntityById(Ticket.class, id);
	}

	@Override
	public void saveListTickets(List<Ticket> tickets) throws DataAccessException {
		for (Ticket ticket : tickets) {
			createTicket(ticket);
		}
	}

	@Override
	public void deleteTicket(Ticket ticket) throws DataAccessException {
		if (ticket == null) {
			throw new IllegalArgumentException("ticket");
		}
		queryRepo.delete(ticket);
	}
}
