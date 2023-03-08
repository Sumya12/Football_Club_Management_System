package com.pro.soccer.model;

import java.sql.Date;

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
	private Date date;
	private String fromTime;
	private String toTime;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}


	
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	
	public BookingSlot(Integer booking_slot_id, Date date, String fromTime, String toTime, Ground ground) {
		super();
		this.booking_slot_id = booking_slot_id;
		this.date = date;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.ground = ground;
	}
	public BookingSlot() {
		super();
	}
	
	
}
