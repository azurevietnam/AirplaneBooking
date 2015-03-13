package airlinebooking.core.ws.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "ticket_flight_detail", catalog = "airlinebooking")
public class TicketFlightDetail implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5126607327296059558L;
	private Integer id;
	private Ticket ticket;
	private String originationCode;
	private String destinationCode;
	private Date fromTime;
	private Date toTime;
	private Integer durationTime;
	private String flightCode;
	public TicketFlightDetail() {
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
	
	@ManyToOne(targetEntity = Customer.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "ticket_id", referencedColumnName = "id")
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	@Column(name = "origination_code", length = 10)
	public String getOriginationCode() {
		return originationCode;
	}
	public void setOriginationCode(String originationCode) {
		this.originationCode = originationCode;
	}
	
	@Column(name = "destination_code", length = 10)
	public String getDestinationCode() {
		return destinationCode;
	}
	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "from_time", length = 19)
	public Date getFromTime() {
		return fromTime;
	}
	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "to_time", length = 19)
	public Date getToTime() {
		return toTime;
	}
	public void setToTime(Date toTime) {
		this.toTime = toTime;
	}
	
	@Column(name = "duration_time")
	public Integer getDurationTime() {
		return durationTime;
	}
	public void setDurationTime(Integer durationTime) {
		this.durationTime = durationTime;
	}

	@Column(name = "flight_code", length = 10)
	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
}
