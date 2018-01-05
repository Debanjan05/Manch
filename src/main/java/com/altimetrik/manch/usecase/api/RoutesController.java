/**
 * 
 */
package com.altimetrik.manch.usecase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.altimetrik.manch.usecase.api.bean.RoutesBean;
import com.altimetrik.manch.usecase.api.service.RoutesService;
import com.altimetrik.manch.usecase.exception.NotFoundException;

/**
 * @author sghosh
 *
 */
@Controller
@RequestMapping(value = "/routes")
public class RoutesController {
	@Autowired
	private RoutesService routesService;
	@RequestMapping(value = "/getRoutes", produces = { "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<RoutesBean> getRoutes()

			throws NotFoundException {

		RoutesBean returnValue = routesService.getRoutes();
		if (returnValue.getErrors() == null)
			return new ResponseEntity<RoutesBean>(returnValue, HttpStatus.OK);
		else
			return new ResponseEntity<RoutesBean>(returnValue, HttpStatus.BAD_REQUEST);
	}
	

}
