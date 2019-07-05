package com.dsrc.service;

import com.dsrc.exceptions.ProductException;
import com.dsrc.view.ProductScreen;

public class ProductController
{
		public int productManage() throws ProductException
		{
			ProductScreen ps=new ProductScreen();
			ps.showProductScreen();
			return 0;		
			}
}
