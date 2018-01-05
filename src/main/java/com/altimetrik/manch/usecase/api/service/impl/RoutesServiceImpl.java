/**
 * 
 */
package com.altimetrik.manch.usecase.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.altimetrik.manch.usecase.api.service.RoutesService;
import com.altimetrik.manch.usecase.models.ManchRoutes;
import com.altimetrik.manch.usecase.models.repository.ManchRoutesRepository;

/**
 * @author sghosh
 *
 */
@Service
public class RoutesServiceImpl implements RoutesService{
	@Autowired
	private ManchRoutesRepository manchRoutesRepository;
	@Override
	public List<ManchRoutes>  getRoutes() {
		List<ManchRoutes> routeList=manchRoutesRepository.findAll();
		return routeList;
	}
	

}
