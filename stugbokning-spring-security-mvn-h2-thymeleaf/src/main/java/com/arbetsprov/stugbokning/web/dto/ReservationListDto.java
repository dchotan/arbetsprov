package com.arbetsprov.stugbokning.web.dto;

import java.util.List;

import com.arbetsprov.stugbokning.model.Reservation;

public class ReservationListDto {
	
	private String title;
	private String address;
	private String image;
	private Long cabinId;
	private List<Reservation> reservations;
	
	public ReservationListDto() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getCabinId() {
		return cabinId;
	}

	public void setCabinId(Long cabinId) {
		this.cabinId = cabinId;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
		
}
