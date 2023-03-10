package com.pro.soccer.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	@Column(nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	@OneToOne
	private Coach personalCoach;
	@OneToOne
	private Booking booking;
	@OneToOne
	private Club club;

	@ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private TrainingGroup group;



	public Player(Users user, Integer pid, Coach personalCoach, Booking booking, Club club, TrainingGroup group) {
		super();
		this.user = user;
		this.pid = pid;
		this.personalCoach = personalCoach;
		this.booking = booking;
		this.club = club;
		this.group = group;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
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

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}


	public TrainingGroup getGroup() {
		return group;
	}

	public void setGroup(TrainingGroup group) {
		this.group = group;
	}

	public Player() {
		super();
	}

}