package com.myproject.Sales.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderlist")
public class OrderList {
	
	@Id
	private String oid;
	
	private String totalprice;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cid")
	private Customer customer;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pid")
	private Product product;
	
	public OrderList() {
		
	}
	
	public OrderList(String oid2, String totalPrice2, Customer customer2, Product product2) {
		this.setOid(oid2);
		this.setCustomer(customer2);
		this.setProduct(product2);
		this.setTotalprice(totalPrice2);
	}


	public String getOid() {
		return oid;
	}


	public void setOid(String oid) {
		this.oid = oid;
	}


	public String getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	
	
}
