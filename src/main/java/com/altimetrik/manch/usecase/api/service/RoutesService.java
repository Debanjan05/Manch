package com.altimetrik.manch.usecase.api.service;

import java.util.List;

import javax.transaction.Transactional;

import com.altimetrik.manch.usecase.api.bean.RoutesBean;
import com.altimetrik.manch.usecase.models.ManchRoutes;

/**
 * 
 * @author sghosh
 *
 */
@Transactional
public interface RoutesService {

	List<ManchRoutes> getRoutes();
	

}
