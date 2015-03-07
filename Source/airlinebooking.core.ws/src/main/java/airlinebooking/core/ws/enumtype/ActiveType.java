package airlinebooking.core.ws.enumtype;

import java.util.HashMap;
import java.util.Map;

public enum ActiveType {
    
	DELETED(-1),
	
    INACTIVE (0),

    ACTIVE (1);
    
    
    /** The value. */
    private Integer value;
    
    /** The values. */
    private static Map<Integer, ActiveType> values = null;
    
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
    ActiveType(Integer value) {
        this.value = value;
    }
    
    /**
     * Parses the value.
     * 
     * @param value
     *            the value
     * @return the gender type
     */
    public static ActiveType parseValue(Integer value) {
    	if (value != null && value == -1){
    		value = -2;
    	}    		
        if (values == null) {
            values = new HashMap<Integer, ActiveType>(
                    ActiveType.values().length);
            for (ActiveType e : ActiveType.values())
                values.put(e.getValue(), e);
        }
        return values.get(value);
    }
}