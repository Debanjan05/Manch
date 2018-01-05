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
import com.altimetrik.manch.usecase.models.EmployeeDetails;
import com.altimetrik.manch.usecase.models.LoginDetails;
import com.altimetrik.manch.usecase.models.repository.EmployeeRepository;
import com.altimetrik.manch.usecase.models.repository.LoginDetailsRepository;

/**
 * @author sghosh
 *
 */
@Service 
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDetailsRepository loginDetailsRepository;
	@Autowired
	private EmployeeRepository empRepo;
	@Override
	public LoginResponseBean login(LoginRequest loginRequest) {
		LoginResponseBean responseBean=new LoginResponseBean();
		EmployeeDetails employeeDetails=empRepo.findAllByEmpEmailId(loginRequest.getEmail());
		if(loginRequest!=null && employeeDetails!=null)
		{
			LoginDetails dbDetails=loginDetailsRepository.findAllByEmail(loginRequest.getEmail());
			if(dbDetails.getPassword().equals(loginRequest.getPassword())){
				responseBean.setSuccessMessage("Successfull login!!");
				responseBean.setEmail(employeeDetails.getEmpEmailId());
				responseBean.setName(employeeDetails.getEmployeeName());
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
