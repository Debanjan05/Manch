/**
 * 
 */
package com.altimetrik.manch.usecase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.altimetrik.manch.usecase.api.bean.LoginRequest;
import com.altimetrik.manch.usecase.api.bean.LoginResponseBean;
import com.altimetrik.manch.usecase.api.service.LoginService;
import com.altimetrik.manch.usecase.exception.NotFoundException;

/**
 * @author sghosh
 *
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	@RequestMapping(value = "/userLogin", produces = { "application/json" }, consumes = {
	"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<LoginResponseBean> login(
			@RequestBody LoginRequest loginRequest) throws NotFoundException {

		LoginResponseBean returnValue = loginService.login(loginRequest);
		if (returnValue.getErrors() == null)
			return new ResponseEntity<LoginResponseBean>(returnValue, HttpStatus.OK);
		else
			return new ResponseEntity<LoginResponseBean>(returnValue, HttpStatus.BAD_REQUEST);
	}


}
