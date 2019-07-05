package com.dsrc.view;

import java.util.Scanner;

import com.dsrc.dao.HibernateUtil;
import com.dsrc.exceptions.ProductException;
import com.dsrc.model.Login;

public class LoginScreen {
	public int ShowloginScreen() throws ProductException {
	Scanner in=new Scanner(System.in);
	System.out.println("Enter LoginID:");
  String a=in.next();
  	System.out.println("Enter Password:");
  	String b=in.next();
  	Login l=new Login(a,b);
  	HibernateUtil h=new HibernateUtil();
  	h.checkLogin(l);
	return 0;
}
}
 