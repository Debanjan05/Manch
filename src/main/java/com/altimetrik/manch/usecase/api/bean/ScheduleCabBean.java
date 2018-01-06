/**
 * 
 */
package com.altimetrik.manch.usecase.api.bean;

import java.util.Date;

/**
 * @author sghosh
 *
 */
public class ScheduleCabBean {
	private String email;
	private Long toRouteId;
	private Long fromRouteId;
	private Long travelDate;
	public Long getToRouteId() {
		return toRouteId;
	}
	public void setToRouteId(Long toRouteId) {
		this.toRouteId = toRouteId;
	}
	public Long getFromRouteId() {
		return fromRouteId;
	}
	public void setFromRouteId(Long fromRouteId) {
		this.fromRouteId = fromRouteId;
	}
	
	public Long getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Long travelDate) {
		this.travelDate = travelDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	

}
