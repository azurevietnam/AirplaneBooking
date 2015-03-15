package airlinebooking.core.ws.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import airlinebooking.core.ws.enumtype.ActiveType;
import airlinebooking.core.ws.enumtype.AirlineType;
import airlinebooking.core.ws.enumtype.YesNoType;

@Entity
@Table(name = "ticket_parser_param", catalog = "airlinebooking")
public class TicketParserParam implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1679673561788175151L;
	private Integer id;
	private AirlineType airlineType;
	private String codeType;
	private String ticketTypeCode;
	private String description;
	private String selectorPath;
	private YesNoType haveParameter;
	private YesNoType haveMultiValue;
	private ActiveType status = ActiveType.ACTIVE;
	
	public TicketParserParam() {
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
		
	@Column(name = "code_type", nullable = false, length = 100)
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
	@Column(name = "ticket_type_code", nullable = false, length = 100)
	public String getTicketTypeCode() {
		return ticketTypeCode;
	}
	public void setTicketTypeCode(String ticketTypeCode) {
		this.ticketTypeCode = ticketTypeCode;
	}
	
	@Column(name = "description", length = 65535)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "selector_path", length = 65535)
	public String getSelectorPath() {
		return selectorPath;
	}
	public void setSelectorPath(String selectorPath) {
		this.selectorPath = selectorPath;
	}
	
	@Column(name = "status")
	@Type(type = "airlinebooking.core.ws.enumtype.GenericEnumUserType", parameters = {
			@Parameter(name = "enumClass", value = "airlinebooking.core.ws.enumtype.ActiveType"),
			@Parameter(name = "identifierMethod", value = "getValue"),
			@Parameter(name = "valueOfMethod", value = "parseValue") })
	public ActiveType getStatus() {
		return status;
	}
	public void setStatus(ActiveType status) {
		this.status = status;
	}

	@Column(name = "airline_type")
	@Type(type = "airlinebooking.core.ws.enumtype.GenericEnumUserType", parameters = {
			@Parameter(name = "enumClass", value = "airlinebooking.core.ws.enumtype.AirlineType"),
			@Parameter(name = "identifierMethod", value = "getValue"),
			@Parameter(name = "valueOfMethod", value = "parseValue") })
	public AirlineType getAirlineType() {
		return this.airlineType;
	}

	public void setAirlineType(AirlineType airlineType) {
		this.airlineType = airlineType;
	}
	
	@Column(name = "have_parameter")
	@Type(type = "airlinebooking.core.ws.enumtype.GenericEnumUserType", parameters = {
			@Parameter(name = "enumClass", value = "airlinebooking.core.ws.enumtype.YesNoType"),
			@Parameter(name = "identifierMethod", value = "getValue"),
			@Parameter(name = "valueOfMethod", value = "parseValue") })
	public YesNoType getHaveParameter() {
		return haveParameter;
	}

	public void setHaveParameter(YesNoType haveParameter) {
		this.haveParameter = haveParameter;
	}

	@Column(name = "have_multi_value")
	@Type(type = "airlinebooking.core.ws.enumtype.GenericEnumUserType", parameters = {
			@Parameter(name = "enumClass", value = "airlinebooking.core.ws.enumtype.YesNoType"),
			@Parameter(name = "identifierMethod", value = "getValue"),
			@Parameter(name = "valueOfMethod", value = "parseValue") })
	public YesNoType getHaveMultiValue() {
		return haveMultiValue;
	}

	public void setHaveMultiValue(YesNoType haveMultiValue) {
		this.haveMultiValue = haveMultiValue;
	}
}
