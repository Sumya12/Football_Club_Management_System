package com.pro.soccer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.soccer.model.Coach;

@Repository
public interface CoachRepo extends JpaRepository<Coach, Integer>{

}
