package airlinebooking.core.ws.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airlinebooking.common.bo.AccountBo;
import airlinebooking.common.exception.BusinessException;
import airlinebooking.common.exception.DataAccessException;
import airlinebooking.common.model.Account;
import airlinebooking.core.ws.dao.AccountDao;

@Service
public class AccountBoImpl implements AccountBo {

	@Autowired
	AccountDao accountDao;
	
	@Override
	public Account findByUsername(String userName) {
		return accountDao.findByUsername(userName);
	}

	@Override
	public Account getAccountById(int id) throws BusinessException {
		try {
			return accountDao.getAccountById(id);
		} catch (DataAccessException e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void updateAccount(Account acc) throws BusinessException {
		try {
			accountDao.updateAccount(acc);
		} catch (DataAccessException e) {
			throw new BusinessException(e);
		}
	}

}
