package arilinebooking.core.ws.webbot;

import java.util.HashMap;
import java.util.List;

import airlinebooking.core.ws.model.helper.TicketInforRawMH;

public interface TicketInfoRawMaker {
	public List<TicketInforRawMH> convertParserToTicketInforMH(
			HashMap<String, Object> objectConvertHashMap);
}
