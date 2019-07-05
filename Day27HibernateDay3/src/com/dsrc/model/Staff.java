package com.dsrc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Staff")
public class Staff {
	@Id
	@Column(name="Staff_id")
	private int staffid;
	@Column(name="Staff_Name")
	private String staffName;
	@Column(name="Salary")
	private float salary;
	public Staff(int id,String name,float salary)
	{
		this.staffid=id;
		this.staffName=name;
		this.salary=salary;
	}
	public Staff(int staffid){
		this.staffid=staffid;
	}
	public Staff(){
		
	}
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
}
