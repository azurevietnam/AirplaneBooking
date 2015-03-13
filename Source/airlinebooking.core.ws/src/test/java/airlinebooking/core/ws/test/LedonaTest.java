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
		String bigNumber = "";
//		NumberFormat format = NumberFormat.getInstance(Locale.US);
//	        Number number = 0;
//		try {
//			number = format.parse(bigNumber);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		int result = number.intValue();
		
		System.out.println(bigNumber.isEmpty());
	}
}
