package airlinebooking.core.ws.enumtype;

import java.util.HashMap;
import java.util.Map;

public enum AirlineType {
	VNAIRLINE(1),
	
    JETSTAR (2),

    VIETJET (3);
    
    
    /** The value. */
    private Integer value;
    
    /** The values. */
    private static Map<Integer, AirlineType> values = null;
    
    /**
     * Gets the value.
     * 
     * @return the value
     */
    public Integer getValue() {
        return value;
    }
    
    /**
     * Instantiates a new gender type.
     * 
     * @param value
     *            the value
     */
    AirlineType(Integer value) {
        this.value = value;
    }
    
    /**
     * Parses the value.
     * 
     * @param value
     *            the value
     * @return the gender type
     */
    public static AirlineType parseValue(Integer value) {
    	if (value != null && value == -1){
    		value = -2;
    	}    		
        if (values == null) {
            values = new HashMap<Integer, AirlineType>(
            		AirlineType.values().length);
            for (AirlineType e : AirlineType.values())
                values.put(e.getValue(), e);
        }
        return values.get(value);
    }
}
