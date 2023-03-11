package com.pro.soccer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro.soccer.model.PersonalTrainingRequest;
import com.pro.soccer.service.PersonalTrainingService;

@RestController
@RequestMapping(value="/admin")
public class AdminController{
	@Autowired
	PersonalTrainingService personalTrainingService;

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
		return 1;
	}

	
	
}
