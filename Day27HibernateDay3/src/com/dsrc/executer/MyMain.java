package com.dsrc.executer;

import com.dsrc.exceptions.ProductException;
import com.dsrc.view.LoginScreen;
import com.dsrc.view.MenuScreen;

public class MyMain 
{
		public static void main(String[] args) throws ProductException 
		{
			LoginScreen l=new LoginScreen();
			l.ShowloginScreen();
		}
}
  