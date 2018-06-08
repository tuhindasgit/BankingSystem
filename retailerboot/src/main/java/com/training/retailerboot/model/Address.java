package com.training.retailerboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@Column(name = "street" ,length=100)
	private String street;
	@Column(name = "zipcode")
	private String zipCode;
	@Column(name = "city")
	private String city;
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @param street
	 * @param zipCode
	 * @param city
	 */
	public Address(String street, String zipCode, String city) {
		super();
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}
	/**
	 * 
	 */
	public Address() {
		super();
	}
	
}
