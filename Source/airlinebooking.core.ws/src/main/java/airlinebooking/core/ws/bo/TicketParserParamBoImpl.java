package airlinebooking.core.ws.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlinebooking.common.bo.TicketParserParamBo;
import airlinebooking.common.enumtype.AirlineType;
import airlinebooking.common.exception.BusinessException;
import airlinebooking.common.exception.DataAccessException;
import airlinebooking.common.model.TicketParserParam;
import airlinebooking.core.ws.dao.TicketParserParamDao;
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
