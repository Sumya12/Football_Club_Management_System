package com.pro.soccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.soccer.model.Users;
import com.pro.soccer.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	
	@Autowired
	public UserService usersService;

	@GetMapping("/all")
	@ResponseBody
	public List<Users> allUsers() {
		return usersService.getAll();
	}

	@PostMapping(value = "/add", consumes = { "application/json" })
	@ResponseBody
	public int addUser(@RequestBody Users user) { // 1->successful | -1 -> unsuccessful
		try {
			usersService.add(user);
			return 1;
		}catch(Exception e) {
			return -1;
		}
		
	}
}
