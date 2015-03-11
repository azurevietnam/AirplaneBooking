package arilinebooking.core.ws.webbot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import airlinebooking.core.ws.model.AppParam;
import airlinebooking.core.ws.model.helper.HtmlResultMH;
import airlinebooking.core.ws.model.helper.TicketInforMH;

public class ParserImpl implements Parser {

	@Override
	public TicketInforMH getTicketInfor(HtmlResultMH htmlResultMH,
			List<AppParam> parserPathList) {
		TicketInforMH result = new TicketInforMH();
		Document doc = Jsoup.parse(htmlResultMH.getHtmlResult());

		return result;
	}

	@Override
	public Map<String, List<String>> getObjectInfor(HtmlResultMH htmlResultMH,
			List<AppParam> parserPathList) {
		Map<String, List<String>> resultHashMap = new HashMap<String, List<String>>();
		Document doc = Jsoup.parse(htmlResultMH.getHtmlResult());
		
		
		
		return null;
	}

}
