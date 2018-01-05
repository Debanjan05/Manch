/**
 * 
 */
package com.altimetrik.manch.usecase.models;

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
@Table(name="manch_routes")
public class ManchRoutes {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "time_padding_sec")
	private Integer timePaddingSec;
	@Column(name="longitude")
	private Double longitude;
	@Column(name="abbreviation")
	private String abbreviation;
	@Column(name="latitude")
	private Double latitude;
	@Column(name="state_name")
	private String stateName;
	@Column(name="is_garage")
	private Boolean isGarage;
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="is_stop")
	private Boolean isStop;
	@Column(name="zip_code")
	private Integer zipCode;
	@Column(name="name")
	private String name;
	@Column(name="status")
	private String status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getTimePaddingSec() {
		return timePaddingSec;
	}
	public void setTimePaddingSec(Integer timePaddingSec) {
		this.timePaddingSec = timePaddingSec;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public Boolean getIsGarage() {
		return isGarage;
	}
	public void setIsGarage(Boolean isGarage) {
		this.isGarage = isGarage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Boolean getIsStop() {
		return isStop;
	}
	public void setIsStop(Boolean isStop) {
		this.isStop = isStop;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	

}
