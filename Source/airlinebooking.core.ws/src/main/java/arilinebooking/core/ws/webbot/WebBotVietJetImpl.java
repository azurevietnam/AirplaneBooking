package arilinebooking.core.ws.webbot;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DeflaterInputStream;
import java.util.zip.GZIPInputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import airlinebooking.core.ws.helper.DateHelper;

public class WebBotVietJetImpl implements WebBot {
	final String urlNoSessionId = "https://ameliaweb5.intelisys.ca/VietJet/ameliapost.aspx?lang=en";
	String urlWithSessionId = "https://ameliaweb5.intelisys.ca/VIETJET/TravelOptions.aspx?lang=en&st=pb&sesid=";
    final String charset = "UTF-8";
    final String requestPostMethod = "POST";
    final String requestGetMethod = "GET";
    final int readTimeOut = 10 * 1000;
    
    private Map<String, String> initRequestParams(){
        Map<String, String> requestParams = new HashMap<String, String>();
        requestParams.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2329.0 Safari/537.36");
        requestParams.put("Accept-Language", "en-US,en;q=0.5");
        requestParams.put("Content-Type", "application/x-www-form-urlencoded");
        requestParams.put("Accept-Charset", charset);
        requestParams.put("Host", "ameliaweb5.intelisys.ca");
        requestParams.put("Referer", "https://ameliaweb5.intelisys.ca/VietJet/ameliapost.aspx?lang=vi");
        requestParams.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        requestParams.put("Accept-Encoding", "gzip, deflate");
        requestParams.put("Connection", "keep-alive");
        return requestParams;
    }
    
    @Override
    public String getHtmlResult(String oriCode, String desCode, Date pickedDate, int adultNumber, int childrenNumber,
            int infantNumber) throws Exception {
        String htmlResult = "";
		
        String departDayStr = DateHelper.convertDateToString(pickedDate, "dd");
        String departMonthStr = DateHelper.convertDateToString(pickedDate, "yyyy-MM").replaceAll("-", "%2F");
        Date currentDate = new Date();
        String currentDayStr = DateHelper.convertDateToString(currentDate, "dd");
        String currentMonthStr = DateHelper.convertDateToString(currentDate, "yyyy-MM").replaceAll("-", "%2F");
        
        
        try {
            Map<String, String> requestParams = initRequestParams();
            String postParameterRequest1 = "chkRoundTrip=&"
            		+ "lstOrigAP=" + oriCode
            		+ "&lstDestAP=" + desCode
            		+ "&dlstDepDate_Day=" + departDayStr
            		+ "&dlstDepDate_Month=" + departMonthStr
            		+ "&dlstRetDate_Day=" + departDayStr
            		+ "&dlstRetDate_Month=" + departMonthStr
            		+ "&lstCurrency=VND&lstResCurrency=VND&lstDepDateRange=0&lstRetDateRange=0&"
            		+ "txtNumAdults=" + adultNumber
            		+ "&txtNumChildren=" + childrenNumber
            		+ "&txtNumInfants=" + infantNumber
            		+ "&lstLvlService=1&blnFares=False&txtPromoCode=";
            
            
            String postParameterRequest2 = "__VIEWSTATE=%2FwEPDwULLTE1MzQ1MjI3MzAPZBYCZg9kFg4CCA8QZGQWAGQCCQ8QZGQWAGQCCw8QZGQWAGQCDQ8QZGQWAGQCEQ8QZGQWAGQCEg8QZGQWAGQCEw8QZGQWAGRkDuhQN17CT5ZIydlFFSt%2BWc8NsCA%3D&__VIEWSTATEGENERATOR=BA3C3B49&SesID=&DebugID=62&lstOrigAP=-1&lstDestAP=-1&"
            		+ "dlstDepDate_Day=" + currentDayStr
            		+ "&dlstDepDate_Month=" + currentMonthStr
            		+ "&lstDepDateRange=0&dlstRetDate_Day=16"
            		+ "&dlstRetDate_Month=2015%2F03"
            		+ "&lstRetDateRange=0"
            		+ "&txtNumAdults=0"
            		+ "&txtNumChildren=0"
            		+ "&txtNumInfants=0"
            		+ "&lstLvlService=1&lstResCurrency=VND&lstCurrency=VND&txtPromoCode=";
            
            // Begin step 1
            URL objectURLForRequest1_2 = new URL(urlNoSessionId);
            HttpURLConnection connection1 = (HttpURLConnection) objectURLForRequest1_2.openConnection();
            
            // Set redirect to false
            connection1.setInstanceFollowRedirects(false);
            connection1.setReadTimeout(readTimeOut);
            connection1.setRequestMethod(requestPostMethod);
            for (Map.Entry<String, String> requestParamEntry : requestParams.entrySet()) {
                connection1.setRequestProperty(requestParamEntry.getKey(), requestParamEntry.getValue());
            }
            
            // Send post request
            connection1.setDoOutput(true);
            DataOutputStream dataOutputStream = new DataOutputStream(connection1.getOutputStream());
            dataOutputStream.writeBytes(postParameterRequest1);
            dataOutputStream.flush();
            dataOutputStream.close();
            
            String cookieInRequest1String = connection1.getHeaderField("Set-Cookie");

            // Get session id for request 3
            String sessionIdForRequest3 = "";
            List<HttpCookie> cookies = HttpCookie.parse(cookieInRequest1String);
            for (HttpCookie httpCookie : cookies) {
				if (httpCookie.getName().equals("ASP.NET_SessionId"))
				{
					sessionIdForRequest3 = httpCookie.getValue();
					break;
				}
			}
                     
            // Begin step 2
            HttpURLConnection connection2 = (HttpURLConnection) objectURLForRequest1_2.openConnection();
            // Set redirect to false
            connection2.setInstanceFollowRedirects(false);
            connection2.setReadTimeout(readTimeOut);
            connection2.setRequestMethod(requestPostMethod);
            for (Map.Entry<String, String> requestParamEntry : requestParams.entrySet()) {
                connection2.setRequestProperty(requestParamEntry.getKey(), requestParamEntry.getValue());
            }
            connection2.setRequestProperty("Cookie", cookieInRequest1String);
            
            // Send post request
            connection2.setDoOutput(true);
            dataOutputStream = new DataOutputStream(connection2.getOutputStream());
            dataOutputStream.writeBytes(postParameterRequest2);
            dataOutputStream.flush();
            dataOutputStream.close();
            
            // Ommit this connection2.getInputStream will lead to Session Expired !
            @SuppressWarnings("unused")
			InputStream connectionInputStream2 = connection2.getInputStream();
            
            // Begin step 3
            urlWithSessionId = urlWithSessionId + sessionIdForRequest3;
//            System.out.println(urlWithSessionId);
            URL objectURLForRequest3 = new URL(urlWithSessionId);
            HttpURLConnection connection3 = (HttpURLConnection) objectURLForRequest3.openConnection();
            connection3.setRequestMethod(requestGetMethod);
            connection3.setRequestProperty("Cookie", cookieInRequest1String);
            for (Map.Entry<String, String> requestParamEntry : requestParams.entrySet()) {
                connection3.setRequestProperty(requestParamEntry.getKey(), requestParamEntry.getValue());
            }
            
            String inputLine;
            
            InputStream connectionInputStream = connection3.getInputStream();
            String contentEncoding = connection3.getContentEncoding();
//            System.out.println("contentEncoding: " + contentEncoding);
            if (connection3.getContentEncoding() != null){
            	if (contentEncoding.toLowerCase().contains("gzip")) {
                    connectionInputStream = new GZIPInputStream(connectionInputStream);
                }
                if (contentEncoding.toLowerCase().contains("deflate")){
                    connectionInputStream = new DeflaterInputStream(connectionInputStream);
                }
            }
            
            BufferedReader in = new BufferedReader(new InputStreamReader(connectionInputStream, charset));
            
            StringBuffer html = new StringBuffer();
         
            while ((inputLine = in.readLine()) != null) {
                html.append(inputLine);
            }
            in.close();
            
            Document doc = Jsoup.parse(html.toString());
            
            htmlResult = doc.toString();
         
            System.out.println("URL Content... \n" + html.toString());
//            System.out.println("Done inside");
         
        }
        catch (Exception e) {
            e.printStackTrace();
        }
         
    return htmlResult;
    }

}
