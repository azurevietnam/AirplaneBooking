package airlinebooking.core.ws.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class LedonaTest {
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
	
	@Test
	public void test(){
		try {
			Pair<Integer, String> p1 = new Pair<>(1, "apple");
			Pair<Integer, String> p2 = new Pair<>(2, "pear");
			boolean same = LedonaTest.compare(p1, p2);
			
			System.out.println(same);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
