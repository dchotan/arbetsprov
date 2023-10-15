package com.arbetsprov.stugbokning.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.arbetsprov.stugbokning.model.Role;
import com.arbetsprov.stugbokning.model.User;
import com.arbetsprov.stugbokning.repository.RoleRepository;
import com.arbetsprov.stugbokning.repository.UserRepository;
import com.arbetsprov.stugbokning.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	// Recommended construction based injection
	private final UserRepository userRepository;

	private final RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {

		String assignedRole = registrationDto.getRole();

		User user = new User(registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role(assignedRole)));

		Role role = new Role();

		List<Role> roles = roleRepository.findAll();
		for (Role role_ : roles) {
			if (role_.getName().contains(assignedRole)) {
				role.setId(role_.getId());
				role.setName(role_.getName());
			}
		}

		roles = new ArrayList<Role>();
		roles.add(role);

		user.setRoles(roles);
		user = userRepository.save(user);

		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid user name or password.");
		}

		UserDetails details = new org.springframework.security.core.userdetails.User(
				user.getEmail(),
				user.getPassword(), 
				mapRolesToAuthorities(user.getRoles()));

		return details;
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {

		Collection<GrantedAuthority> gr = roles.stream().map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());

		return gr;
	}

	@Override
	public User findUserByEmail(String email) {
		User user = userRepository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid user name or password.");
		}
		return user;
	}
}
