package arilinebooking.core.ws.webbot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import airlinebooking.core.ws.model.TicketParserParam;
import airlinebooking.core.ws.model.helper.HtmlResultMH;

public class ParserJsoupImpl implements Parser {

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> getObjectInfor(HtmlResultMH htmlResultMH,
			List<TicketParserParam> parserPathList) {
		HashMap<String, Object> resultHashMap = new HashMap<String, Object>();
		Document doc = Jsoup.parse(htmlResultMH.getHtmlResult());
		
		for (TicketParserParam ticketParserParam : parserPathList) {
			Elements elements = doc.select(ticketParserParam.getSelectorPath());
			
			if (ticketParserParam.getTicketTypeCode() == ""){
				resultHashMap.put(ticketParserParam.getCodeType(), elements);
			}
			else{
				HashMap<String, Object> subHashMap = new HashMap<String, Object>();
				subHashMap.put(ticketParserParam.getTicketTypeCode(), elements);
				
				if (resultHashMap.get(ticketParserParam.getCodeType()) != null)
				{
					List<HashMap<String, Object>> hashMapListOld = (List<HashMap<String, Object>>) resultHashMap.get(ticketParserParam.getCodeType());
					hashMapListOld.add(subHashMap);
					resultHashMap.put(ticketParserParam.getCodeType(), hashMapListOld);
				}
				else{
					List<HashMap<String, Object>> hashMapList = new ArrayList<HashMap<String, Object>>();
					hashMapList.add(subHashMap);
					resultHashMap.put(ticketParserParam.getCodeType(), hashMapList);
				}
			}
		}
		
		return resultHashMap;
	}

}
