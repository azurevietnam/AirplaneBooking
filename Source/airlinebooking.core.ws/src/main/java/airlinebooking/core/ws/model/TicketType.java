package airlinebooking.core.ws.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_type", catalog = "airlinebooking")
public class TicketType implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1426326134468307419L;
	private Integer id;
	private TicketStorage ticketStorage;
	private String ticketTypeCode;
	private String amountString;
	private Integer amount;
	
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
	@JoinColumn(name = "ticket_storage_id", referencedColumnName = "id")
	public TicketStorage getTicketStorage() {
		return ticketStorage;
	}
	public void setTicketStorage(TicketStorage ticketStorage) {
		this.ticketStorage = ticketStorage;
	}
	
	@Column(name = "ticket_type_code", length = 100)
	public String getTicketTypeCode() {
		return ticketTypeCode;
	}
	public void setTicketTypeCode(String ticketTypeCode) {
		this.ticketTypeCode = ticketTypeCode;
	}
	
	@Column(name = "amount_string", length = 100)
	public String getAmountString() {
		return amountString;
	}
	public void setAmountString(String amountString) {
		this.amountString = amountString;
	}
	
	@Column(name = "amount")
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
