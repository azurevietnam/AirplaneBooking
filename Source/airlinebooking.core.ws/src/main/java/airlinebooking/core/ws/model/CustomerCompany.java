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
 * CustomerCompany generated by hbm2java
 */
@Entity
@Table(name = "customer_company", catalog = "airlinebooking")
public class CustomerCompany implements java.io.Serializable {

	private Integer id;
	private Integer customerBookingId;
	private Integer customerType;
	private String title;
	private String firstName;
	private String lastName;
	private String mobilephone;
	private Date birthDate;
	private Integer packageId;
	private Integer amountTicket;
	private Integer amountPackage;
	private Integer amountTotal;
	private String createUser;
	private Date createDate;
	private String updateUser;
	private Date updateDate;

	public CustomerCompany() {
	}

	public CustomerCompany(String title, String firstName, String lastName) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public CustomerCompany(Integer customerBookingId, Integer customerType,
			String title, String firstName, String lastName,
			String mobilephone, Date birthDate, Integer packageId,
			Integer amountTicket, Integer amountPackage, Integer amountTotal,
			String createUser, Date createDate, String updateUser,
			Date updateDate) {
		this.customerBookingId = customerBookingId;
		this.customerType = customerType;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobilephone = mobilephone;
		this.birthDate = birthDate;
		this.packageId = packageId;
		this.amountTicket = amountTicket;
		this.amountPackage = amountPackage;
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

	@Column(name = "customer_booking_id")
	public Integer getCustomerBookingId() {
		return this.customerBookingId;
	}

	public void setCustomerBookingId(Integer customerBookingId) {
		this.customerBookingId = customerBookingId;
	}

	@Column(name = "customer_type")
	public Integer getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
	}

	@Column(name = "title", nullable = false, length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "first_name", nullable = false, length = 100)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false, length = 100)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "mobilephone", length = 20)
	public String getMobilephone() {
		return this.mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", length = 10)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "package_id")
	public Integer getPackageId() {
		return this.packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	@Column(name = "amount_ticket")
	public Integer getAmountTicket() {
		return this.amountTicket;
	}

	public void setAmountTicket(Integer amountTicket) {
		this.amountTicket = amountTicket;
	}

	@Column(name = "amount_package")
	public Integer getAmountPackage() {
		return this.amountPackage;
	}

	public void setAmountPackage(Integer amountPackage) {
		this.amountPackage = amountPackage;
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
