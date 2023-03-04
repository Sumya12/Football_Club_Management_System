package com.pro.soccer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.soccer.model.Ground;

@Repository
public interface GroundRepo extends JpaRepository<Ground, Integer>{

}
