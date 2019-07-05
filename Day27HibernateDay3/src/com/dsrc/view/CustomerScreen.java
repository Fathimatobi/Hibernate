package com.dsrc.view;

import java.util.Scanner;

import com.dsrc.exceptions.ProductException;
import com.dsrc.model.Customer;
import com.dsrc.model.Staff;
import com.dsrc.service.DataValidator;

public class CustomerScreen 
{
	public int showCustomerScreen() throws ProductException
	{
		Scanner in=new Scanner(System.in);
		System.out.println("CUSTOMER MENU");
        System.out.println("1\t New Customer");
        System.out.println("2\t Edit Customer ");
        System.out.println("3\t Delete Customer");
        System.out.println("4\t Exit");
        System.out.println("Enter Your Choice:");
        int choice=in.nextInt();
        switch(choice){
        case 1:
        	System.out.println("Enter CustomerID:");
       	 int a=in.nextInt();
       	System.out.println("Enter Customer Name:");
       	String b=in.next();
       	System.out.println("Enter Email:");
       String c=in.next();
       	System.out.println("Enter Mobile:");
     long d=in.nextLong();
        	Customer c1=new Customer(a,b,c,d);
        	DataValidator d1=new DataValidator();
        	d1.validateCustomer(c1);
		break;
        case 2:
        	System.out.println("Enter CustomerID:");
          	 int x=in.nextInt(); 
          	System.out.println("Enter Customer Name:");
          	String y=in.next();
          	System.out.println("Enter Email:");
            String z=in.next();
            	System.out.println("Enter Mobile:");
            	long l=in.nextLong();
           	Customer c2=new Customer(x,y,z,l);
           	DataValidator d2=new DataValidator();
           	d2.updateCustomer(c2);
           break;
   		
        case 3:
        	System.out.println("Enter CustomerID:");
     	 int i=in.nextInt();
     	Customer c3=new Customer(i);
       	DataValidator d3=new DataValidator();
       d3.deleteCustomer(c3);
		break;
        case 4:
        	MenuScreen ms=new MenuScreen();
        	ms.showMenu();
	}
		return choice;
	}
}
