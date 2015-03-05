// default package
// Generated Mar 6, 2015 1:43:13 AM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CustomerBooking generated by hbm2java
 */
@Entity
@Table(name = "customer_booking", catalog = "airlinebooking")
public class CustomerBooking implements java.io.Serializable {

	private Integer id;
	private Integer accountId;
	private Integer customerId;
	private int ticketStorageId;
	private Integer adultQuanlity;
	private Integer childrenQuanlity;
	private Integer infantQuanlity;
	private Integer amountTotal;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;

	public CustomerBooking() {
	}

	public CustomerBooking(int ticketStorageId) {
		this.ticketStorageId = ticketStorageId;
	}

	public CustomerBooking(Integer accountId, Integer customerId,
			int ticketStorageId, Integer adultQuanlity,
			Integer childrenQuanlity, Integer infantQuanlity,
			Integer amountTotal, String createUser, Date createDate,
			String updateUser, Date updateDate) {
		this.accountId = accountId;
		this.customerId = customerId;
		this.ticketStorageId = ticketStorageId;
		this.adultQuanlity = adultQuanlity;
		this.childrenQuanlity = childrenQuanlity;
		this.infantQuanlity = infantQuanlity;
		this.amountTotal = amountTotal;
		this.createUser = createUser;
		this.createDate = createDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "account_id")
	public Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	@Column(name = "customer_id")
	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "ticket_storage_id", nullable = false)
	public int getTicketStorageId() {
		return this.ticketStorageId;
	}

	public void setTicketStorageId(int ticketStorageId) {
		this.ticketStorageId = ticketStorageId;
	}

	@Column(name = "adult_quanlity")
	public Integer getAdultQuanlity() {
		return this.adultQuanlity;
	}

	public void setAdultQuanlity(Integer adultQuanlity) {
		this.adultQuanlity = adultQuanlity;
	}

	@Column(name = "children_quanlity")
	public Integer getChildrenQuanlity() {
		return this.childrenQuanlity;
	}

	public void setChildrenQuanlity(Integer childrenQuanlity) {
		this.childrenQuanlity = childrenQuanlity;
	}

	@Column(name = "infant_quanlity")
	public Integer getInfantQuanlity() {
		return this.infantQuanlity;
	}

	public void setInfantQuanlity(Integer infantQuanlity) {
		this.infantQuanlity = infantQuanlity;
	}

	@Column(name = "amount_total")
	public Integer getAmountTotal() {
		return this.amountTotal;
	}

	public void setAmountTotal(Integer amountTotal) {
		this.amountTotal = amountTotal;
	}

	@Column(name = "create_user", length = 100)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "update_user", length = 100)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", length = 19)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}