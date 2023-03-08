package com.pro.soccer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class TrainingGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer training_id;
	@ManyToOne
	private Coach coach;
	@JsonBackReference
	@OneToMany(mappedBy="group", fetch=FetchType.LAZY)
	private List<Player> players;
	private String startTime;
	private String endTime;
	@OneToOne
	private Booking booking;
	@ManyToOne
	private Club club;
	
	
	public Integer getTraining_id() {
		return training_id;
	}
	public void setTraining_id(Integer training_id) {
		this.training_id = training_id;
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


	public TrainingGroup(Integer training_id, Coach coach, List<Player> players, String startTime, String endTime,
			Booking booking, Club club) {
		super();
		this.training_id = training_id;
		this.coach = coach;
		this.players = players;
		this.startTime = startTime;
		this.endTime = endTime;
		this.booking = booking;
		this.club = club;
	}
	public TrainingGroup() {
		super();
	}
	
	
}
