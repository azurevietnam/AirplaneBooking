package airlinebooking.core.ws.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airlinebooking.common.bo.AccountBo;
import airlinebooking.common.enumtype.ActiveType;
import airlinebooking.common.model.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class AccountTest {
	@Autowired
	AccountBo accountBo;
	
	@Test
	public void getAccountById(){
		try {
			Account acc = accountBo.getAccountById(1);
			System.out.println(acc.getCustomer().getFirstName() + " " + acc.getCustomer().getLastName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void updateAccount(){
		try {
			Account acc = accountBo.getAccountById(1);
			acc.setStatus(ActiveType.ACTIVE);
			acc.getCustomer().setFirstName("Lê");
			accountBo.updateAccount(acc);
			acc = accountBo.getAccountById(1);
			System.out.println(acc.getCustomer().getFirstName() + " " + acc.getCustomer().getLastName() + " account is " + acc.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
