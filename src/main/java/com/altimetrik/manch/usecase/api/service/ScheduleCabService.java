/**
 * 
 */
package com.altimetrik.manch.usecase.api.service;

import javax.transaction.Transactional;

import com.altimetrik.manch.usecase.api.bean.ScheduleCabBean;

/**
 * @author sghosh
 *
 */
@Transactional
public interface ScheduleCabService {

	String scheduleCab(ScheduleCabBean scheduleRequest);
	
	
	

}
