package com.pro.soccer.model;

import java.util.List;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Booking<T> {
	@Id
	private Integer book_id;
	private T traineeType;
	private List<Slot> slots;
	private Coach coach;
	private Ground ground;
	
	public Integer getBook_id() {
		return book_id;
	}
	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}
	public T getTraineeType() {
		return traineeType;
	}
	public void setTraineeType(T traineeType) {
		this.traineeType = traineeType;
	}
	public List<Slot> getSlots() {
		return slots;
	}
	public void setSlots(List<Slot> slots) {
		this.slots = slots;
	}
	public Coach getCoach() {
		return coach;
	}
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	public Ground getGround() {
		return ground;
	}
	public void setGround(Ground ground) {
		this.ground = ground;
	}
	public Booking(Integer book_id, T traineeType, List<Slot> slots, Coach coach, Ground ground) {
		super();
		this.book_id = book_id;
		this.traineeType = traineeType;
		this.slots = slots;
		this.coach = coach;
		this.ground = ground;
	}
	public Booking() {
		super();
	}
	
}
