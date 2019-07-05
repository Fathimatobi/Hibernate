package com.dsrc.view;

import java.util.Scanner;

import com.dsrc.exceptions.ProductException;
import com.dsrc.service.CustomerController;
import com.dsrc.service.ProductController;
import com.dsrc.service.StaffController;

public class MenuScreen
{

	public int showMenu() throws ProductException {
			 Scanner in = new Scanner(System.in);
		       System.out.println("Select Your Choice");
		        System.out.println("1\t Product");
		        System.out.println("2\t Sales ");
		        System.out.println("3\t Staff");
		        System.out.println("4\t Customer");

		        System.out.println("Enter your Choice:");
		        int choice=in.nextInt();
		        switch (choice) {
		            case 1:
		            	ProductController pc = new ProductController();
		            	pc.productManage(); 
		            case 3:
		            	StaffController sc=new StaffController();
		            	sc.productManage();
		            case 4:
		            	CustomerController cc=new CustomerController();
		            	cc.customerManage();
		        }
				return choice;
		}
}
