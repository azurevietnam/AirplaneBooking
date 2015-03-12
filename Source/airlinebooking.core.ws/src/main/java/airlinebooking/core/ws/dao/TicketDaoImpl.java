package airlinebooking.core.ws.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.Ticket;
import airlinebooking.core.ws.model.helper.TicketInforRawMH;
import airlinebooking.core.ws.repo.QueryRepo;

@Repository
public class TicketDaoImpl implements TicketDao {

	@Autowired
	QueryRepo queryRepo;
	
	@Override
	public Ticket createTicketType(Ticket ticket){
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
	public void saveListTicketInforMH(List<TicketInforRawMH> ticketInforMHList) {
		// TODO Auto-generated method stub
	}
}
