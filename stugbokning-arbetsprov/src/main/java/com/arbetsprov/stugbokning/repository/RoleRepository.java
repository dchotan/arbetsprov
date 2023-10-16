package com.arbetsprov.stugbokning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arbetsprov.stugbokning.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
