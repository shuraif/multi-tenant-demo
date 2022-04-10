package com.ms.multitenant.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms.multitenant.entity.model.UserDetail;
import com.ms.multitenant.entity.request.AuthRequest;
import com.ms.multitenant.entity.response.AuthResponse;
import com.ms.multitenant.exception.ApplicationException;
import com.ms.multitenant.repo.UserDetailsRepo;
import com.ms.multitenant.utils.ApiUtil;



@Service
public class UserManagementService {

	@Autowired
	UserDetailsRepo alienDetailsRepo;
	
	public ResponseEntity<AuthResponse> signupUser(AuthRequest signupRequest) throws ApplicationException {
		
		ResponseEntity<AuthResponse> entity = null;
		AuthResponse response=new AuthResponse();
		
		try {

			UserDetail userExist = alienDetailsRepo.findByPhoneHash(signupRequest.getPhoneHash());
			if (null == userExist) {

				UserDetail userDetails = new UserDetail();
				userDetails.setPasswordHash(ApiUtil.encrypt(signupRequest.getPassword()));
				userDetails.setCreatedOn(new Date());
				userDetails.setLastLogin(new Date());
				userDetails.setPhoneHash(signupRequest.getPhoneHash());
				userDetails = alienDetailsRepo.save(userDetails);
				
				response.setLastLogin(new Date());
				response.setCreatedOn(userDetails.getCreatedOn());
				response.setPhoneHash(userDetails.getPhoneHash());
				

				entity = new ResponseEntity<AuthResponse>(response, HttpStatus.OK);
				
			} else {
				throw new ApplicationException(HttpStatus.BAD_REQUEST,"Username or email alreary exist");
			}
		}catch (ApplicationException ae) {
			throw ae;
		}catch (Exception e) {
			
			throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR,"Something went wrong.Please try again after some time");
		}
		
		return entity;
	}

	public ResponseEntity<AuthResponse> signIn(AuthRequest signinRequest) throws Exception {
		
		ResponseEntity<AuthResponse> entity = null;
		AuthResponse response=new AuthResponse();
		try {
			
			UserDetail userDetails=alienDetailsRepo.findByPhoneHash(signinRequest.getPhoneHash());
					
			if(null!=userDetails) {
				if(userDetails.getPasswordHash().equals(ApiUtil.encrypt(signinRequest.getPassword()))) {
					
					response.setLastLogin(new Date());
					response.setCreatedOn(userDetails.getCreatedOn());
					response.setPhoneHash(userDetails.getPhoneHash());
					
					
					entity=new ResponseEntity<AuthResponse>(response, HttpStatus.OK);
					
					//for successfull login update last login time
					userDetails.setLastLogin(new Date());
					alienDetailsRepo.save(userDetails);
				}else {
			
					throw new ApplicationException(HttpStatus.BAD_REQUEST,"Username and password not match");
				}
				
			}else {

				throw new ApplicationException(HttpStatus.BAD_REQUEST,"User not found.Please signup before login");
			}
			
			
		}catch (ApplicationException ae) {
			throw ae;
		}
		catch (Exception e) {
			
			throw new ApplicationException(HttpStatus.INTERNAL_SERVER_ERROR,"Something went wrong.Please try again after some time");
		}

		return entity;
	}
	
}
