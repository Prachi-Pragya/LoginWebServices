package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.UserBean;
import com.example.service.UserService;

@Controller
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	public  @ResponseBody String loginControl()
	{
		return "Hello";
	}
	
	
	@RequestMapping("/user/{userId}/{password}")
	public @ResponseBody UserBean loginpage(@PathVariable("userId") String userId, @PathVariable("password")String pass)
	{
//		UserService us = new UserService();
		LOGGER.info("login method called..........");
		return userService.getUser(userId, pass);
	}
	
}
