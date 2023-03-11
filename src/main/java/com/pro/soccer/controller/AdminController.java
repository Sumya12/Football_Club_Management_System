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
import com.pro.soccer.model.Ground;
import com.pro.soccer.model.PersonalTrainingRequest;
import com.pro.soccer.model.Player;
import com.pro.soccer.service.ClubService;
import com.pro.soccer.service.CoachService;
import com.pro.soccer.service.GroundService;
import com.pro.soccer.service.PersonalTrainingService;
import com.pro.soccer.service.PlayerService;

@RestController
@RequestMapping(value="/admin")
public class AdminController{
	@Autowired
	PersonalTrainingService personalTrainingService;

	@Autowired
	GroundService groundService;
	
	@Autowired
	ClubService clubService;
	
	@Autowired
	PlayerService playerService;
	
	@Autowired
	CoachService coachService;

	

	@GetMapping("/getAllPersonalCoachRequest")
	public List<PersonalTrainingRequest> getAllPersonalCoachRequest() {
		return personalTrainingService.getAll();
	}
	

	@PostMapping("/approvePersonalCoachRequest/{requestid}")
	public int approveAllPersonalCoachRequest(@PathVariable("requestid") Integer requestid) {
		PersonalTrainingRequest request = personalTrainingService.getById(requestid);
		if(request == null)
			return 0;
		request.setStatus("APPROVED");
		personalTrainingService.update(request);
		try {
			Player player= playerService.getById(request.getPlayer().getPid());
			Coach coach = coachService.getById(request.getCoach().getCoach_id());
			
			player.setPersonalCoach(coach);
			List<Player> players = coach.getPlayers();	
			if(players == null) {
				players = new ArrayList<Player>();
			}
			players.add(player);
			coach.setPlayers(players);
			
			coachService.update(coach);
			playerService.update(player);
			
		}catch(Exception e) {
			return 0;
		}
		return 1;
	}
	
	@PostMapping("/addGround/{clubid}")
	public int addGround(@PathVariable Integer clubid, @RequestBody Ground ground) {
		Club club = clubService.getById(clubid);
		if(club == null)
			return 0;
		List<Ground> grounds = club.getGrounds();
		if(grounds == null) {
			grounds = new ArrayList<Ground>();
		}
		grounds.add(ground);
		
		club.setGrounds(grounds);
		ground.setClub(club);
		
		groundService.update(ground);
		clubService.update(club);
		return 1;
	}
	
	@GetMapping("/getAllGround/{clubid}")
	public List<Ground> addGround(@PathVariable Integer clubid) {
		Club club = clubService.getById(clubid);
		if(club == null)
			return null;
		return club.getGrounds();
	}
	

	
	
}
