package com.dsrc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Login")
public class Login {
	@Id
	@Column(name="LoginID")
	private String loginid;
	public Login(String id,String pass)
	{
		this.loginid=id;
		this.password=pass;
	}
	public Login()
	{
		
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="Password")
	private String password;
}
