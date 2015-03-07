package airlinebooking.core.ws.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airlinebooking.core.ws.bo.AccountBo;
import airlinebooking.core.ws.enumtype.ActiveType;
import airlinebooking.core.ws.model.Account;

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
			acc.setStatus(ActiveType.INACTIVE);
			acc.getCustomer().setFirstName("Trang");
			accountBo.updateAccount(acc);
			acc = accountBo.getAccountById(1);
			System.out.println(acc.getCustomer().getFirstName() + " " + acc.getCustomer().getLastName() + " account is " + acc.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
