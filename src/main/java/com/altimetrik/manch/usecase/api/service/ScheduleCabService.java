/**
 * 
 */
package com.altimetrik.manch.usecase.api.service;

import java.util.List;

import javax.transaction.Transactional;

import com.altimetrik.manch.usecase.api.bean.ScheduleCabBean;
import com.altimetrik.manch.usecase.api.bean.ScheduleResponse;
import com.altimetrik.manch.usecase.models.EmployeeCabHistory;

/**
 * @author sghosh
 *
 */
@Transactional
public interface ScheduleCabService {

	ScheduleResponse scheduleCab(ScheduleCabBean scheduleRequest);
	
	List<EmployeeCabHistory> viewEmployeeCabHistory(Integer employeeId);
	

}
