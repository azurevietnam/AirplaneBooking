package airlinebooking.core.ws.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlinebooking.core.ws.dao.TicketParserParamDao;
import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.exception.BusinessException;
import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.TicketParserParam;
@Service
public class TicketParserParamBoImpl implements TicketParserParamBo {
	@Autowired
	TicketParserParamDao ticketParserParamDao;
	
	@Override
	public List<TicketParserParam> getParserPathByAirlineType(
			AirlineType airlineType) throws BusinessException {
		try {
			return ticketParserParamDao.getParserPathByAirlineType(airlineType);
		} catch (DataAccessException e) {
			throw new BusinessException(e);
		}
	}

}
