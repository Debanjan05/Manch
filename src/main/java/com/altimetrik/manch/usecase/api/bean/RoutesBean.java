/**
 * 
 */
package com.altimetrik.manch.usecase.api.bean;

import java.util.List;

import com.altimetrik.manch.usecase.models.ManchRoutes;

/**
 * @author sghosh
 *
 */
public class RoutesBean {
	private List<ManchRoutes> routesList;
	private ErrorBean errors;
	public List<ManchRoutes> getRoutesList() {
		return routesList;
	}
	public void setRoutesList(List<ManchRoutes> routesList) {
		this.routesList = routesList;
	}
	public ErrorBean getErrors() {
		return errors;
	}
	public void setErrors(ErrorBean errors) {
		this.errors = errors;
	}
	

}
