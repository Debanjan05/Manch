/**
 * 
 */
package com.altimetrik.manch.usecase.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.altimetrik.manch.usecase.api.service.RoutesService;
import com.altimetrik.manch.usecase.exception.NotFoundException;
import com.altimetrik.manch.usecase.models.ManchRoutes;

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
	public ResponseEntity<List<ManchRoutes>> getRoutes()

			throws NotFoundException {

		List<ManchRoutes> returnValue = routesService.getRoutes();
		if (!returnValue.isEmpty())
			return new ResponseEntity<List<ManchRoutes>>(returnValue, HttpStatus.OK);
		else
			return new ResponseEntity<List<ManchRoutes>>(returnValue, HttpStatus.BAD_REQUEST);
	}
	

}
