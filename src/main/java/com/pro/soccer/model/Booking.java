package com.pro.soccer.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Booking {
	@Id
	private Integer book_id;
	private String startTime;
	private String endTime;	
	@OneToOne
	private Slots slot;
	@OneToOne
	private TrainingBatch batch;
	@OneToOne
	private Player player;
	
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	

	public Slots getSlot() {
		return slot;
	}
	public void setSlot(Slots slot) {
		this.slot = slot;
	}
	public TrainingBatch getBatch() {
		return batch;
	}
	public void setBatch(TrainingBatch batch) {
		this.batch = batch;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	public Booking(Integer book_id, String startTime, String endTime, Slots slot, TrainingBatch batch, Player player) {
		super();
		this.book_id = book_id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.slot = slot;
		this.batch = batch;
		this.player = player;
	}
	public Booking() {
		super();
	}
	
	
}
