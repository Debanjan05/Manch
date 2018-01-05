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
	private String email;
	private String name;
	private String successMessage;
	public ErrorBean getErrors() {
		return errors;
	}
	public void setErrors(ErrorBean errors) {
		this.errors = errors;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	
}
