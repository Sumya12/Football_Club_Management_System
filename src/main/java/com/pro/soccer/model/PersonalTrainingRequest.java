package com.pro.soccer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class PersonalTrainingRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer personal_training_id;
	@OneToOne
	private Coach coach;
	@OneToOne
	private Player player;
	private String status; //approved/not
	
	
	public Integer getPersonal_training_id() {
		return personal_training_id;
	}


	public void setPersonal_training_id(Integer personal_training_id) {
		this.personal_training_id = personal_training_id;
	}


	public Coach getCoach() {
		return coach;
	}


	public void setCoach(Coach coach) {
		this.coach = coach;
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public PersonalTrainingRequest(Integer personal_training_id, Coach coach, Player player, String status) {
		super();
		this.personal_training_id = personal_training_id;
		this.coach = coach;
		this.player = player;
		this.status = status;
	}


	public PersonalTrainingRequest() {
		super();
	}
	
	
}
