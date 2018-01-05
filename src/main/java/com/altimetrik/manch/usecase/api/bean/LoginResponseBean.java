/**
 * 
 */
package com.altimetrik.manch.usecase.api.bean;

/**
 * @author sghosh
 *
 */
public class LoginResponseBean {
	private ErrorBean errors;
	private LoginRequest loginDetails;
	private String successMessage;

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public LoginRequest getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginRequest loginDetails) {
		this.loginDetails = loginDetails;
	}

	public ErrorBean getErrors() {
		return errors;
	}

	public void setErrors(ErrorBean errors) {
		this.errors = errors;
	}

}
