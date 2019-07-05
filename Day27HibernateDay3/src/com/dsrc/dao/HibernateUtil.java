package com.dsrc.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.dsrc.exceptions.ProductException;
import com.dsrc.model.Customer;
import com.dsrc.model.Login;
import com.dsrc.model.Product;
import com.dsrc.model.Staff;
import com.dsrc.view.CustomerScreen;
import com.dsrc.view.LoginScreen;
import com.dsrc.view.MenuScreen;
import com.dsrc.view.ProductScreen;
import com.dsrc.view.StaffScreen;

public class HibernateUtil 
{
	public boolean checkLogin(Login login) throws ProductException
	{
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tc=s.beginTransaction();
		List login1= s.createQuery("From Login").list();
		for(Iterator i=login1.iterator();i.hasNext();){
			Login l=(Login)i.next();{
			if(l.getLoginid().equals(login.getLoginid()) && l.getPassword().equals(login.getPassword())){
				MenuScreen m=new MenuScreen();
				m.showMenu();
			}
			}
		}
		System.out.println("Invalid User");
		LoginScreen l1=new LoginScreen();
		l1.ShowloginScreen();
		return true;
	}
	public boolean saveCustomer(Customer customer)
	{
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tc=s.beginTransaction();
		s.save(customer);
		tc.commit();
		return true;
	}
	public boolean updateCustomer(Customer customer)
	{
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tc=s.beginTransaction();
		s.update(customer);
		tc.commit();
		return true;
	}
	public boolean deleteCustomer(Customer customer) throws ProductException
	{
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session s=sf.openSession();
		try{
		Transaction tc=s.beginTransaction();
		Customer cust=(Customer) s.get(Customer.class,customer.getCustomerid());
		s.delete(cust);
		tc.commit();
		System.out.println("Staff Record Deleted..");
		CustomerScreen cs=new CustomerScreen();
		cs.showCustomerScreen();
		}
		catch(Exception e){
			System.out.println("Invalid Id!!!");
			CustomerScreen cs=new CustomerScreen();
			cs.showCustomerScreen();
		}
		return true;	
	}
	public boolean saveProduct(Product product)
	{
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
								Session s=sf.openSession();
								Transaction tc=s.beginTransaction();
								s.save(product);
								tc.commit();
								return true;
	}
	public boolean saveStaff(Staff staff)
	{
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tc=s.beginTransaction();
		s.save(staff);
		tc.commit();
		return true;
	}
	public boolean updateProduct(Product product)
	{

		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tc=s.beginTransaction();
		s.update(product);
		tc.commit();
		return true;
	}
	public boolean updateStaff(Staff staff)
	{
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tc=s.beginTransaction();
		s.update(staff);
		tc.commit();
		return true;
	}
	public boolean deleteProduct(Product product) throws ProductException
	{
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session s=sf.openSession();
		try{
		Transaction tc=s.beginTransaction();
		Product p=(Product) s.get(Product.class, product.getProductid());
		s.delete(p);
		tc.commit();
		System.out.println("Deleted Successfully");
		ProductScreen p1=new ProductScreen();
		p1.showProductScreen();
		}
		catch(Exception e){
			System.out.println("Invalid Id!!!");
			ProductScreen p=new ProductScreen();
			p.showProductScreen();
		}
		return true;
	} 
	public boolean deleteStaff(Staff staff) throws ProductException
	{
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session s=sf.openSession();
		try{
		Transaction tc=s.beginTransaction();
		Staff staff1=(Staff) s.get(Staff.class,staff.getStaffid());
		s.delete(staff1);
		tc.commit();
		System.out.println("Deleted Successfully");
		StaffScreen s1=new StaffScreen();
		s1.showStaffScreen();
		}
		catch(Exception e){
			System.out.println("Invalid Id!!!");
			StaffScreen s1=new StaffScreen();
			s1.showStaffScreen();
		}
		return true;	
	}
	public List<Product> selectAllProducts()
	{
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tc=s.beginTransaction();
		List product= s.createQuery("From Product").list();
		System.out.println("-----------------------------------------------------------------------------");
		
	    System.out.printf("%-20s %-20s %-20s","PRODUCT ID", "PRICE", "PRODUCT NAME");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------");
		for(Iterator i=product.iterator();i.hasNext();){
			Product p=(Product)i.next();
		    System.out.println();
		        System.out.format("%-20d %-20f %-20s",p.getProductid(),p.getPrice(),p.getProductname());
		        System.out.println();	
	}
	    System.out.println("-----------------------------------------------------------------------------");
		tc.commit();
		return product;
	}
	
	public List<Product> searchByID(int productid) throws ProductException
	{
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tc=s.beginTransaction();
         String hql1 = "FROM Product P WHERE P.productid=?";
		Query q = s.createQuery(hql1);
		q.setInteger(0, productid);
		List results = q.list();
		for(Iterator i=results.iterator();i.hasNext();){
	    Product p=(Product) i.next();
		System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("%-20s %-20s %-20s","PRODUCT ID", "PRICE", "PRODUCT NAME");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------");
		    System.out.println();
		        System.out.format("%-20d %-20f %20s",p.getProductid(),p.getPrice(),p.getProductname());
		        System.out.println();	
                tc.commit();
		}
	    System.out.println("-----------------------------------------------------------------------------");
		ProductScreen p=new ProductScreen();
		p.showProductScreen();
		return results;
	}
	public List<Product> searchByname(String name) throws ProductException
	{
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tc=s.beginTransaction();
        String hql1 = "FROM Product P WHERE P.productname=?";
		Query q = s.createQuery(hql1);
		q.setString(0, name);
		List results = q.list();
		for(Iterator i=results.iterator();i.hasNext();){
			 Product p=(Product) i.next();
		System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("%-20s %-20s %-20s","PRODUCT ID", "PRICE", "PRODUCT NAME");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------");
		    System.out.println();
		        System.out.format("%-20d %-20f %-20s",p.getProductid(),p.getPrice(),p.getProductname());
		        System.out.println();	
	    }
	    System.out.println("-----------------------------------------------------------------------------");
		ProductScreen p=new ProductScreen();
		p.showProductScreen();
		        tc.commit();
				return results;
	}

	public List<Product> searchByrange(int fromPrice,int toPrice) throws ProductException
	{
		SessionFactory sf=new AnnotationConfiguration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		Session s=sf.openSession();
		Transaction tc=s.beginTransaction();
        String hql3 = "FROM Product P WHERE price between ? and ? ";
		Query q3 = s.createQuery(hql3);
		q3.setInteger(0, fromPrice);
		q3.setInteger(1, toPrice);
		List results = q3.list();
		System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("%-20s %-20s %-20s","PRODUCT ID", "PRICE", "PRODUCT NAME");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------");
		for(Iterator i=results.iterator();i.hasNext();){
			 Product p=(Product) i.next();
		    System.out.println();
		        System.out.format("%-20d %-20f %-20s",p.getProductid(),p.getPrice(),p.getProductname());
		        System.out.println();	
	    }
	    System.out.println("-----------------------------------------------------------------------------");
		ProductScreen p=new ProductScreen();
		p.showProductScreen();
		        tc.commit();
				return results;
	}
}

