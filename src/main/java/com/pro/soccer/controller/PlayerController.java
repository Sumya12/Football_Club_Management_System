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

import com.pro.soccer.model.Booking;
import com.pro.soccer.model.BookingSlot;
import com.pro.soccer.model.Club;
import com.pro.soccer.model.Coach;
import com.pro.soccer.model.Ground;
import com.pro.soccer.model.PersonalTrainingRequest;
import com.pro.soccer.model.Player;
import com.pro.soccer.model.TrainingGroup;
import com.pro.soccer.service.BookingService;
import com.pro.soccer.service.ClubService;
import com.pro.soccer.service.CoachService;
import com.pro.soccer.service.GroundService;
import com.pro.soccer.service.PersonalTrainingService;
import com.pro.soccer.service.PlayerService;
import com.pro.soccer.service.SlotService;
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
	
	@Autowired
	CoachService coachService;
	
	@Autowired
	GroundService groundService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	PersonalTrainingService personalTrainingService;
	
	@Autowired
	SlotService slotService;

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
	
	@PostMapping(value = "/bookPersonalCoach/{coachid}/{pid}")
	public int bookPersonalCoach(@PathVariable("coachid") Integer coachid, @PathVariable("pid") Integer pid) {
		Player player = service.getById(pid);
		if(player == null)
			return 0;
		Coach coach = coachService.getById(coachid);
		if(coach == null)
			return 0;
		
		PersonalTrainingRequest request = new PersonalTrainingRequest();
		request.setCoach(coach);
		request.setPlayer(player);
		request.setStatus("WAITING");
		personalTrainingService.update(request);
		return 1;
	}
	
	@PostMapping(value = "/bookGround/{pid}/{gid}")
	public int bookGround(@PathVariable("pid") Integer pid, @PathVariable("gid") Integer gid, @RequestBody BookingSlot slot) {
		Player player = service.getById(pid);
		if(player == null)
			return 0;
		Ground ground = groundService.getById(gid);
		if(ground == null)
			return 0;
		
		slot.setGround(ground);
		slotService.update(slot);
		
		Booking booking =new Booking();
		booking.setSlot(slot);
		booking.setPlayer(player);
		booking.setStartTime(slot.getFromTime());
		booking.setEndTime(slot.getToTime());
		bookingService.add(booking);
		
		player.setBooking(booking);
		service.update(player);
		
		List<BookingSlot> slots = ground.getSlots();
		if(slots == null) {
			slots = new ArrayList<BookingSlot>();
		}
		slots.add(slot);
		ground.setSlots(slots); // set booked slots
		groundService.update(ground);
		return 1;
	}
	

	@GetMapping("/hasCoach/{pid}")
	public int hasCoach(@PathVariable Integer pid) {
		Player player = service.getById(pid);
		if(player == null)
			return 0;
		
		if(player.getPersonalCoach() != null)
			return player.getPersonalCoach().getCoach_id();
		return 0;
	}
	
	@GetMapping("/hasTrainingGroup/{pid}")
	public int hasTrainingGroup(@PathVariable Integer pid) {
		Player player = service.getById(pid);
		if(player == null)
			return 0;
		
		if(player.getGroup() != null)
			return player.getGroup().getTraining_id();
		return 0;
	}


}
