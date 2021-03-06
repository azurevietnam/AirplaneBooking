package airlinebooking.common.enumtype;

import java.util.HashMap;
import java.util.Map;

public enum CustomerCompanyType {
	ADULT(1),
	
    CHILDREN (2),

    INFANT (3);
    
    
    /** The value. */
    private Integer value;
    
    /** The values. */
    private static Map<Integer, CustomerCompanyType> values = null;
    
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
    CustomerCompanyType(Integer value) {
        this.value = value;
    }
    
    /**
     * Parses the value.
     * 
     * @param value
     *            the value
     * @return the gender type
     */
    public static CustomerCompanyType parseValue(Integer value) {
    	if (value != null && value == -1){
    		value = -2;
    	}    		
        if (values == null) {
            values = new HashMap<Integer, CustomerCompanyType>(
                    CustomerCompanyType.values().length);
            for (CustomerCompanyType e : CustomerCompanyType.values())
                values.put(e.getValue(), e);
        }
        return values.get(value);
    }

}
