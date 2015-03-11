package airlinebooking.core.ws.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import airlinebooking.core.ws.dao.AppParamDao;
import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.model.AppParam;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class AppParamTest {
	@Autowired
	AppParamDao appDao;
	
	@Test
	public void getListByHQL(){
		try {
			List<AppParam> result = appDao.getParserPathByAirlineType(AirlineType.VNAIRLINE);
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
