/**
* @author  Jaya Prakash Manne
* @version 1.0
* @since   01-Nov-2019 
*/
package com.ais.jb.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ais.jb.common.Constants;
import com.ais.jb.common.URLConstants;
import com.ais.jb.dao.model.AuthCodeDetails;
import com.ais.jb.dao.model.UserDetails;
import com.ais.jb.model.Response;
import com.ais.jb.repository.AuthCodeRepository;
import com.ais.jb.repository.UserRepository;
import com.ais.jb.request.model.LoginRequest;
import com.ais.jb.request.model.LogoutRequest;
import com.ais.jb.response.model.LoginResponse;
import com.ais.jb.util.AuthCodeGenerator;
import com.ais.jb.util.PasswordEncy;

@RestController
@RequestMapping(URLConstants.Login.API_BASE)
public class LoginController extends BaseController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	AuthCodeRepository authCodeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	//=========================================================================
	
	@PostMapping(URLConstants.Login.LOGIN_USER)
	public ResponseEntity<Response> loginUser(@Valid @RequestBody LoginRequest loginRequest) {
		String logTag = "loginUser() ";
		LOGGER.info(logTag + "START of the method");
		AuthCodeDetails authCodeDetails = null;
		LoginResponse loginResponse = null;
		String message = null;
		
		try {
			// Getting the user with the userName and password
			List<UserDetails> users = userRepository.getUserByEmailAndPassword(loginRequest.getEmail(), PasswordEncy.getInstance().encrypt(loginRequest.getPassword()));
			
			if(users != null && !users.isEmpty()) {
				if(users.size() > 1) {
					//TODO: Need to throw and error as multiple users having same credentials
				} else {
					authCodeDetails = new AuthCodeDetails();
					authCodeDetails.setAuthCode(AuthCodeGenerator.getInstance().getGeneratedAuthCode());
					UserDetails userDetails = users.get(0);
					authCodeDetails.setUserDetails(userDetails);
					authCodeDetails.setLoginTime(new Date());
					authCodeDetails.setLogoutTime(new Date());
					authCodeDetails.setStatus(Constants.ACTIVE);
					authCodeDetails = authCodeRepository.save(authCodeDetails);
					
					long roleId = userDetails.getRoleDetails().getRoleId();
					if(roleId == Constants.EMPLOYER_ROLE) {
						// TODO: Need to have a new class to handle employer response with company name and other data
						
					} else {
						loginResponse = new LoginResponse();
						loginResponse.setAuthCode(authCodeDetails.getAuthCode());
						loginResponse.setFistName(userDetails.getFirstName());
						loginResponse.setLastName(userDetails.getLastName());
						loginResponse.setUserDetailsId(userDetails.getUserDetailsId());
						loginResponse.setRoleId(roleId);
					}
					message = "User Login Successful";
				}
			} else {
				message = "Invalid Credentials";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info(logTag + "END of the method");
		return new ResponseEntity<Response>(new Response(message, loginResponse), HttpStatus.OK);
	}
	
	//=========================================================================
	
	@PostMapping(URLConstants.Login.LOGOUT_USER)
	public ResponseEntity<Response> logoutUser(@Valid @RequestBody LogoutRequest logoutRequest) {
		String logTag = "logoutUser() ";
		LOGGER.info(logTag + "START of the method");
		String message = null;
		
		List<AuthCodeDetails> authCodes = authCodeRepository.getAuthCodeDetailsByAuthCode(logoutRequest.getAuthCode(), logoutRequest.getUserDetailsId());
		if(authCodes != null && !authCodes.isEmpty()) { 
			if(authCodes.size() > 1) {
				//TODO: Need to throw and error as multiple entries having same authCode
			} else {
				AuthCodeDetails authCodeDetails = authCodes.get(0);
				LOGGER.info(logTag + "AuthCode: " + authCodeDetails.getAuthCode());
				authCodeDetails.setLogoutTime(new Date());
				authCodeDetails.setStatus(Constants.INACTIVE);
				authCodeRepository.save(authCodeDetails);
				message = "Logout Successful";
			}
		} else {
			message = "Invalid AuthCode";
		}
		LOGGER.info(logTag + "END of the method");
		return new ResponseEntity<Response>(new Response(message, null), HttpStatus.OK);
	}
	
	//=========================================================================
}
