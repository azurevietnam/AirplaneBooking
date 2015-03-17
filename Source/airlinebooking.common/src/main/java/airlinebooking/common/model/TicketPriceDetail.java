package airlinebooking.common.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket_price_detail")
public class TicketPriceDetail implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1426326134468307419L;
	private Integer id;
	private Ticket ticket;
	private String ticketTypeCode;
	private Integer ticketPrice;
	private Integer tax;
	private Integer total;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = Ticket.class)
	@JoinColumn(name = "ticket_id", referencedColumnName = "id")
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	@Column(name = "ticket_type_code", length = 100)
	public String getTicketTypeCode() {
		return ticketTypeCode;
	}
	public void setTicketTypeCode(String ticketTypeCode) {
		this.ticketTypeCode = ticketTypeCode;
	}
	
	@Column(name = "tax")
	public Integer getTax() {
		return tax;
	}
	public void setTax(Integer tax) {
		this.tax = tax;
	}
	
	@Column(name = "ticket_price")
	public Integer getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Integer ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	@Column(name = "total")
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
}
