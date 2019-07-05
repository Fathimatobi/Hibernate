package com.dsrc.service;

import com.dsrc.exceptions.ProductException;
import com.dsrc.view.StaffScreen;

public class StaffController 
{
	public int productManage() throws ProductException
	{
		StaffScreen s=new StaffScreen();
		return s.showStaffScreen();
	}
}
