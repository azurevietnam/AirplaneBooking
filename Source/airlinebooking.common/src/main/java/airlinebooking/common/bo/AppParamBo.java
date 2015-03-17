package airlinebooking.common.bo;


import airlinebooking.common.exception.BusinessException;
import airlinebooking.common.model.AppParam;

public interface AppParamBo {
	public AppParam getAccountById(int id) throws BusinessException;

	public void updateAccount(AppParam acc) throws BusinessException;
}
