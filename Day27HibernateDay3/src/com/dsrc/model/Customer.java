package com.dsrc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@Column(name="Customer_Id")
	private int customerid;
	@Column(name="Customer_Name")
	private String customerName;
	@Column(name="Email")
	private String email;
	@Column(name="MobileNO")
	private long mobileno;
	public Customer(int id,String name,String email,long no)
	{
		this.customerid=id;
		this.customerName=name;
		this.email=email;
		this.mobileno=no;
	}
	public Customer(int custid)
	{
		this.customerid=custid;
	}
	public Customer(){
		
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileno() {
		return mobileno;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
}
