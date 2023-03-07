package com.pro.soccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.soccer.model.Coach;
import com.pro.soccer.service.CoachService;

@RestController
@RequestMapping(value="/coach")
public class CoachController implements CrudController<Coach, Integer>{
	@Autowired
	CoachService service;

	@Override
	@PostMapping("/add")
	public int add(@RequestBody Coach model) {
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
	public int update(@RequestBody Coach model) {
		// TODO Auto-generated method stub
		service.update(model);
		return 1;
	}

	@Override
	@GetMapping("/all")
	public List<Coach> getAll() {
		// TODO Auto-generated method stub
		return service.getAll();
	}

	@Override
	@GetMapping("/get/{id}")
	public Coach getById(@PathVariable("id") Integer id) {
		// TODO Auto-generated method stub
		return service.getById(id);
	}
	
	
}
