package com.pro.soccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.soccer.model.Coach;
import com.pro.soccer.model.Player;
import com.pro.soccer.model.Users;
import com.pro.soccer.service.CoachService;
import com.pro.soccer.service.PlayerService;
import com.pro.soccer.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController implements CrudController<Users, String>{
	
	
	@Autowired
	public UserService usersService;
	
	@Autowired
	public PlayerService playerService;
	
	@Autowired
	public CoachService coachService;

	@Override
	@PostMapping(value = "/add", consumes = { "application/json" })
	@ResponseBody
	public int add(@RequestBody Users user) {
		try {
			usersService.add(user);
			String roles = user.getRoles();
			if(roles.equalsIgnoreCase("player")) {
				Player p = new Player();
				p.setUser(user);
				playerService.add(p);
				System.out.println("in");
			}else if(roles.equalsIgnoreCase("coach")) {
				Coach c = new Coach();
				c.setUser(user);
				coachService.add(c);
			}
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	@GetMapping("/delete/{id}")
	@ResponseBody
	public int delete(@PathVariable String id) {
		// TODO Auto-generated method stub
		String res = usersService.delete(id);
		if (res.equalsIgnoreCase("Email Not Found")) {
			return 0;
		}
		return 1;
	}

	@Override
	public int update(Users model) {
		usersService.update(model);
		return 1;
	}

	@Override
	@GetMapping("/all")
	@ResponseBody
	public List<Users> getAll() {
		return usersService.getAll();
	}

	@Override
	@GetMapping("/get/{id}")
	@ResponseBody
	public Users getById(@PathVariable String id) {
		// TODO Auto-generated method stub
		return usersService.getById(id);
	}
	
	@PostMapping("/login")
	@ResponseBody
	public Object login(@RequestBody Users user) {
		Users dbUser = usersService.getById(user.getEmail());
		if(dbUser == null)
			return null;
		if(dbUser.getPassword().equals(user.getPassword())) {
			if(dbUser.getRoles().equalsIgnoreCase("PLAYER")) {
				Player player = playerService.getByUser(dbUser);
				if(player == null)
					return null;
				return player;
			}else if(dbUser.getRoles().equalsIgnoreCase("COACH")) {
				Coach coach = coachService.getByUser(dbUser);
				if(coach == null)
					return null;
				return coach;
			}
			return dbUser;
		}else {
			return null;
		}
	}
}
