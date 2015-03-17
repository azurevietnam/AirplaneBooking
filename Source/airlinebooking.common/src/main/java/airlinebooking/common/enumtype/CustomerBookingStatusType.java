package airlinebooking.common.enumtype;

import java.util.HashMap;
import java.util.Map;

public enum CustomerBookingStatusType {
	DELETED(-1),
	
    INACTIVE (0),

    ACTIVE (1);
    
    
    /** The value. */
    private Integer value;
    
    /** The values. */
    private static Map<Integer, CustomerBookingStatusType> values = null;
    
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
    CustomerBookingStatusType(Integer value) {
        this.value = value;
    }
    
    /**
     * Parses the value.
     * 
     * @param value
     *            the value
     * @return the gender type
     */
    public static CustomerBookingStatusType parseValue(Integer value) {
    	if (value != null && value == -1){
    		value = -2;
    	}    		
        if (values == null) {
            values = new HashMap<Integer, CustomerBookingStatusType>(
                    CustomerBookingStatusType.values().length);
            for (CustomerBookingStatusType e : CustomerBookingStatusType.values())
                values.put(e.getValue(), e);
        }
        return values.get(value);
    }
}
