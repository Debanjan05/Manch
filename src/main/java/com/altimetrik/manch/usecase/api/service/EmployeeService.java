package com.altimetrik.manch.usecase.api.service;

import javax.transaction.Transactional;

import com.altimetrik.manch.usecase.api.bean.EmployeeRequest;
import com.altimetrik.manch.usecase.models.EmployeeDetails;

@Transactional
public interface EmployeeService {

	public EmployeeDetails createProfile(EmployeeRequest employeeRequest);
}
