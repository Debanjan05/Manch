/**
 * 
 */
package com.altimetrik.manch.usecase.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.altimetrik.manch.usecase.api.bean.ScheduleCabBean;
import com.altimetrik.manch.usecase.api.service.ScheduleCabService;
import com.altimetrik.manch.usecase.exception.NotFoundException;
import com.altimetrik.manch.usecase.models.EmployeeCabHistory;

/**
 * @author sghosh
 *
 */
@Controller
@RequestMapping(value = "/cab")
public class ScheduleCabController {
	@Autowired
	private ScheduleCabService cabService;
	@RequestMapping(value = "/scheduleCab", produces = { "application/json" }, consumes = {
	"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<String> scheduleCab(
			@RequestBody ScheduleCabBean scheduleRequest) throws NotFoundException {

		String returnValue = cabService.scheduleCab(scheduleRequest);
		if (returnValue!= null)
			return new ResponseEntity<String>(returnValue, HttpStatus.OK);
		else
			return new ResponseEntity<String>(returnValue, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/viewHistory/{employeeId}", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeCabHistory>> viewEmployeeCabHistory(@PathVariable("employeeId") Integer employeeId){
		
		List<EmployeeCabHistory> empCabHistoryList = cabService.viewEmployeeCabHistory(employeeId);
		if(empCabHistoryList.isEmpty()){
			return new ResponseEntity<List<EmployeeCabHistory>>(empCabHistoryList, HttpStatus.INTERNAL_SERVER_ERROR);
		}else
		return new ResponseEntity<List<EmployeeCabHistory>>(empCabHistoryList, HttpStatus.OK);
	}

}
