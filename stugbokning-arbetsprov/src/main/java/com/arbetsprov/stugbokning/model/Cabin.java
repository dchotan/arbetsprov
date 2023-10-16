package com.arbetsprov.stugbokning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Entity
@Table(name = "cabin")
public class Cabin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String address;
	@Column(name = "cabin_type")
	private String cabinType;
	@Column(name = "guest_numbers")
	private Integer numberOfGuests;
	private Double price;
	private Boolean parking;
	private String image;
	
//	private String sizeOfCabin; // squar meter
//	private String description;
//	private Integer numberOfBedRoom; //  bäddar	
//	private Long numberOfPersons;
//	private Float price; // per night sek
//	private Boolean animal; // husdjur
//	private Boolean wifi; // Trådlöst
//	private Boolean parking;
	
	public Cabin() {		
	}
	
	public Cabin(String title, String address, String cabinType, Integer numberOfGuests, Double price, Boolean parking,
		String image) {
		super();
		this.title = title;
		this.address = address;
		this.cabinType = cabinType;
		this.numberOfGuests = numberOfGuests;
		this.price = price;
		this.parking = parking;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;
	}
}
