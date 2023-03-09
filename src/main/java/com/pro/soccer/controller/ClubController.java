package com.pro.soccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.soccer.model.Club;
import com.pro.soccer.service.ClubService;

@RestController
@RequestMapping(value="/club")
public class ClubController implements CrudController<Club, Integer>{
	@Autowired
	ClubService service;

	@Override
	@PostMapping("/add")
	public int add(@RequestBody Club model) {
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
	public int update(@RequestBody Club model) {
		// TODO Auto-generated method stub
		service.update(model);
		return 1;
	}

	@Override
	@GetMapping("/all")
	public List<Club> getAll() {
		// TODO Auto-generated method stub
		return service.getAll();
	}

	@Override
	@GetMapping("/get/{id}")
	public Club getById(@PathVariable("id") Integer id) {
		// TODO Auto-generated method stub
		return service.getById(id);
	}
	
	
	
}
