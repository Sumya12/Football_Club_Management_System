package com.pro.soccer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro.soccer.model.Club;
import com.pro.soccer.model.Player;
import com.pro.soccer.model.TrainingGroup;
import com.pro.soccer.service.ClubService;
import com.pro.soccer.service.PlayerService;
import com.pro.soccer.service.TrainingGroupService;

@RestController
@RequestMapping(value = "/player")
public class PlayerController implements CrudController<Player, Integer> {
	@Autowired
	PlayerService service;
	
	@Autowired
	TrainingGroupService traingGroupService;

	@Autowired
	ClubService clubService;

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

	@PostMapping(value = "/joinclub/{clubid}")
	public int joinClub(@PathVariable("clubid") Integer clubid, @RequestParam Integer pid) {
		Club club = clubService.getById(clubid);
		if (club == null) {
			System.out.println(clubid);
			return 0;
		}
		Player player = service.getById(pid);

		if (player == null) {
			//System.out.println(model.getPid());
			return 0;
		}

		player.setClub(club);
		List<Player> players = club.getPlayers();
		if (players == null) {
			players = new ArrayList<Player>();
		}
		players.add(player);
		club.setPlayers(players);
		service.update(player);
		clubService.update(club);
		return 1;

	}
	
	@PostMapping(value = "/joingroup/{groupid}/{pid}")
	public int joinTrainingGroup(@PathVariable("groupid") Integer groupid, @PathVariable("pid") Integer pid) {
		Player player = service.getById(pid);
		if(player == null)
			return 0;
		TrainingGroup group = traingGroupService.getById(groupid);
		if(group == null)
			return 0;
		List<Player> players = group.getPlayers();
		if (players == null) {
			players = new ArrayList<Player>();
		}
		players.add(player);
		group.setPlayers(players);
		player.setGroup(group);
		
		service.update(player);
		traingGroupService.update(group);
		return 1;
	}


}
