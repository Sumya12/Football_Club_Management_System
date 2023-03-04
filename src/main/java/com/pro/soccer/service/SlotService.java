package com.pro.soccer.service;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.soccer.repo.SlotRepo;

@Service
public class SlotService implements CrudService<Slot, Integer>{

	@Autowired
	SlotRepo repo;
	
	@Override
	public void add(Slot t) {
		// TODO Auto-generated method stub
		repo.save(t);
	}

	@Override
	public Slot getById(Integer id) {
		// TODO Auto-generated method stub
		return (repo.findById(id).equals(Optional.empty()))?repo.findById(id).get():null;
	}

	@Override
	public List<Slot> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void update(Slot t) {
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
