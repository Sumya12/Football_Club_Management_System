package com.pro.soccer.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Ground {
	@Id
	private Integer ground_id;
	private List<Slots> slots;
	private Long capacity;
	private Double size;
	private String name;
	public Integer getGround_id() {
		return ground_id;
	}
	public void setGround_id(Integer ground_id) {
		this.ground_id = ground_id;
	}
	public List<Slots> getSlots() {
		return slots;
	}
	public void setSlots(List<Slots> slots) {
		this.slots = slots;
	}
	public Long getCapacity() {
		return capacity;
	}
	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Ground(Integer ground_id, List<Slots> slots, Long capacity, Double size, String name) {
		super();
		this.ground_id = ground_id;
		this.slots = slots;
		this.capacity = capacity;
		this.size = size;
		this.name = name;
	}
	public Ground() {
		super();
	}
	
	
}
