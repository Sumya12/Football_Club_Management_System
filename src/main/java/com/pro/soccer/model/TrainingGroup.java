package com.pro.soccer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private String name;
	@JsonIgnore
	@OneToMany(mappedBy="group", fetch=FetchType.LAZY)
	private List<Player> players;
	private String startDate;
	private String endDate;
	private String time;
	private Integer playerCount;
	@OneToOne
	private Booking booking;
	@ManyToOne
	private Club club;
	
	
	public Integer getPlayerCount() {
		return playerCount;
	}
	public void setPlayerCount(Integer playerCount) {
		this.playerCount = playerCount;
	}
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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


	public TrainingGroup(Integer training_id, Coach coach, String name, List<Player> players, String startDate,
			String endDate, String time, Integer playerCount, Booking booking, Club club) {
		super();
		this.training_id = training_id;
		this.coach = coach;
		this.name = name;
		this.players = players;
		this.startDate = startDate;
		this.endDate = endDate;
		this.time = time;
		this.playerCount = playerCount;
		this.booking = booking;
		this.club = club;
	}
	public TrainingGroup() {
		super();
	}
	
	
}
