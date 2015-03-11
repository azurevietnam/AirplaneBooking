package airlinebooking.core.ws.dao;

import java.util.List;

import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.exception.DataAccessException;
import airlinebooking.core.ws.model.AppParam;

public interface AppParamDao {
	public AppParam getAccountById(int id) throws DataAccessException;

	public void updateAccount(AppParam app) throws DataAccessException;
	
	/**
	 * Get list parser path from app_param table by AirlineType
	 * @param airlineType Type of airline
	 * @return List AppParam object
	 * @throws DataAccessException 
	 */
	public List<AppParam> getParserPathByAirlineType(AirlineType airlineType) throws DataAccessException;
}
