package com.pro.soccer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.soccer.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
