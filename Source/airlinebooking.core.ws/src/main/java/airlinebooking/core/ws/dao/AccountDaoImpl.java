package airlinebooking.core.ws.dao;

import java.util.List;

import airlinebooking.core.ws.model.Account;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class AccountDaoImpl extends HibernateDaoSupport implements AccountDao {

	public Account findByUsername(String userName) {
		@SuppressWarnings("unchecked")
		List<Account> list = (List<Account>) getHibernateTemplate().find("from Account where userName=?", userName);
		Account result =  list.get(0);
		return result;
	}

}
