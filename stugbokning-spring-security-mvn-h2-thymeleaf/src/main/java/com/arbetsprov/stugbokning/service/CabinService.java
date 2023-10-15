package com.arbetsprov.stugbokning.service;

import java.util.List;

import com.arbetsprov.stugbokning.model.Cabin;

public interface CabinService {
	void createCabin(Cabin cabin);	
	List<Cabin> getAllCabins();
	Cabin getCabinById(Long id);
	void deleteCabinById(Long id);
}
