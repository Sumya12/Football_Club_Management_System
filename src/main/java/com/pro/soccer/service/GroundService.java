package com.pro.soccer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.soccer.model.Ground;
import com.pro.soccer.repo.GroundRepo;

@Service
public class GroundService implements CrudService<Ground, Integer>{

	@Autowired
	GroundRepo repo;
	
	@Override
	public void add(Ground t) {
		// TODO Auto-generated method stub
		repo.save(t);
	}

	@Override
	public Ground getById(Integer id) {
		// TODO Auto-generated method stub
		return (repo.findById(id).equals(Optional.empty()))?repo.findById(id).get():null;
	}

	@Override
	public List<Ground> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void update(Ground t) {
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
