package com.pro.soccer.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Slots {
	@Id
	private Integer slot_id;
	private Date date;
	private String from;
	private String to;
	@ManyToOne
	private Ground ground;
	
	
	public Ground getGround() {
		return ground;
	}
	public void setGround(Ground ground) {
		this.ground = ground;
	}
	public Integer getSlot_id() {
		return slot_id;
	}
	public void setSlot_id(Integer slot_id) {
		this.slot_id = slot_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}

	public Slots(Integer slot_id, Date date, String from, String to, Ground ground) {
		super();
		this.slot_id = slot_id;
		this.date = date;
		this.from = from;
		this.to = to;
		this.ground = ground;
	}
	public Slots() {
		super();
	}
	
	
}
