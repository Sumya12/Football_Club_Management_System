package com.pro.soccer.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer booking_id;
	private String startTime;
	private String endTime;	
	@OneToOne
	private BookingSlot slot;
	@OneToOne
	private TrainingGroup batch;
	@OneToOne
	private Player player;
	
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	

	public Integer getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(Integer booking_id) {
		this.booking_id = booking_id;
	}
	public BookingSlot getSlot() {
		return slot;
	}
	public void setSlot(BookingSlot slot) {
		this.slot = slot;
	}
	public TrainingGroup getBatch() {
		return batch;
	}
	public void setBatch(TrainingGroup batch) {
		this.batch = batch;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}


	public Booking(Integer booking_id, String startTime, String endTime, BookingSlot slot, TrainingGroup batch,
			Player player) {
		super();
		this.booking_id = booking_id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.slot = slot;
		this.batch = batch;
		this.player = player;
	}
	public Booking() {
		super();
	}
	
	
}
