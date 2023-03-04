package com.pro.soccer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.soccer.model.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player, Integer>{

}
