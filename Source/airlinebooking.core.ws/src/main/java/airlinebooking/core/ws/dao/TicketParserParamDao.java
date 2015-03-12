package airlinebooking.core.ws.dao;

import java.util.List;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.TicketParserParam;

public interface TicketParserParamDao {
	/**
	 * Get list parser path from ticket_parser_param table by AirlineType
	 * @param airlineType Type of airline
	 * @return List TicketParserParam object
	 * @throws DataAccessException 
	 */
	public List<TicketParserParam> getParserPathByAirlineType(AirlineType airlineType) throws DataAccessException;

	TicketParserParam getTicketParserParamById(int id)
			throws DataAccessException;
}
