package airlinebooking.core.ws.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import arilinebooking.core.ws.webbot.VNAirlineWebBot;
import arilinebooking.core.ws.webbot.WebBot;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml" })
public class VNAirlineWebBotTest {
	@Test
	public void getHTMLByJavaNet(){
		URL url;
		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
		try {
//			// get URL content
//			url = new URL("https://wl-prod.sabresonicweb.com/SSW2010/B3QE/webqtrip.html?searchType=NORMAL&journeySpan=RT&origin=HAN&destination=DAD&departureDate=2015-03-13&returnDate=2015-03-16&numAdults=1&numChildren=0&numInfants=0&alternativeLandingPage=true&promoCode=&lang=vi_VN");
//			
//			URLConnection conn = url.openConnection();
// 
//			// open the stream and put it into BufferedReader
//			BufferedReader br = new BufferedReader(
//                               new InputStreamReader(conn.getInputStream()));
//			StringBuilder result = new StringBuilder();
//			String inputLine;
////			while ((inputLine = br.readLine()) != null) {
////				result.append(inputLine);
////			}
////			br.close();
//			
//			//save to this filename
//			String fileName = "/Users/Dona/Desktop/untitled.html";
//			File file = new File(fileName);
// 
//			if (!file.exists()) {
//				file.createNewFile();
//			}
// 
//			//use FileWriter to write file
//			FileWriter fw = new FileWriter(file.getAbsoluteFile());
//			BufferedWriter bw = new BufferedWriter(fw);
// 
//			while ((inputLine = br.readLine()) != null) {
//				bw.write(inputLine);
//			}
// 
//			bw.close();
//			br.close();
//			
//			Document doc = Jsoup.parse(file, "UTF-8");
			
			Document doc = Jsoup.connect("https://wl-prod.sabresonicweb.com/SSW2010/B3QE/webqtrip.html?searchType=NORMAL&journeySpan=RT&origin=HAN&destination=DAD&departureDate=2015-03-13&returnDate=2015-03-16&numAdults=1&numChildren=0&numInfants=0&alternativeLandingPage=true&promoCode=&lang=vi_VN")
					.userAgent("Mozilla")
					.data("cookie", "JSESSIONID=9C9624AAFFA794EC23A242EBF25906BB; Path=/SSW2010/; Secure; HttpOnly WLPCOOKIE=sswhlp3061; Expires=Mon, 09-Mar-2015 17:38:55 GMT; Path=/SSW2010; Secure; HttpOnly")
					.timeout(200*1000)
					.get();
//			Element content = doc.getElementById("yui_3_1_2_1_14259155388083828");
//			Elements content = doc.select("h2.translate.wasTranslated");
			Elements content = doc.select("div#flc_1 > p.flight-number > a.translate");
 
			System.out.println(content.text());
			System.out.println("Done");
 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getHTMLByJSoup(){
		WebBot wb = new VNAirlineWebBot();
		wb.getHTML();
		System.out.println("");
	}
}
