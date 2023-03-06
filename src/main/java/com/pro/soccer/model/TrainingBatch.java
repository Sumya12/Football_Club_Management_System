package com.pro.soccer.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class TrainingBatch {
	@Id
	private Integer batch_id;
	@ManyToOne
	private Coach coach;
	@OneToMany(mappedBy="batch", fetch=FetchType.LAZY)
	private List<Player> players;
	private String startTime;
	private String endTime;
	@OneToOne
	private Booking booking;
	@ManyToOne
	private Club club;
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
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}

	public TrainingBatch(Integer batch_id, Coach coach, List<Player> players, String startTime, String endTime,
			Booking booking, Club club) {
		super();
		this.batch_id = batch_id;
		this.coach = coach;
		this.players = players;
		this.startTime = startTime;
		this.endTime = endTime;
		this.booking = booking;
		this.club = club;
	}
	public TrainingBatch() {
		super();
	}
	
	
}
