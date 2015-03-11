package arilinebooking.core.ws.webbot;

import java.util.List;
import java.util.Map;

import airlinebooking.core.ws.model.AppParam;
import airlinebooking.core.ws.model.helper.HtmlResultMH;
import airlinebooking.core.ws.model.helper.TicketInforMH;

public interface Parser {
	public TicketInforMH getTicketInfor(HtmlResultMH htmlResultMH, List<AppParam> parserPathList);
	
	public Map<String, List<String>> getObjectInfor(HtmlResultMH htmlResultMH, List<AppParam> parserPathList); 
}
