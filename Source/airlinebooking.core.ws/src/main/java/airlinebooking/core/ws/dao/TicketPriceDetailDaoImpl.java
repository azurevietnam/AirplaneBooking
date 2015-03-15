package airlinebooking.core.ws.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.TicketPriceDetail;
import airlinebooking.core.ws.repo.QueryRepo;

@Repository
public class TicketPriceDetailDaoImpl implements TicketPriceDetailDao {
	@Autowired
	QueryRepo queryRepo;
	
	@Override
	public TicketPriceDetail createTicketPriceDetail(
			TicketPriceDetail ticketPriceDetail) throws DataAccessException {
		if (ticketPriceDetail == null) {
			throw new IllegalArgumentException("ticketPriceDetail");
		}
		queryRepo.create(ticketPriceDetail);
		
		return queryRepo.getEntityById(TicketPriceDetail.class, ticketPriceDetail.getId());
	}

}
