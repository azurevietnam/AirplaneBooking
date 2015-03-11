package airlinebooking.core.ws.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.AppParam;
import airlinebooking.core.ws.repo.QueryRepo;

@Repository
public class AppParamDaoImpl implements AppParamDao{
	@Autowired
	QueryRepo repository;
	
	@Override
	public AppParam getAccountById(int id) throws DataAccessException {
		return repository.getEntityById(AppParam.class, id);
	}

	@Override
	public void updateAccount(AppParam app) throws DataAccessException {
		repository.update(app);
		
	}

	@Override
	public List<AppParam> getParserPathByAirlineType(AirlineType airlineType) throws DataAccessException {
		final String vnaCodeType = "VNA_PARSER_PATH";
		final String jetstarCodeType = "JET_PARSER_PATH";
		final String vietjetCodeType = "VJET_PARSER_PATH";
		
		StringBuilder hql = new StringBuilder();
		List<Object> params = new ArrayList<Object>();
		
		hql.append("from AppParam ap where ap.codeType = ?");
		switch (airlineType) {
		case VNAIRLINE:
			params.add(vnaCodeType.toUpperCase());
			break;
		case JETSTAR:
			params.add(jetstarCodeType.toUpperCase());
			break;
		case VIETJET:
			params.add(vietjetCodeType.toUpperCase());
			break;
		default:
			return null;
		}
		
		return repository.getListByHQL(hql.toString(), params);
	}

}
