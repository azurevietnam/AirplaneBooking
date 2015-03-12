package arilinebooking.core.ws.webbot;

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
		
		if (!htmlResultMH.getHtmlResult().isEmpty())
		{
			Document doc = Jsoup.parse(htmlResultMH.getHtmlResult());
			
			for (TicketParserParam ticketParserParam : parserPathList) {
				Elements elements = doc.select(ticketParserParam.getSelectorPath());
				
				if (ticketParserParam.getTicketTypeCode() == ""){
					resultHashMap.put(ticketParserParam.getCodeType(), elements);
				}
				else{
					// Danh cho loai gia ve amount
					if (!elements.isEmpty()){
						if (resultHashMap.get(ticketParserParam.getCodeType()) != null)
						{
							HashMap<String, Object> hashMapListOld = (HashMap<String, Object>) resultHashMap.get(ticketParserParam.getCodeType());
							hashMapListOld.put(ticketParserParam.getTicketTypeCode(), elements);
							resultHashMap.put(ticketParserParam.getCodeType(), hashMapListOld);
						}
						else{
							HashMap<String, Object> hashMapListNew = new HashMap<String, Object>();
							hashMapListNew.put(ticketParserParam.getTicketTypeCode(), elements);
							resultHashMap.put(ticketParserParam.getCodeType(), hashMapListNew);
						}
					}
				}
			}
		}
		
		return resultHashMap;
	}

}
