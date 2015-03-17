package airlinebooking.core.ws.bo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlinebooking.common.bo.AppParamBo;
import airlinebooking.common.exception.BusinessException;
import airlinebooking.common.model.AppParam;
import airlinebooking.core.ws.dao.AppParamDao;

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
}
