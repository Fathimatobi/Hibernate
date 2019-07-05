package com.dsrc.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dsrc.dao.HibernateUtil;
import com.dsrc.exceptions.ProductException;
import com.dsrc.model.Customer;
import com.dsrc.model.Product;
import com.dsrc.model.Staff;
import com.dsrc.view.CustomerScreen;
import com.dsrc.view.ProductScreen;
import com.dsrc.view.StaffScreen;

public class DataValidator 
{
	public boolean validateCustomer(Customer customer) throws ProductException
	{
		 String email=customer.getEmail();
		 String num=String.valueOf(customer.getMobileno());
		 String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";             
		 String number="[7-9][0-9]{9}";
         Pattern pat = Pattern.compile(emailRegex);
         Pattern pat1 = Pattern.compile(number);
if(!pat.matcher(email).matches()){
	throw new ProductException("Invalid email!");
}
if(!pat1.matcher(num).matches()){
throw new ProductException("Invalid PhoneNO");
}
HibernateUtil hu=new HibernateUtil();
boolean res=hu.saveCustomer(customer);
		if(res)
		{
			System.out.println("Customer Added Successfully");
                       CustomerScreen cs=new CustomerScreen();
                       cs.showCustomerScreen();
		}
return res;
}
	public boolean updateCustomer(Customer customer) throws ProductException
	{
		 String email=customer.getEmail();
		 String num=String.valueOf(customer.getMobileno());
		 String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";             
		 String number="[7-9][0-9]{9}";
         Pattern pat = Pattern.compile(emailRegex);
         Pattern pat1 = Pattern.compile(number);
if(!pat.matcher(email).matches()){
	throw new ProductException("Invalid email!");
}
if(!pat1.matcher(num).matches()){
throw new ProductException("Invalid PhoneNO");
}
HibernateUtil hu=new HibernateUtil();
boolean res=hu.updateCustomer(customer);
		if(res)
		{
			System.out.println("Customer Record Updated..");
                       CustomerScreen cs=new CustomerScreen();
                       cs.showCustomerScreen();
		}
		return res;
	}
	public boolean deleteCustomer(Customer customer) throws ProductException
	{
		 HibernateUtil hu=new HibernateUtil();
			boolean res=hu.deleteCustomer(customer);
			return res;  
	}
	public boolean validateProduct(Product product) throws ProductException
	{
		HibernateUtil hu=new HibernateUtil();
		boolean res=hu.saveProduct(product);
		if(res)
		{
			System.out.println("Product Added Successfully");
                        ProductScreen p=new ProductScreen();
			p.showProductScreen();
		}
		return res;
	}
	
	public boolean updateProduct(Product product)
	{
		HibernateUtil hu=new HibernateUtil();
		boolean res=hu.updateProduct(product);
		try{
		if(res)
		{
			System.out.println("Product Updated Successfully");
			ProductScreen p=new ProductScreen();
			p.showProductScreen();
		}
		}
		catch(Exception e){
			System.out.println("INVALID ID");
		}
		return res;
		
	}
	public boolean deleteProduct(Product product) throws ProductException
	{
		HibernateUtil hu=new HibernateUtil();
		boolean res=hu.deleteProduct(product);
		return res;
	}
	public boolean validateStaff(Staff staff) throws ProductException
	{
		HibernateUtil hu=new HibernateUtil();
		boolean res=hu.saveStaff(staff);
		if(res)
		{
			System.out.println("Staff Added Successfully");
			StaffScreen s=new StaffScreen();
			s.showStaffScreen();
		}
		return res;
	}
	public boolean updateStaff(Staff staff) throws ProductException
	{
		HibernateUtil hu=new HibernateUtil();
		boolean res=hu.updateStaff(staff);
		try{
		if(res)
		{
			System.out.println("Staff Record Updated.."); 
			StaffScreen s=new StaffScreen();
			s.showStaffScreen();
		}
		}
		catch(Exception e){
			System.out.println("INVALID ID");
			StaffScreen s1=new StaffScreen();
			s1.showStaffScreen();
		}
		return res;
	}
	  public boolean deleteStaff(Staff staff) throws ProductException
	  {
		  HibernateUtil hu=new HibernateUtil();
			boolean res=hu.deleteStaff(staff);
			return res;  
	  }
}
