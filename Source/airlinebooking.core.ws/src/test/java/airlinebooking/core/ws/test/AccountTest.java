package airlinebooking.core.ws.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airlinebooking.core.ws.bo.AccountBo;
import airlinebooking.core.ws.model.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class AccountTest {
	@Autowired
	AccountBo accountBo;
	
	@Test
	public void test(){
		try {
			Account acc = accountBo.findByUsername("ledona1509");
			System.out.println(acc.getCustomer().getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
