package com.arbetsprov.stugbokning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arbetsprov.stugbokning.model.Cabin;

@Repository
public interface CabinRepository extends JpaRepository<Cabin, Long>{

}
