package com.pro.soccer.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class BookingSlot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer booking_slot_id;
	private String date;
	private String time;
	@JsonIgnore
	@ManyToOne
	private Ground ground;
	
	
	public Ground getGround() {
		return ground;
	}
	public void setGround(Ground ground) {
		this.ground = ground;
	}
	
	public Integer getBooking_slot_id() {
		return booking_slot_id;
	}
	public void setBooking_slot_id(Integer booking_slot_id) {
		this.booking_slot_id = booking_slot_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	public BookingSlot(Integer booking_slot_id, String date, String time, Ground ground) {
		super();
		this.booking_slot_id = booking_slot_id;
		this.date = date;
		this.time = time;
		this.ground = ground;
	}
	public BookingSlot() {
		super();
	}
	
	
}
