package airlinebooking.core.ws.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airlinebooking.core.ws.helper.DateHelper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class LedonaTest {
	@Test
	public void convertString(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 29);
		Date pickedDate = cal.getTime();
		
		String pickedDateMonth = DateHelper.convertDateToString(pickedDate, "yyyy-MM").replaceAll("-", "%2F");
		System.out.println(pickedDateMonth);
	}
}
