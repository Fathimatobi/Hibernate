package com.dsrc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
		@Id
		@Column(name="product_id")
		private int productid;
		@Column(name="product_name")
		private String productname;
		@Column(name="price")
		private float price;
		public Product(int productid, String productname, float price) {
			this.productid=productid;
			this.productname=productname;
			this.price=price;
			}
		public Product(){
			
		}
		public Product(int id) {
			this.productid=id;
		}
		public Product(String name) {
			this.productname=name;
			}
		public Product(int fromprice, int toprice)
		{
			this.price=fromprice;
			this.price=toprice;
		}
		public void setProductid(int productid) {
			this.productid = productid;
		}
		public int getProductid() {
			return productid;
		}
		public String getProductname() {
			return productname;
		}
		public void setProductname(String productname) {
			this.productname = productname;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
	}