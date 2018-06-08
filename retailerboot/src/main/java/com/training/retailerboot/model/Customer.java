package com.training.retailerboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.retailerboot.annotation.AnnotationMy;

@AnnotationMy(name="tuhin")
@Entity
@Table(name = "customer")
public class Customer {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "customer_Id")
	private Integer customer_Id;
	@Id
	@Column(name = "customer_name" ,length=100)
	private String customer_name;
	@Column(name = "customer_address")
	private String customer_address;
	/**
	 * @param customer_Id
	 * @param customer_name
	 * @param customer_address
	 */
	public Customer(Integer customer_Id, String customer_name, String customer_address) {
		super();
		this.customer_Id = customer_Id;
		this.customer_name = customer_name;
		this.customer_address = customer_address;
	}
	/**
	 * 
	 */
	public Customer() {
		super();
	}
	/**
	 * @return the customer_Id
	 */
	public Integer getCustomer_Id() {
		return customer_Id;
	}
	/**
	 * @param customer_Id the customer_Id to set
	 */
	public void setCustomer_Id(Integer customer_Id) {
		this.customer_Id = customer_Id;
	}
	/**
	 * @return the customer_name
	 */
	public String getCustomer_name() {
		return customer_name;
	}
	/**
	 * @param customer_name the customer_name to set
	 */
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	/**
	 * @return the customer_address
	 */
	public String getCustomer_address() {
		return customer_address;
	}
	/**
	 * @param customer_address the customer_address to set
	 */
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	@Override
	public String toString() {
		return "Customer [customer_Id=" + customer_Id + ", customer_name=" + customer_name + ", customer_address="
				+ customer_address + "]";
	}

}
