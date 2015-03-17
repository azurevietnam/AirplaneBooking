package airlinebooking.common.bo;

import java.util.List;

import airlinebooking.common.enumtype.AirlineType;
import airlinebooking.common.exception.BusinessException;
import airlinebooking.common.model.TicketParserParam;

public interface TicketParserParamBo {
	public List<TicketParserParam> getParserPathByAirlineType(AirlineType airlineType) throws BusinessException;
}
