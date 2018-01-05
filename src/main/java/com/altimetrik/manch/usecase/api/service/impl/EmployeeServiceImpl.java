package com.altimetrik.manch.usecase.api.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.manch.usecase.api.bean.EmployeeRequest;
import com.altimetrik.manch.usecase.api.service.EmployeeService;
import com.altimetrik.manch.usecase.models.EmployeeDetails;
import com.altimetrik.manch.usecase.models.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDetails createProfile(EmployeeRequest employeeRequest) {
		EmployeeDetails target = new EmployeeDetails();
		BeanUtils.copyProperties(employeeRequest, target);
		EmployeeDetails emp = employeeRepository.save(target);
		return emp;
	}

}
