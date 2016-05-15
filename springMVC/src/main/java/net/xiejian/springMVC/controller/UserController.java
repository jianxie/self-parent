package net.xiejian.springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.xiejian.springMVC.domain.User;
import net.xiejian.springMVC.service.IUserService;

@Controller
@RequestMapping("/article")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private IUserService		userService;
	
	@RequestMapping("/user")
	@ResponseBody
	public User getUserName(){
		String name = "summer";
		return userService.getUserByName(name);
	}
	
	@RequestMapping("/name")
	@ResponseBody
	public String getName(){
		return "summer";
	}
}
