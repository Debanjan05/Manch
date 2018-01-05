package com.altimetrik.manch.usecase.api.bean;

import java.util.Date;

public class EmployeeRequest {
	
	private Long empId;
	private String empManager;
	private String empGender;
	private String empAccount;
	private String empEmailId;
	private Date joinedDate;
	private String empShift;
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpManager() {
		return empManager;
	}
	public void setEmpManager(String empManager) {
		this.empManager = empManager;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public String getEmpAccount() {
		return empAccount;
	}
	public void setEmpAccount(String empAccount) {
		this.empAccount = empAccount;
	}
	public String getEmpEmailId() {
		return empEmailId;
	}
	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getEmpShift() {
		return empShift;
	}
	public void setEmpShift(String empShift) {
		this.empShift = empShift;
	}


}
