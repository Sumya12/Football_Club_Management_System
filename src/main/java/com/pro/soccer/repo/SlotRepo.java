package com.pro.soccer.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.soccer.model.BookingSlot;

@Repository
public interface SlotRepo extends JpaRepository<BookingSlot, Integer>{

}
