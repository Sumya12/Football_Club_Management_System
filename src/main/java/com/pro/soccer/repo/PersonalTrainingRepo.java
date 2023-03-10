package com.pro.soccer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.soccer.model.PersonalTrainingRequest;

@Repository
public interface PersonalTrainingRepo extends JpaRepository<PersonalTrainingRequest, Integer>{

}
