package airlinebooking.core.ws.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airlinebooking.core.ws.dao.AppParamDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class AppParamTest {
	@Autowired
	AppParamDao appDao;
	
	@Test
	public void getListByHQL(){
		try {
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
