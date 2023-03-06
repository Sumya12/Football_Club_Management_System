package com.pro.soccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pro.soccer.model.Player;
import com.pro.soccer.service.PlayerService;

@Controller
@RequestMapping(value="/player")
public class PlayerController implements CrudController<Player, Integer>{
	@Autowired
	PlayerService service;

	@Override
	@PostMapping("/add")
	public int add(@RequestBody Player model) {
		// TODO Auto-generated method stub
		service.add(model);
		return 1;
	}

	@Override
	@GetMapping("/delete/{id}")
	public int delete(@PathVariable("id") Integer id) {
		// TODO Auto-generated method stub
		service.delete(id);
		return 1;
	}

	@Override
	@PostMapping("/update")
	public int update(@RequestBody Player model) {
		// TODO Auto-generated method stub
		service.update(model);
		return 1;
	}

	@Override
	@GetMapping("/all")
	public List<Player> getAll() {
		// TODO Auto-generated method stub
		return service.getAll();
	}

	@Override
	@GetMapping("/get/{id}")
	public Player getById(@PathVariable("id") Integer id) {
		// TODO Auto-generated method stub
		return service.getById(id);
	}
	
	
}
