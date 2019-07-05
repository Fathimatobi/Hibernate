package com.dsrc.view;

import java.util.Scanner;

import com.dsrc.exceptions.ProductException;
import com.dsrc.model.Staff;
import com.dsrc.service.DataValidator;

public class StaffScreen 
{
	public int showStaffScreen() throws ProductException
	{
		Scanner in=new Scanner(System.in);
		System.out.println("STAFF MENU");
        System.out.println("1\t New Staff");
        System.out.println("2\t Edit Staff ");
        System.out.println("3\t Delete Staff");
        System.out.println("4\t Exit");
        System.out.println("Enter Your Choice:");
        int choice=in.nextInt();
        switch(choice){
        case 1:
        	System.out.println("Enter StaffID:");
       	 int a=in.nextInt();
       	System.out.println("Enter Staff Name:");
       	String b=in.next();
       	System.out.println("Enter Salary:");
       	float c=in.nextFloat();
        	Staff s=new Staff(a,b,c);
        	DataValidator d1=new DataValidator();
        	d1.validateStaff(s);
		break;
        case 2:
        	System.out.println("Enter StaffID:");
          	 int x=in.nextInt();
          	System.out.println("Enter Staff Name:");
          	String y=in.next();
          	System.out.println("Enter Salary:");
          	float z=in.nextFloat();
           	Staff s1=new Staff(x,y,z);
           	DataValidator d2=new DataValidator();
           d2.updateStaff(s1);
           break;
   		
        case 3:
        	System.out.println("Enter StaffID:");
     	 int i=in.nextInt();
     	Staff s2=new Staff(i);
       	DataValidator d3=new DataValidator();
       d3.deleteStaff(s2);
		break;
        case 4:
        	MenuScreen ms=new MenuScreen();
        	ms.showMenu();
	}
		return choice;
}
}
