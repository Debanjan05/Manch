/**
 * 
 */
package com.altimetrik.manch.usecase.api.service;

import javax.transaction.Transactional;

import com.altimetrik.manch.usecase.api.bean.ScheduleCabBean;
import com.altimetrik.manch.usecase.api.bean.ScheduleResponse;

/**
 * @author sghosh
 *
 */
@Transactional
public interface ScheduleCabService {

	ScheduleResponse scheduleCab(ScheduleCabBean scheduleRequest);
	
	
	

}
