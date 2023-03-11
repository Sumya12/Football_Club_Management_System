package com.pro.soccer.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Ground {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ground_id;
	@JsonIgnore
	@OneToMany(mappedBy="ground", fetch=FetchType.LAZY)
	private List<BookingSlot> slots;
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
	public List<BookingSlot> getSlots() {
		return slots;
	}
	public void setSlots(List<BookingSlot> slots) {
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

	public Ground(Integer ground_id, List<BookingSlot> slots, Long capacity, Double size, String name, Club club) {
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
