package com.pro.soccer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.soccer.model.Users;
import com.pro.soccer.repo.UsersRepository;

@Service
public class UserService implements CrudService<Users, String>{

	@Autowired
	UsersRepository repo;
	
	@Override
	public void add(Users t) {
		// TODO Auto-generated method stub
		repo.save(t);
	}

	@Override
	public Users getById(String id) {
		// TODO Auto-generated method stub
		return (repo.findById(id).equals(Optional.empty()))?repo.findById(id).get():null;
	}

	@Override
	public List<Users> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void update(Users t) {
		// TODO Auto-generated method stub
		repo.save(t);
	}

	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		if(repo.findById(id).equals(Optional.empty())) return -1;
		repo.deleteById(id);
		return id;
	}


	
}
