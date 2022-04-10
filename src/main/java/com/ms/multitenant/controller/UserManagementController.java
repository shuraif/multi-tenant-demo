package com.ms.multitenant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.multitenant.entity.request.AuthRequest;
import com.ms.multitenant.entity.response.AuthResponse;
import com.ms.multitenant.exception.ApplicationException;
import com.ms.multitenant.service.UserManagementService;



@RestController
@RequestMapping("/multitenant")
public class UserManagementController {

	@Autowired
	UserManagementService userService;

	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> signUp(HttpServletRequest httpRequest, @RequestBody AuthRequest signupRequest)
			throws ApplicationException{

		return userService.signupUser(signupRequest);
	}

	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> signIn(HttpServletRequest request, @RequestBody AuthRequest signinRequest)
			throws Exception {

		return userService.signIn(signinRequest);
	}

}
