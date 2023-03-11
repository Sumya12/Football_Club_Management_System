package com.pro.soccer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.soccer.model.Player;
import com.pro.soccer.model.Users;
import com.pro.soccer.repo.PlayerRepo;

@Service
public class PlayerService implements CrudService<Player, Integer>{

	@Autowired
	PlayerRepo repo;
	
	@Override
	public void add(Player t) {
		// TODO Auto-generated method stub
		repo.save(t);
	}

	@Override
	public Player getById(Integer id) {
		// TODO Auto-generated method stub
		return (repo.findById(id).equals(Optional.empty()))?null:repo.findById(id).get();
	}

	@Override
	public List<Player> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void update(Player t) {
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
	

	public Player getByUser(Users user) {
		// TODO Auto-generated method stub
		return repo.findByUser(user);
	}



	
}
