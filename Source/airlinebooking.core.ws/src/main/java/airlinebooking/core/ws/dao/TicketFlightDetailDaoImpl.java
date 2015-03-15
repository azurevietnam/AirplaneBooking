package airlinebooking.core.ws.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.TicketFlightDetail;
import airlinebooking.core.ws.repo.QueryRepo;

@Repository
public class TicketFlightDetailDaoImpl implements TicketFlightDetailDao {
	@Autowired
	QueryRepo queryRepo;
	
	@Override
	public TicketFlightDetail createTicketFlightDetail(
			TicketFlightDetail ticketFlightDetail) throws DataAccessException {
		if (ticketFlightDetail == null) {
			throw new IllegalArgumentException("ticketPriceDetail");
		}
		queryRepo.create(ticketFlightDetail);
		
		return queryRepo.getEntityById(TicketFlightDetail.class, ticketFlightDetail.getId());
	}

}
