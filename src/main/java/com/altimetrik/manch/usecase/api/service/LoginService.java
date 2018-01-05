/**
 * 
 */
package com.altimetrik.manch.usecase.api.service;

import javax.transaction.Transactional;

import com.altimetrik.manch.usecase.api.bean.LoginRequest;
import com.altimetrik.manch.usecase.api.bean.LoginResponseBean;

/**
 * @author sghosh
 *
 */
@Transactional
public interface LoginService {

	LoginResponseBean login(LoginRequest loginRequest);

}
