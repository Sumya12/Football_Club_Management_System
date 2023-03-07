package com.pro.soccer.model;
import java.util.List;

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
	private List<Player> players;
	
	@OneToMany(mappedBy="coach", fetch=FetchType.LAZY)
	private List<TrainingBatch> batch;
	
	
	public List<TrainingBatch> getBatch() {
		return batch;
	}
	public void setBatch(List<TrainingBatch> batch) {
		this.batch = batch;
	}
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

	public Coach(Users user, Integer coach_id, List<Player> players, List<TrainingBatch> batch) {
		super();
		this.user = user;
		this.coach_id = coach_id;
		this.players = players;
		this.batch = batch;
	}
	public Coach() {
		super();
	}
	
}
