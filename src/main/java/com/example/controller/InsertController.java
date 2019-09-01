package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserBean;
import com.example.service.UserInsertService;

@RestController
public class InsertController {
	
	@Autowired
	private UserInsertService userInsertService;
	
	@RequestMapping(value ="user", method=RequestMethod.POST)
	public ResponseEntity<String> insertData(@RequestBody UserBean userBean) {
		
		userInsertService.insertUser(userBean);
		
		return new ResponseEntity<String>("Created",HttpStatus.OK);
		
	}

}
