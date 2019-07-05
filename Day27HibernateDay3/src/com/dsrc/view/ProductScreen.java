package com.dsrc.view;

import java.util.Scanner;

import com.dsrc.dao.HibernateUtil;
import com.dsrc.exceptions.ProductException;
import com.dsrc.model.Product;
import com.dsrc.service.DataValidator;

public class ProductScreen 
{
		public int showProductScreen() throws ProductException
		{
			Scanner in = new Scanner(System.in);
		       System.out.println("PRODUCT MENU");
		        System.out.println("1\t New Product");
		        System.out.println("2\t Edit Product ");
		        System.out.println("3\t Delete Product");
		        System.out.println("4\t List Product");
		        System.out.println("5\t Search Product");
		        System.out.println("6\t Exit\t");

		        System.out.println("Enter Your Choice:");
		        int choice=in.nextInt();
		        switch(choice){
		        case 1:
	            	System.out.println("Enter ProductID:");
	            	 int a=in.nextInt();
	            	System.out.println("Enter ProductName:");
	            	String b=in.next();
	            	System.out.println("Enter ProductPrice:");
	            	float c=in.nextFloat();
	       
			 Product p1=new Product(a,b,c);
	        DataValidator dv1=new DataValidator();
	        dv1.validateProduct(p1);
	        break;
		        case 2:
	            	System.out.println("Enter ProductID:");
	            	 int x=in.nextInt();
	            	System.out.println("Enter ProductName:");
	            	String y=in.next();
	            	System.out.println("Enter ProductPrice:");
	            	float z=in.nextFloat();
	       
			 Product p2=new Product(x,y,z);
	        DataValidator dv2=new DataValidator();
	        dv2.updateProduct(p2);
			break;
		        case 3:
		            	System.out.println("Enter ProductID:");
		            	 int i=in.nextInt();
		       
				 Product p3=new Product(i);
		        DataValidator dv3=new DataValidator();
		        dv3.deleteProduct(p3);
		        break;
		        case 4:
		        	HibernateUtil h1=new HibernateUtil();
		        	h1.selectAllProducts();
		        	break;
		        case 5:
		        	System.out.println("Enter the Search Criteria");
		        	 System.out.println("1\t By ProductID");
				        System.out.println("2\t By Name ");
				        System.out.println("3\t By Price Range");
				        System.out.println("Enter Choice:");
				        int choice1=in.nextInt();
				        switch(choice1){
				        case 1:
				        	System.out.println("Enter ProductID:");
			            	 int id=in.nextInt();
				        	HibernateUtil h2=new HibernateUtil();
				        	h2.searchByID(id);
				        	break;
				        case 2:
				        	System.out.println("Enter ProductName:");
			            	 String name=in.next();
							 Product p4=new Product(name);
				        	HibernateUtil h3=new HibernateUtil();
				        	h3.searchByname(name);
				        	break;
				        case 3:
				        	System.out.println("Enter From Price:");
			            	 int fromprice=in.nextInt();
			            	 System.out.println("Enter To Price");
			            	 int toprice=in.nextInt();
				        	HibernateUtil h4=new HibernateUtil();
				        	h4.searchByrange(fromprice,toprice);
				        	break;
				        }
				        case 6:
				        	MenuScreen m=new MenuScreen();
				        	m.showMenu();
		}
				return choice;
}
}
