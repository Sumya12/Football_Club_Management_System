package com.pro.soccer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.soccer.model.Club;
import com.pro.soccer.model.Coach;
import com.pro.soccer.model.TrainingGroup;
import com.pro.soccer.service.ClubService;
import com.pro.soccer.service.CoachService;
import com.pro.soccer.service.TrainingGroupService;

@RestController
@RequestMapping(value="/club")
public class ClubController implements CrudController<Club, Integer>{
	@Autowired
	ClubService service;
	
	@Autowired
	CoachService coachService;
	
	@Autowired
	TrainingGroupService trainingService;


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
	
	@GetMapping("/getAllTrainingGroup/{clubid}")
	public List<TrainingGroup> getAllTrainingGroup(@PathVariable("clubid") Integer id) {
		Club club = service.getById(id);
		if(club == null)
			return null;
		return club.getBatches();
	}
	
	@PostMapping(value="/addTrainingGroup/{coachid}/{clubid}", consumes = { "application/json" })
	public int addGroup(@PathVariable("coachid") Integer coachid, @PathVariable("clubid") Integer clubid, @RequestBody TrainingGroup group) {
		Club club = service.getById(clubid);
		
		if(club == null)
			return 0;
		List<TrainingGroup> groups = club.getBatches();
		if(groups == null) {
			groups = new ArrayList<TrainingGroup>();
		}
		groups.add(group);
		club.setBatches(groups);
		group.setClub(club);
		service.update(club);
		trainingService.update(group);
		
		Coach coach = coachService.getById(coachid);
		List<TrainingGroup> coachGroups = coach.getGroup(); // training groups under a coach
		if(coachGroups == null) {
			coachGroups = new ArrayList<TrainingGroup>();
		}
		coachGroups.add(group);
		coach.setGroup(coachGroups);
		group.setCoach(coach);
		coachService.update(coach);
		trainingService.update(group);
		return 1;
	}
	
	
	
}
