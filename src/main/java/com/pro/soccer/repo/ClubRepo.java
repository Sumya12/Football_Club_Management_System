package com.pro.soccer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.soccer.model.Club;

@Repository
public interface ClubRepo extends JpaRepository<Club, Integer>{

}
