package airlinebooking.core.ws.enumtype;

import java.util.HashMap;
import java.util.Map;

public enum YesNoType {
	YES(1),
	
    NO (0);
    
    
    /** The value. */
    private Integer value;
    
    /** The values. */
    private static Map<Integer, YesNoType> values = null;
    
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
    YesNoType(Integer value) {
        this.value = value;
    }
    
    /**
     * Parses the value.
     * 
     * @param value
     *            the value
     * @return the gender type
     */
    public static YesNoType parseValue(Integer value) {
    	if (value != null && value == -1){
    		value = -2;
    	}    		
        if (values == null) {
            values = new HashMap<Integer, YesNoType>(
                    YesNoType.values().length);
            for (YesNoType e : YesNoType.values())
                values.put(e.getValue(), e);
        }
        return values.get(value);
    }
}
