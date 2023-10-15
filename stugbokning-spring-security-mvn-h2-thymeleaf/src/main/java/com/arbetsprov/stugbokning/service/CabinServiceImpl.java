package com.arbetsprov.stugbokning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arbetsprov.stugbokning.model.Cabin;
import com.arbetsprov.stugbokning.repository.CabinRepository;

@Service
public class CabinServiceImpl implements CabinService {

	private CabinRepository cabinRepository;
	
	public CabinServiceImpl(CabinRepository cabinRepository) {
		super();
		this.cabinRepository = cabinRepository;
	}

	@Override
	public void createCabin(Cabin cabin) {
		
		cabinRepository.save(cabin);		
	}

	@Override
	public List<Cabin> getAllCabins() {
		List<Cabin> cabins = cabinRepository.findAll();
		return cabins;
	}

	@Override
	public Cabin getCabinById(Long id) {
		Optional<Cabin> optional = cabinRepository.findById(id);
		Cabin cabin = null;
		if(optional.isPresent()) {
			cabin = optional.get();
			return cabin;
		}
		else {
			System.out.println("Stuga kan inte hitta med id: " + id);
			return null;
		}
		
	}

	@Override
	public void deleteCabinById(Long id) {
		cabinRepository.deleteById(id);
		
	}

}
