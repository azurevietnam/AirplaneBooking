package airlinebooking.core.ws.dao;

import airlinebooking.common.exception.DataAccessException;
import airlinebooking.common.model.TicketFlightDetail;


public interface TicketFlightDetailDao {
	public TicketFlightDetail createTicketFlightDetail(TicketFlightDetail ticketFlightDetail) throws DataAccessException;
}
