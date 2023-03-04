package com.pro.soccer.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.soccer.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,String> {
	
}