package com.pro.soccer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Club {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer club_id;
	private Double charges;

	@OneToMany(mappedBy="club", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<TrainingGroup> batches;
	private String club_name;
	@OneToMany(mappedBy="club", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Player>  players;
	@OneToMany(mappedBy="club", fetch=FetchType.LAZY)
	@JsonIgnore
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
	public List<TrainingGroup> getBatches() {
		return batches;
	}
	public void setBatches(List<TrainingGroup> batches) {
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
	public Club(Integer club_id, Double charges, List<TrainingGroup> batches, String club_name, List<Player> players,
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
