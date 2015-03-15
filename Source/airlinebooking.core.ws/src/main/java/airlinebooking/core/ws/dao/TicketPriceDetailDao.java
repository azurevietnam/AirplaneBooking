package airlinebooking.core.ws.dao;

import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.TicketPriceDetail;

public interface TicketPriceDetailDao {
	public TicketPriceDetail createTicketPriceDetail (TicketPriceDetail ticketPriceDetail) throws DataAccessException;
}
