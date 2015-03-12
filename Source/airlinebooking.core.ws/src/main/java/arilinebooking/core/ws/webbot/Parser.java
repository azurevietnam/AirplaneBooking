package arilinebooking.core.ws.webbot;

import java.util.HashMap;
import java.util.List;

import airlinebooking.core.ws.model.TicketParserParam;
import airlinebooking.core.ws.model.helper.HtmlResultMH;

public interface Parser {
	public HashMap<String, Object> getObjectInfor(HtmlResultMH htmlResultMH, List<TicketParserParam> parserPathList); 
}
