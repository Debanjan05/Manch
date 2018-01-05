/**
 * 
 */
package com.altimetrik.manch.usecase.api.service.impl;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.manch.usecase.api.bean.ErrorBean;
import com.altimetrik.manch.usecase.api.bean.LoginRequest;
import com.altimetrik.manch.usecase.api.bean.LoginResponseBean;
import com.altimetrik.manch.usecase.api.service.LoginService;
import com.altimetrik.manch.usecase.models.LoginDetails;
import com.altimetrik.manch.usecase.models.repository.LoginDetailsRepository;

/**
 * @author sghosh
 *
 */
@Service 
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDetailsRepository loginDetailsRepository;
	@Override
	public LoginResponseBean login(LoginRequest loginRequest) {
		LoginResponseBean responseBean=new LoginResponseBean();
		if(loginRequest!=null)
		{
			LoginDetails dbDetails=loginDetailsRepository.findAllByEmail(loginRequest.getEmail());
			if(dbDetails.getPassword().equals(loginRequest.getPassword())){
				responseBean.setSuccessMessage("Successfull login!!");
				responseBean.setLoginDetails(loginRequest);
			}
			else{
				ErrorBean errorBean=new ErrorBean();
				errorBean.setMessage("Invalid Password");
				errorBean.setErrorCode("forbidden");
				responseBean.setErrors(errorBean);
			}
		}
		else{
			ErrorBean errorBean=new ErrorBean();
			errorBean.setMessage("Invalid email");
			errorBean.setErrorCode("forbidden");
			responseBean.setErrors(errorBean);
		}
		System.out.println(new Date());
		return responseBean;
	}
	

}
