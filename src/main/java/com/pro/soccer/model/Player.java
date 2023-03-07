package com.pro.soccer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Player {
	@OneToOne
	private Users user;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer player_id;
	@OneToOne
	private Coach personalCoach;
	@OneToOne
	private Booking booking;
	@OneToOne
	private Club club;
	
	@ManyToOne
	private TrainingBatch batch;
	
	
	
	public TrainingBatch getBatch() {
		return batch;
	}
	public void setBatch(TrainingBatch batch) {
		this.batch = batch;
	}
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Integer getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(Integer player_id) {
		this.player_id = player_id;
	}
	public Coach getPersonalCoach() {
		return personalCoach;
	}
	public void setPersonalCoach(Coach personalCoach) {
		this.personalCoach = personalCoach;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}


	public Player(Users user, Integer player_id, Coach personalCoach, Booking booking, Club club,
			TrainingBatch batch) {
		super();
		this.user = user;
		this.player_id = player_id;
		this.personalCoach = personalCoach;
		this.booking = booking;
		this.club = club;
		this.batch = batch;
	}
	public Player() {
		super();
	}
	
}