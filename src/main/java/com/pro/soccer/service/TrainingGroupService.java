package com.pro.soccer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.soccer.model.TrainingGroup;
import com.pro.soccer.repo.TrainingGroupRepo;

@Service
public class TrainingGroupService implements CrudService<TrainingGroup, Integer>{

	@Autowired
	TrainingGroupRepo repo;
	
	@Override
	public void add(TrainingGroup t) {
		// TODO Auto-generated method stub
		repo.save(t);
	}

	@Override
	public TrainingGroup getById(Integer id) {
		// TODO Auto-generated method stub
		return (repo.findById(id).equals(Optional.empty()))?null:repo.findById(id).get();
	}

	@Override
	public List<TrainingGroup> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void update(TrainingGroup t) {
		// TODO Auto-generated method stub
		repo.save(t);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		if(repo.findById(id).equals(Optional.empty())) return -1;
		repo.deleteById(id);
		return id;
	}


	
}
