package com.pro.soccer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.soccer.model.TrainingGroup;

@Repository
public interface TrainingGroupRepo extends JpaRepository<TrainingGroup, Integer>{

}
