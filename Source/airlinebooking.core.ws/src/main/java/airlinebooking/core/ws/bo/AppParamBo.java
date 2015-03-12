package airlinebooking.core.ws.bo;


import airlinebooking.core.ws.exception.BusinessException;
import airlinebooking.core.ws.model.AppParam;

public interface AppParamBo {
	public AppParam getAccountById(int id) throws BusinessException;

	public void updateAccount(AppParam acc) throws BusinessException;
}
