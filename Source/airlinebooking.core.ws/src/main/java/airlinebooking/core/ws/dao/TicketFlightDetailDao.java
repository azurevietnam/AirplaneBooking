package airlinebooking.core.ws.dao;

import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.TicketFlightDetail;


public interface TicketFlightDetailDao {
	public TicketFlightDetail createTicketFlightDetail(TicketFlightDetail ticketFlightDetail) throws DataAccessException;
}
