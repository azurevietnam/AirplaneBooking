package airlinebooking.core.ws.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.TicketParserParam;
import airlinebooking.core.ws.repo.QueryRepo;

@Repository
public class TicketParserParamDaoImpl implements TicketParserParamDao {
	@Autowired
	QueryRepo repository;
	
	@Override
	public TicketParserParam getTicketParserParamById(int id) throws DataAccessException {
		return repository.getEntityById(TicketParserParam.class, id);
	}
	@Override
	public List<TicketParserParam> getParserPathByAirlineType(
			AirlineType airlineType) throws DataAccessException {
		StringBuilder sql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		sql.append("select * from ticket_parser_param where 1=1 and status = 1");
		sql.append(" and airline_type=?");
		params.add(airlineType.getValue());
		return repository.getListBySQL(TicketParserParam.class, sql.toString(),
				params);
	}

}
