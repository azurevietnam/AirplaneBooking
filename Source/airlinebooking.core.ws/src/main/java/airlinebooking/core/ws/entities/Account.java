package airlinebooking.core.ws.entities;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class Account {
	private int id;
	private Date createDate;
	private String createUser;
	
	@Autowired
	private Customer customer;
	private String password;
	private int status;
	private Date updateDate;
	private String updateUser;
	private String userName;
	
	public Account(){}
	
	public void Show(){
		System.out.println("Inside Account");
		customer.Show();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Customer getCustomerId() {
		return customer;
	}
	public void setCustomerId(Customer customer) {
		this.customer = customer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
