package airlinebooking.core.ws.dao;

import java.util.List;

import airlinebooking.common.exception.DataAccessException;
import airlinebooking.common.model.Account;
import airlinebooking.core.ws.repo.QueryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl extends HibernateDaoSupport implements AccountDao {
	@Autowired
	QueryRepo queryRepo;
	
	@Override
	public Account findByUsername(String userName) {
		@SuppressWarnings("unchecked")
		List<Account> list = (List<Account>) getHibernateTemplate().find("from Account where userName=?", userName);
		Account result =  list.get(0);
		return result;
	}

	@Override
	public Account getAccountById(int id) throws DataAccessException {
		return queryRepo.getEntityById(Account.class, id);
	}

	@Override
	public void updateAccount(Account acc) throws DataAccessException {
		queryRepo.update(acc);
	}

}
