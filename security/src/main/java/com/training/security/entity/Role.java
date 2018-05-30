package com.training.security.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String user_roles;
	/**
	 * @param id
	 * @param user_roles
	 */
	public Role(int id, String user_roles) {
		super();
		this.id = id;
		this.user_roles = user_roles;
	}
	/**
	 * 
	 */
	public Role() {
		super();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the user_roles
	 */
	public String getUser_roles() {
		return user_roles;
	}
	/**
	 * @param user_roles the user_roles to set
	 */
	public void setUser_roles(String user_roles) {
		this.user_roles = user_roles;
	}
	
	
}
