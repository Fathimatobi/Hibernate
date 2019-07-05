package com.dsrc.service;

import com.dsrc.exceptions.ProductException;
import com.dsrc.view.CustomerScreen;

public class CustomerController {
	
	public int customerManage() throws ProductException
	{
		CustomerScreen cs=new CustomerScreen();
		return cs.showCustomerScreen();
	}
}
