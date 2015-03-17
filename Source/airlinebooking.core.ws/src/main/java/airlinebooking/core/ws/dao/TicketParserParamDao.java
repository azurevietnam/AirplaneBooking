package airlinebooking.core.ws.dao;

import java.util.List;

import airlinebooking.common.enumtype.AirlineType;
import airlinebooking.common.exception.DataAccessException;
import airlinebooking.common.model.TicketParserParam;

public interface TicketParserParamDao {
	/**
	 * Get list parser path from ticket_parser_param table by AirlineType
	 * @param airlineType Type of airline
	 * @return List TicketParserParam object
	 * @throws DataAccessException 
	 */
	public List<TicketParserParam> getParserPathByAirlineType(AirlineType airlineType) throws DataAccessException;

	TicketParserParam getTicketParserParamById(int id) throws DataAccessException;
}
