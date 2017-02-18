package com.etf.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.etf.base.model.UserDetailBaseObject;

@Entity
@Table(name = "T_USER_DETAILS")
public class UserDetail extends UserDetailBaseObject {

	Map<String, Boolean> userPreferences = null;
	Map<String, Integer> preferInternalIdMap = null;

	String rowInOpenItemGrid = "";
	String rowInOpenActionGrid = "";
	String rowInOpenReviewGrid = "";

	public UserDetail() {
	}

	public UserDetail(String userEuid) {
		this.userEuid = userEuid;
	}

	@Transient
	public String getRowInOpenItemGrid() {
		return rowInOpenItemGrid;
	}

	public void setRowInOpenItemGrid(String rowInOpenItemGrid) {
		this.rowInOpenItemGrid = rowInOpenItemGrid;
	}

	@Transient
	public String getRowInOpenActionGrid() {
		return rowInOpenActionGrid;
	}

	public void setRowInOpenActionGrid(String rowInOpenActionGrid) {
		this.rowInOpenActionGrid = rowInOpenActionGrid;
	}

	@Transient
	public String getRowInOpenReviewGrid() {
		return rowInOpenReviewGrid;
	}

	public void setRowInOpenReviewGrid(String rowInOpenReviewGrid) {
		this.rowInOpenReviewGrid = rowInOpenReviewGrid;
	}

	@Transient
	public Map<String, Integer> getPreferInternalIdMap() {
		return preferInternalIdMap;
	}

	public void setPreferInternalIdMap(Map<String, Integer> preferInternalIdMap) {
		this.preferInternalIdMap = preferInternalIdMap;
	}

	@Transient
	public Map<String, Boolean> getUserPreferences() {
		return userPreferences;
	}

	public void setUserPreferences(Map<String, Boolean> userPreferences) {
		this.userPreferences = userPreferences;
	}

	@Id
	@Column(name = "user_uid")
	public String getUserEuid() {
		return userEuid;
	}
	public void setUserEuid(String userEuid) {
		this.userEuid = userEuid;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "location")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "organization")
	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	@Column(name = "address")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "UPDATED_BY")
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

	@Column(name = "phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
