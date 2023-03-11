package com.pro.soccer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.soccer.model.Coach;
import com.pro.soccer.model.Player;
import com.pro.soccer.model.Users;

@Repository
public interface CoachRepo extends JpaRepository<Coach, Integer>{
	public Coach findByUser(Users user);
}
