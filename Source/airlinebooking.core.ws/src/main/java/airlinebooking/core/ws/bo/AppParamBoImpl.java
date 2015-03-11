package airlinebooking.core.ws.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlinebooking.core.ws.dao.AppParamDao;
import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.exception.BusinessException;
import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.AppParam;

@Service
public class AppParamBoImpl implements AppParamBo {

	@Autowired
	AppParamDao appParamDao;
	
	@Override
	public AppParam getAccountById(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAccount(AppParam acc) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AppParam> getParserPathByAirlineType(AirlineType airlineType)
			throws BusinessException {
		try {
			return appParamDao.getParserPathByAirlineType(airlineType);
		} catch (DataAccessException e) {
			throw new BusinessException(e);
		}
	}

}
