package airlinebooking.core.ws.bo;

import java.util.List;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.exception.BusinessException;
import airlinebooking.core.ws.model.TicketParserParam;

public interface TicketParserParamBo {
	public List<TicketParserParam> getParserPathByAirlineType(AirlineType airlineType) throws BusinessException;
}
