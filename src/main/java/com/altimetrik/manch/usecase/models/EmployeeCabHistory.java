/**
 * 
 */
package com.altimetrik.manch.usecase.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author sghosh
 *
 */
@Entity
@Table(name="employee_cab_history")
public class EmployeeCabHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cab_history_id")
	private Long cabHistoryId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employee_details_id")
	private EmployeeDetails employeeDetails;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "to_route_id")
	private ManchRoutes toRouoteId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "from_route_id")
	private ManchRoutes fromRouoteId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cab_details_id")
	private ManchCabDetails manchCabDetails;
	@Column(name="travel_date")
	private Date travelDate;
	@Column(name="start_time")
	private Date startTime;
	@Column(name="end_time")
	private Date endTime;
	@Column(name="travel_status")
	private String travelStatus;
	public Long getCabHistoryId() {
		return cabHistoryId;
	}
	public void setCabHistoryId(Long cabHistoryId) {
		this.cabHistoryId = cabHistoryId;
	}
	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}
	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	public ManchRoutes getToRouoteId() {
		return toRouoteId;
	}
	public void setToRouoteId(ManchRoutes toRouoteId) {
		this.toRouoteId = toRouoteId;
	}
	public ManchRoutes getFromRouoteId() {
		return fromRouoteId;
	}
	public void setFromRouoteId(ManchRoutes fromRouoteId) {
		this.fromRouoteId = fromRouoteId;
	}
	public ManchCabDetails getManchCabDetails() {
		return manchCabDetails;
	}
	public void setManchCabDetails(ManchCabDetails manchCabDetails) {
		this.manchCabDetails = manchCabDetails;
	}
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getTravelStatus() {
		return travelStatus;
	}
	public void setTravelStatus(String travelStatus) {
		this.travelStatus = travelStatus;
	}
	
	
	
	
	

}
