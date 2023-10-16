package com.arbetsprov.stugbokning;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.arbetsprov.stugbokning.model.Cabin;
import com.arbetsprov.stugbokning.model.Role;
import com.arbetsprov.stugbokning.service.CabinService;
import com.arbetsprov.stugbokning.service.RoleService;
import com.arbetsprov.stugbokning.service.UserService;
import com.arbetsprov.stugbokning.web.dto.UserRegistrationDto;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RoleService roleService,
										UserService userService,
										CabinService cabinService) {
		return args ->{
			roleService.save(new Role("USER"));
			roleService.save(new Role("ADMIN"));
			
			userService.save(new UserRegistrationDto("Admin", "", "admin@mail.com", "admin", "ADMIN"));
			
			cabinService.createCabin(
					new Cabin("Hus i idyllisk skärgårdsmiljö",
							  "Skatans fiskeläge , Njurunda",
							  "Hus", 6, 1700.0, true,
							  "https://billingensstugby.se/wp-content/uploads/2021/01/StugaAA-scaled.jpg"));
					
			cabinService.createCabin(
					new Cabin("Stuga med sjötomt",
							  "Härnösand, Höga Kusten",
							  "Stuga", 2, 1100.0, false,
							  "https://billingensstugby.se/wp-content/uploads/2021/01/Stuga-A-2020-scaled.jpg"));
			cabinService.createCabin(
					new Cabin("Stuga på havstomt",
							  "Alnö, Sundsvall",
							  "Hus", 8, 2100.0, true,
							  "https://www.bodasand.se/media/1137/typ-8-1-11.jpg?anchor=center&mode=crop&width=1200&height=630&rnd=131626519620000000"));
		};
	}
}
