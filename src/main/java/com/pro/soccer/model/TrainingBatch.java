package com.pro.soccer.model;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class TrainingBatch {
	Integer batch_id;
	Coach coach;
	List<Player> players;
	String startTime;
	String endTime;
	Booking<TrainingBatch> booking;
	public Integer getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(Integer batch_id) {
		this.batch_id = batch_id;
	}
	public Coach getCoach() {
		return coach;
	}
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
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
	public Booking<TrainingBatch> getBooking() {
		return booking;
	}
	public void setBooking(Booking<TrainingBatch> booking) {
		this.booking = booking;
	}
	public TrainingBatch(Integer batch_id, Coach coach, List<Player> players, String startTime, String endTime,
			Booking<TrainingBatch> booking) {
		super();
		this.batch_id = batch_id;
		this.coach = coach;
		this.players = players;
		this.startTime = startTime;
		this.endTime = endTime;
		this.booking = booking;
	}
	public TrainingBatch() {
		super();
	}
	
	
}
