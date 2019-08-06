package com.sourcebits.eventHandling.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "emp_id")
	private int emp_id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "is_logged_in")
	private boolean isLoggedIn;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

	@Column(nullable = true, name = "created_date")
	private Date userCreatedDate;

	@Column(nullable = true, name = "created_by")
	private int userCreatedBy;

	@Column(nullable = true, name = "updated_date")
	private Date userUpdatedDate;

	@Column(nullable = true, name = "updated_by")
	private Integer userUpdatedBy;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Date getUserCreatedDate() {
		return userCreatedDate;
	}

	public void setUserCreatedDate(Date userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}

	public int getUserCreatedBy() {
		return userCreatedBy;
	}

	public void setUserCreatedBy(int userCreatedBy) {
		this.userCreatedBy = userCreatedBy;
	}

	public Date getUserUpdatedDate() {
		return userUpdatedDate;
	}

	public void setUserUpdatedDate(Date userUpdatedDate) {
		this.userUpdatedDate = userUpdatedDate;
	}

	public Integer getUserUpdatedBy() {
		return userUpdatedBy;
	}

	public void setUserUpdatedBy(Integer userUpdatedBy) {
		this.userUpdatedBy = userUpdatedBy;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}