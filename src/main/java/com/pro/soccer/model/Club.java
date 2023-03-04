package com.pro.soccer.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Club {
	@Id
	private Integer club_id;
	private Double charges;
	private List<TrainingBatch> batches;
	private String club_name;
	private List<Player>  players;
	private List<Ground> grounds;
	public Integer getClub_id() {
		return club_id;
	}
	public void setClub_id(Integer club_id) {
		this.club_id = club_id;
	}
	public Double getCharges() {
		return charges;
	}
	public void setCharges(Double charges) {
		this.charges = charges;
	}
	public List<TrainingBatch> getBatches() {
		return batches;
	}
	public void setBatches(List<TrainingBatch> batches) {
		this.batches = batches;
	}
	public String getClub_name() {
		return club_name;
	}
	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public List<Ground> getGrounds() {
		return grounds;
	}
	public void setGrounds(List<Ground> grounds) {
		this.grounds = grounds;
	}
	public Club(Integer club_id, Double charges, List<TrainingBatch> batches, String club_name, List<Player> players,
			List<Ground> grounds) {
		super();
		this.club_id = club_id;
		this.charges = charges;
		this.batches = batches;
		this.club_name = club_name;
		this.players = players;
		this.grounds = grounds;
	}
	public Club() {
		super();
	} 
	
	
}
