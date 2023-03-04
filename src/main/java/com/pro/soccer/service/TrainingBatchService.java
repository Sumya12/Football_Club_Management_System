package com.pro.soccer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.soccer.model.TrainingBatch;
import com.pro.soccer.repo.TrainingBatchRepo;

@Service
public class TrainingBatchService implements CrudService<TrainingBatch, Integer>{

	@Autowired
	TrainingBatchRepo repo;
	
	@Override
	public void add(TrainingBatch t) {
		// TODO Auto-generated method stub
		repo.save(t);
	}

	@Override
	public TrainingBatch getById(Integer id) {
		// TODO Auto-generated method stub
		return (repo.findById(id).equals(Optional.empty()))?repo.findById(id).get():null;
	}

	@Override
	public List<TrainingBatch> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void update(TrainingBatch t) {
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
