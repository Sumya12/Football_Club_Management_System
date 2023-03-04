package com.pro.soccer.model;
import java.util.List;

import org.hibernate.engine.jdbc.batch.spi.Batch;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Coach {
	private Users user;
	@Id
	private Integer coach_id;
	private List<Batch> batches;
	private List<Player> players;
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
	public List<Batch> getBatches() {
		return batches;
	}
	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public Coach(Users user, Integer coach_id, List<Batch> batches, List<Player> players) {
		super();
		this.user = user;
		this.coach_id = coach_id;
		this.batches = batches;
		this.players = players;
	}
	public Coach() {
		super();
	}
	
}
