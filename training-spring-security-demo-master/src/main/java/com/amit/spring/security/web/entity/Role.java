package com.amit.spring.security.web.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")

public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private int id;
	private String role;
	
	 @ManyToMany(mappedBy = "roles")
	    private Collection<User> users;

	 @ManyToMany
	 @JoinTable( name = "roles_privileges", 
	 			joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), 
	     		inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
	 private Collection<Privilege> privileges; 
 
 
	public Role(String role) {
		super();
		this.role = role;
	}

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
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the users
	 */
	public Collection<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	/**
	 * @return the privileges
	 */
	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	/**
	 * @param privileges the privileges to set
	 */
	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}
	
}
