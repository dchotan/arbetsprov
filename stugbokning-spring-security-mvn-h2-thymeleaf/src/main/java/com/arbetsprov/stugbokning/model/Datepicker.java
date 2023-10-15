package com.arbetsprov.stugbokning.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Datepicker {
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    
    public Datepicker() {
    	
    }
    
	public Datepicker(Date birthDate) {
		super();
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
    
    
}
