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
import com.pro.soccer.model.PersonalTrainingRequest;
import com.pro.soccer.model.TrainingGroup;
import com.pro.soccer.service.CoachService;
import com.pro.soccer.service.PersonalTrainingService;

@RestController
@RequestMapping(value="/coach")
public class CoachController implements CrudController<Coach, Integer>{
	@Autowired
	CoachService service;
	
	@Autowired
	PersonalTrainingService requestService;

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
	
	@GetMapping("/getAlTrainingGroup/{coachid}")
	public List<TrainingGroup> getAlTrainingGroup(@PathVariable("coachid") Integer id) {
		Coach coach = service.getById(id);
		if(coach == null) {
			return null;
		}
		return coach.getGroup();
	}
	
	@GetMapping("/getAllPersonalTrainee/{coachid}")
	public List<PersonalTrainingRequest> getAllPersonalTrainee(@PathVariable("coachid") Integer id) {
		Coach coach = service.getById(id);
		if(coach == null) {
			return null;
		}
		List<PersonalTrainingRequest> requests = requestService.getAll();
		if(requests == null) {
			return null;
		}
		return requests.stream().filter(r->r.getCoach().getCoach_id().equals(id)).toList();
	}
	
	
}
