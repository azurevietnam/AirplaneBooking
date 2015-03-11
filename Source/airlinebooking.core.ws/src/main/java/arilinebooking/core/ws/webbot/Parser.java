package arilinebooking.core.ws.webbot;

import airlinebooking.core.ws.model.helper.HtmlResultMH;
import airlinebooking.core.ws.model.helper.TicketInforMH;

public interface Parser {
	public TicketInforMH getTicketInfor(HtmlResultMH htmlResultMH);
}
