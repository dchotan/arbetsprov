package com.arbetsprov.stugbokning.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reservation")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "cabin_id")
	private Long cabinId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "no_of_rooms")
	private Integer numberOfRooms;
	@Column(name = "no_of_guests")
	private Integer numberOfGuests;
	@Column(name = "no_of_children")
	private Integer numberOfChildren;
	private Double price;
	@Column(name = "from_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fromDateTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "end_date")
	private Date endDateTime;
	
	public Reservation() {
		
	}

	public Reservation(Long userId, Long cabinId, String firstName, String lastName, Integer numberOfRooms,
			Integer numberOfGuests, Integer numberOfChildren, Double price, Date fromDateTime, Date endDateTime) {
		super();
		this.userId = userId;
		this.cabinId = cabinId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.numberOfRooms = numberOfRooms;
		this.numberOfGuests = numberOfGuests;
		this.numberOfChildren = numberOfChildren;
		this.price = price;
		this.fromDateTime = fromDateTime;
		this.endDateTime = endDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(Integer numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public Integer getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(Integer numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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
