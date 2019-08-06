package com.sourcebits.eventHandling.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = true, name = "role_name")
	private String roleName;

	@Column(nullable = true, name = "created_date")
	private Date roleCreatedDate;

	@Column(nullable = true, name = "created_by")
	private int roleCreatedBy;

	@Column(nullable = true, name = "updated_date")
	private Date roleUpdatedDate;

	@Column(nullable = true, name = "updated_by")
	private Integer roleUpdatedBy;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getRoleCreatedDate() {
		return roleCreatedDate;
	}

	public void setRoleCreatedDate(Date roleCreatedDate) {
		this.roleCreatedDate = roleCreatedDate;
	}

	public int getRoleCreatedBy() {
		return roleCreatedBy;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + ", roleCreatedDate=" + roleCreatedDate + ", roleCreatedBy="
				+ roleCreatedBy + ", roleUpdatedDate=" + roleUpdatedDate + ", roleUpdatedBy=" + roleUpdatedBy + "]";
	}

	public void setRoleCreatedBy(int roleCreatedBy) {
		this.roleCreatedBy = roleCreatedBy;
	}

	public Date getRoleUpdatedDate() {
		return roleUpdatedDate;
	}

	public void setRoleUpdatedDate(Date roleUpdatedDate) {
		this.roleUpdatedDate = roleUpdatedDate;
	}

	public Integer getRoleUpdatedBy() {
		return roleUpdatedBy;
	}

	public void setRoleUpdatedBy(Integer roleUpdatedBy) {
		this.roleUpdatedBy = roleUpdatedBy;
	}
}