package com.arbetsprov.stugbokning.service;

import org.springframework.stereotype.Service;

import com.arbetsprov.stugbokning.model.Role;
import com.arbetsprov.stugbokning.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	private RoleRepository roleRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@Override
	public Role save(Role role) {
		
		return roleRepository.save(role);
	}

}
