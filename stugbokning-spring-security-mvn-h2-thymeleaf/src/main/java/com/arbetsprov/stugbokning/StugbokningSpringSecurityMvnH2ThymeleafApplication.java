package com.arbetsprov.stugbokning;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.arbetsprov.stugbokning.model.Book;
import com.arbetsprov.stugbokning.model.Cabin;
import com.arbetsprov.stugbokning.model.Reservation;
import com.arbetsprov.stugbokning.model.Role;
import com.arbetsprov.stugbokning.service.BookService;
import com.arbetsprov.stugbokning.service.CabinService;
import com.arbetsprov.stugbokning.service.ReservationService;
import com.arbetsprov.stugbokning.service.RoleService;
import com.arbetsprov.stugbokning.service.UserService;
import com.arbetsprov.stugbokning.web.dto.UserRegistrationDto;

@SpringBootApplication
public class StugbokningSpringSecurityMvnH2ThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(StugbokningSpringSecurityMvnH2ThymeleafApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RoleService roleService,
										UserService userService,
										BookService bookService,
										CabinService cabinService,
										ReservationService reservationService) {
		return args ->{
			bookService.saveBook(new Book("book name", "475", "author name"));
			
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
			
			reservationService.createReservation(
					new Reservation(
							10L, 1L, "Chotan", "Dutta", 2, 2, 0, 11.0, new Date(), new Date()));
			reservationService.createReservation(
					new Reservation(
							11L, 1L, "Andreas", "Åhlund", 2, 2, 0, 11.0, new Date(), new Date()));
			reservationService.createReservation(
					new Reservation(
							12L, 2L, "Aditi", "Das", 2, 2, 0, 22.0, new Date(), new Date()));
			reservationService.createReservation(
					new Reservation(
							13L, 1L, "Sandra", "Dahlberg", 2, 2, 0, 33.0, new Date(), new Date()));
		
		};
	}
}
