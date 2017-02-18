package com.etf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.etf.base.model.UserRoleBaseObject;

@Entity
@Table(name = "T_USER_ROLE")
public class UserRole extends UserRoleBaseObject {

	public UserDetail userDetails;

	@Id
	@Column(name = "user_role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getInternalId() {
		return internalId;
	}

	public void setInternalId(int internalId) {
		this.internalId = internalId;
	}

	@Column(name = "role")
	@Length(max = 255, message = "Field Role can have 255 maximum characters")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "function")
	@Length(max = 255, message = "Field Function can have 255 maximum characters")
	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	@Column(name = "default_entry")
	@Length(max = 255, message = "Field Default Entry can have 255 maximum characters")
	public String getDefaultEntry() {
		return defaultEntry;
	}

	public void setDefaultEntry(String defaultEntry) {
		this.defaultEntry = defaultEntry;
	}

	@Column(name = "delegate")
	@Length(max = 255, message = "Field Delegate can have 255 maximum characters")
	public String getDelegate() {
		return delegate;
	}

	public void setDelegate(String delegate) {
		this.delegate = delegate;
	}

	@ManyToOne
	@JoinColumn(name = "USER_DETAIL__USER_UID")
	public UserDetail getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetail userDetails) {
		this.userDetails = userDetails;
	}

	/*
	 * @Column(name = "USER_DETAIL__ST_EDUID") public String getStEduid() {
	 * return stEduid; } public void setStEduid(String stEduid) { this.stEduid =
	 * stEduid; }
	 */
	@Column(name = "UPDATED_BY")
	@Length(max = 255, message = "Field Updated By can have 255 maximum characters")
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
