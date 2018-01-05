/**
 * 
 */
package com.altimetrik.manch.usecase.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sghosh
 *
 */
@Entity
@Table(name="manch_cab_details")
public class ManchCabDetails {
	@Id
	@Column(name = "cab_details_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cabDetailsId;
	@Column(name="cab_no")
	private String cabNo;
	@Column(name="cab_seats")
	private Integer cabSeats;
	@Column(name="vender_contact")
	private Long venderContact;
	@Column(name="driver_name")
	private String driverName;
	@Column(name="driver_contact")
	private Long driverContact;
	@Column(name="cab_availablity")
	private Boolean cabAvailablity;
	@Column(name="cab_start_time")
	private String cabStartTime;
	@Column(name="cab_end_time")
	private String cabEndTime;
	@Column(name="current_status")
	private String currentStatus;
	public Long getCabDetailsId() {
		return cabDetailsId;
	}
	public void setCabDetailsId(Long cabDetailsId) {
		this.cabDetailsId = cabDetailsId;
	}
	public String getCabNo() {
		return cabNo;
	}
	public void setCabNo(String cabNo) {
		this.cabNo = cabNo;
	}
	public Integer getCabSeats() {
		return cabSeats;
	}
	public void setCabSeats(Integer cabSeats) {
		this.cabSeats = cabSeats;
	}
	public Long getVenderContact() {
		return venderContact;
	}
	public void setVenderContact(Long venderContact) {
		this.venderContact = venderContact;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public Long getDriverContact() {
		return driverContact;
	}
	public void setDriverContact(Long driverContact) {
		this.driverContact = driverContact;
	}
	
	public Boolean getCabAvailablity() {
		return cabAvailablity;
	}
	public void setCabAvailablity(Boolean cabAvailablity) {
		this.cabAvailablity = cabAvailablity;
	}
	
	public String getCabStartTime() {
		return cabStartTime;
	}
	public void setCabStartTime(String cabStartTime) {
		this.cabStartTime = cabStartTime;
	}
	public String getCabEndTime() {
		return cabEndTime;
	}
	public void setCabEndTime(String cabEndTime) {
		this.cabEndTime = cabEndTime;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	
	
	

}
