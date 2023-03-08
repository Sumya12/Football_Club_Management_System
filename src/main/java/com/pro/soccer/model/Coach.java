package com.pro.soccer.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Coach {
	@OneToOne
	private Users user;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer coach_id;
	@OneToMany(mappedBy="personalCoach", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Player> players;
	
	@OneToMany(mappedBy="coach", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<TrainingGroup> group;
	
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Integer getCoach_id() {
		return coach_id;
	}
	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public List<TrainingGroup> getGroup() {
		return group;
	}
	public void setGroup(List<TrainingGroup> group) {
		this.group = group;
	}
	
	
	public Coach(Users user, Integer coach_id, List<Player> players, List<TrainingGroup> group) {
		super();
		this.user = user;
		this.coach_id = coach_id;
		this.players = players;
		this.group = group;
	}
	public Coach() {
		super();
	}
	
}
