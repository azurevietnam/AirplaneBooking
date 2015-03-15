package arilinebooking.core.ws.webbot;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import airlinebooking.core.ws.helper.DateHelper;

public class WebBotJetImpl implements WebBot {
	final String urlHeader = "http://booknow.jetstar.com";
	final String urlTailBeforeRedirect = "/Search.aspx?culture=vi-VN";
	final String charset = "UTF-8";
	final String requestMethod = "POST";
	final int readTimeOut = 10 * 1000;
	
	private Map<String, String> initRequestParams(){
		Map<String, String> requestParams = new HashMap<String, String>();
		requestParams.put("User-Agent", "Mozilla/5.0");
		requestParams.put("Accept-Language", "en-US,en;q=0.5");
		requestParams.put("Content-Type", "application/x-www-form-urlencoded");
		requestParams.put("Accept-Charset", charset);
		requestParams.put("Host", "booknow.jetstar.com");
		requestParams.put("Referer", "http://www.jetstar.com/vn/vi/home");
		requestParams.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		requestParams.put("Accept-Encoding", "gzip, deflate");
		requestParams.put("Connection", "keep-alive");
		return requestParams;
	}
	
	@Override
	public String getHtmlResult(String oriCode, String desCode, Date pickedDate, int adultNumber, int childrenNumber,
			int infantNumber) throws Exception {
		String htmlResult = "";
		
		String pickedDateDay = DateHelper.convertDateToString(pickedDate, "dd");
		String pickedDateMonth = DateHelper.convertDateToString(pickedDate, "yyyy-MM");
		
		try {
			Map<String, String> requestParams = initRequestParams();
			String postBodyParameters = "ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListCurrency=VND&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListFareTypes=I&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24"
					+ "DropDownListMarketDay1=" + pickedDateDay
					+ "&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketDay2=1&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketDay3=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24"
					+ "DropDownListMarketMonth1=" + pickedDateMonth
					+ "&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketMonth2=1968-1&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24DropDownListMarketMonth3=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24"
					+ "DropDownListPassengerType_ADT=" + adultNumber
					+ "&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24"
					+ "DropDownListPassengerType_CHD=" + childrenNumber
					+ "&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24"
					+ "DropDownListPassengerType_INFANT=" + infantNumber
					+ "&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24RadioButtonMarketStructure=OneWay&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24"
					+ "TextBoxMarketDestination1=" + desCode
					+ "&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketDestination2=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketDestination3=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24"
					+ "TextBoxMarketOrigin1=" + oriCode
					+ "&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketOrigin2=&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24TextBoxMarketOrigin3=&ControlGroupSearchView%24ButtonSubmit=&__VIEWSTATE=%2FwEPDwUBMGQYAQUeX19Db250cm9sc1JlcXVpcmVQb3N0QmFja0tleV9fFgEFJ01lbWJlckxvZ2luU2VhcmNoVmlldyRtZW1iZXJfUmVtZW1iZXJtZSDCMtVG%2F1lYc7dy4fVekQjBMvD5&culture=vi-VN&date_picker=&go-booking=&pageToken=sLkmnwXwAsY%3D&ControlGroupSearchView%24AvailabilitySearchInputSearchView%24fromCS=yes";
			
			// Cookie manager registry
			CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
			
			URL obj = new URL(urlHeader + urlTailBeforeRedirect);
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
			
			// Set redirect to false
			conn.setInstanceFollowRedirects(false);
			
			conn.setReadTimeout(readTimeOut);
			conn.setRequestMethod(requestMethod);
			for (Map.Entry<String, String> requestParamEntry : requestParams.entrySet()) {
				conn.setRequestProperty(requestParamEntry.getKey(), requestParamEntry.getValue());
			}
			
			// Send post request
			conn.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes(postBodyParameters);
			wr.flush();
			wr.close();
			
//			System.out.println("Request URL ... " + urlHeader + urlTailBeforeRedirect);
		 
			boolean redirect = false;
		 
			// normally, 3xx is redirect
			int status = conn.getResponseCode();
			if (status != HttpURLConnection.HTTP_OK) {
				if (status == HttpURLConnection.HTTP_MOVED_TEMP
					|| status == HttpURLConnection.HTTP_MOVED_PERM
						|| status == HttpURLConnection.HTTP_SEE_OTHER)
				redirect = true;
			}
		 
//			System.out.println("Response Code ... " + status);
		 
			if (redirect) {
		 
				// get redirect url from "location" header field
				final String urlTailAfterRedirect = conn.getHeaderField("Location");
		 
				// get the cookie if need, for login
				String cookies = conn.getHeaderField("Set-Cookie");
		 
				// open the new connnection again
				conn = (HttpURLConnection) new URL(urlHeader + urlTailAfterRedirect).openConnection();
				conn.setRequestProperty("Cookie", cookies);
				
				conn.setReadTimeout(readTimeOut);
				conn.setRequestMethod(requestMethod);
				for (Map.Entry<String, String> requestParamEntry : requestParams.entrySet()) {
					conn.setRequestProperty(requestParamEntry.getKey(), requestParamEntry.getValue());
				}
				
				conn.setDoOutput(true);
				wr = new DataOutputStream(conn.getOutputStream());
				wr.writeBytes(postBodyParameters);
				wr.flush();
				wr.close();
				
//				System.out.println("Redirect to URL : " + urlHeader + urlTailAfterRedirect);
		 
			}
			
			String inputLine;
			
			InputStream connectionInputStream = conn.getInputStream();
			String contentEncoding = conn.getContentEncoding();
			if (contentEncoding.toLowerCase().contains("gzip")) {
				connectionInputStream = new GZIPInputStream(connectionInputStream);
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(connectionInputStream, charset));
			
			StringBuffer html = new StringBuffer();
		 
			while ((inputLine = in.readLine()) != null) {
				html.append(inputLine);
			}
			in.close();
			
			Document doc = Jsoup.parse(html.toString());
			
			htmlResult = doc.toString();
		 
//			System.out.println("URL Content... \n" + html.toString());
//			System.out.println("Done");
		 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		 
	return htmlResult;
	}

}
