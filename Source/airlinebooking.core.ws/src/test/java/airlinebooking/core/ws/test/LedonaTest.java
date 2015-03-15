package airlinebooking.core.ws.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class LedonaTest {
	@Test
	public void convertString(){
		String bigNumber = "0:40 (+1)";
		System.out.println(bigNumber.substring(0, bigNumber.indexOf(":") + 3));
	}
}
