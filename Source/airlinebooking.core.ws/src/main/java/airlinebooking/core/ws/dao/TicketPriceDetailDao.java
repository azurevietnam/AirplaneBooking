package airlinebooking.core.ws.dao;

import airlinebooking.common.exception.DataAccessException;
import airlinebooking.common.model.TicketPriceDetail;

public interface TicketPriceDetailDao {
	public TicketPriceDetail createTicketPriceDetail (TicketPriceDetail ticketPriceDetail) throws DataAccessException;
}
