package com.pro.soccer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.soccer.model.PersonalTrainingRequest;
import com.pro.soccer.repo.PersonalTrainingRepo;

@Service
public class PersonalTrainingService implements CrudService<PersonalTrainingRequest, Integer>{

	@Autowired
	PersonalTrainingRepo repo;
	
	@Override
	public void add(PersonalTrainingRequest t) {
		// TODO Auto-generated method stub
		repo.save(t);
	}

	@Override
	public PersonalTrainingRequest getById(Integer id) {
		// TODO Auto-generated method stub
		return (repo.findById(id).equals(Optional.empty()))?null:repo.findById(id).get();
	}

	@Override
	public List<PersonalTrainingRequest> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void update(PersonalTrainingRequest t) {
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
