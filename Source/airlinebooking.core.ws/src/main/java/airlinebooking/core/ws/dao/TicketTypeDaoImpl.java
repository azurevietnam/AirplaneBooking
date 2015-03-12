package airlinebooking.core.ws.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airlinebooking.core.ws.model.TicketType;
import airlinebooking.core.ws.repo.QueryRepo;
import airlinebooking.core.ws.exception.DataAccessException;

@Repository
public class TicketTypeDaoImpl implements TicketTypeDao {
	@Autowired
	QueryRepo queryRepo;
	
	@Override
	public TicketType createTicketType(TicketType ticketType){
		if (ticketType == null) {
			throw new IllegalArgumentException("ticketType");
		}
		try {
			queryRepo.create(ticketType);
			ticketType = queryRepo.getEntityById(TicketType.class, ticketType.getId());
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return ticketType;
	}
}
