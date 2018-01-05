package com.altimetrik.manch.usecase.api.service;

import javax.transaction.Transactional;

import com.altimetrik.manch.usecase.api.bean.RoutesBean;

/**
 * 
 * @author sghosh
 *
 */
@Transactional
public interface RoutesService {

	RoutesBean getRoutes();
	

}
