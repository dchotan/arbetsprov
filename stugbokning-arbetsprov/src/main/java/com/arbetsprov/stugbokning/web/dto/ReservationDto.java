package com.arbetsprov.stugbokning.web.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationDto {
	private String title;
	private String address;
	private String cabinType;
	private Integer numberOfGuests;
	private Double price;
	private Boolean parking;
	private String image;
	private Long userId;
	private Long cabinId;
	private String firstName;
	private String lastName;
	private Integer numberOfRooms;
	private Integer numberOfChildren;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fromDateTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDateTime;
	
	public ReservationDto() {
		
	}
	
	public ReservationDto(String title, String address, String cabinType, Integer numberOfGuests, Double price,
			Boolean parking, String image, Long userId, Long cabinId, String firstName, String lastName,
			Integer numberOfRooms, Integer numberOfChildren, Date fromDateTime, Date endDateTime) {
		super();
		this.title = title;
		this.address = address;
		this.cabinType = cabinType;
		this.numberOfGuests = numberOfGuests;
		this.price = price;
		this.parking = parking;
		this.image = image;
		this.userId = userId;
		this.cabinId = cabinId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.numberOfRooms = numberOfRooms;
		this.numberOfChildren = numberOfChildren;
		this.fromDateTime = fromDateTime;
		this.endDateTime = endDateTime;
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

	public String getCabinType() {
		return cabinType;
	}

	public void setCabinType(String cabinType) {
		this.cabinType = cabinType;
	}

	public Integer getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(Integer numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getParking() {
		return parking;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCabinId() {
		return cabinId;
	}

	public void setCabinId(Long cabinId) {
		this.cabinId = cabinId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(Integer numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public Integer getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(Integer numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public Date getFromDateTime() {
		return fromDateTime;
	}

	public void setFromDateTime(Date fromDateTime) {
		this.fromDateTime = fromDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	
}
