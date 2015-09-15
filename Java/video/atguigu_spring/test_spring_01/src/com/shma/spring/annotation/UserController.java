package com.shma.spring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shma.spring.annotation.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;
	
	public void save() {
		System.out.println("Controller save...");
		userService.save();
	}
}
