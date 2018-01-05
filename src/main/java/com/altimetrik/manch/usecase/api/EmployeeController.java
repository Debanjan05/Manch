package com.altimetrik.manch.usecase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.altimetrik.manch.usecase.api.bean.EmployeeRequest;
import com.altimetrik.manch.usecase.api.service.EmployeeService;
import com.altimetrik.manch.usecase.exception.NotFoundException;
import com.altimetrik.manch.usecase.models.EmployeeDetails;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/createProfile", produces = { "application/json" }, consumes = {
	"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<String> createProfile(@RequestBody EmployeeRequest employeeRequest)throws NotFoundException{
		
		EmployeeDetails response = employeeService.createProfile(employeeRequest);
		if(response != null){
			return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("FAILURE", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
