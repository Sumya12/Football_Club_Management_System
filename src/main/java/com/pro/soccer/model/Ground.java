package com.pro.soccer.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Ground {
	@Id
	private Integer ground_id;
	@OneToMany(mappedBy="ground", fetch=FetchType.LAZY)
	private List<Slots> slots;
	private Long capacity;
	private Double size;
	private String name;
	@ManyToOne
	private Club club;
	
	
	public Club getClub() {
		return club;
	}
	public void setClub(Club club) {
		this.club = club;
	}
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

	public Ground(Integer ground_id, List<Slots> slots, Long capacity, Double size, String name, Club club) {
		super();
		this.ground_id = ground_id;
		this.slots = slots;
		this.capacity = capacity;
		this.size = size;
		this.name = name;
		this.club = club;
	}
	public Ground() {
		super();
	}
	
	
}
