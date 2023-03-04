package com.pro.soccer.model;

import jakarta.persistence.Entity;

@Entity
public class Player {
	private Users user;
	private Integer platyer_id;
	private Coach personalCoach;
	private Booking<Player> booking;
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Integer getPlatyer_id() {
		return platyer_id;
	}
	public void setPlatyer_id(Integer platyer_id) {
		this.platyer_id = platyer_id;
	}
	public Coach getPersonalCoach() {
		return personalCoach;
	}
	public void setPersonalCoach(Coach personalCoach) {
		this.personalCoach = personalCoach;
	}
	public Booking<Player> getBooking() {
		return booking;
	}
	public void setBooking(Booking<Player> booking) {
		this.booking = booking;
	}
	public Player(Users user, Integer platyer_id, Coach personalCoach, Booking<Player> booking) {
		super();
		this.user = user;
		this.platyer_id = platyer_id;
		this.personalCoach = personalCoach;
		this.booking = booking;
	}
	public Player() {
		super();
	}
	
}