package com.altimetrik.manch.usecase.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manch_employee_details")
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_details_id")
	private Long empDetailsId;
	
	@Column(name="employee_id")
	private Integer employeeId;
	
	public Long getEmpDetailsId() {
		return empDetailsId;
	}

	public void setEmpDetailsId(Long empDetailsId) {
		this.empDetailsId = empDetailsId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Column(name="employee_name")
	private String  employeeName;
	
	@Column(name="emp_manager")
	private String empManager;

	@Column(name="emp_gender")
	private String empGender;
	
	@Column(name="emp_account")
	private String empAccount;
	
	@Column(name="emp_email_id")
	private String empEmailId;
	
	@Column(name="joined_date")
	private Date joinedDate;
	
	@Column(name="emp_shift")
	private String empShift;

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

	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [empDetailsId=" + empDetailsId + ", employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", empManager=" + empManager + ", empGender=" + empGender + ", empAccount="
				+ empAccount + ", empEmailId=" + empEmailId + ", joinedDate=" + joinedDate + ", empShift=" + empShift
				+ "]";
	}

	
	
}
