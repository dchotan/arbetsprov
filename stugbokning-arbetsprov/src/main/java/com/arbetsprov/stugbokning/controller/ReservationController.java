package com.arbetsprov.stugbokning.controller;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arbetsprov.stugbokning.model.Cabin;
import com.arbetsprov.stugbokning.model.Reservation;
import com.arbetsprov.stugbokning.model.User;
import com.arbetsprov.stugbokning.service.CabinService;
import com.arbetsprov.stugbokning.service.ReservationService;
import com.arbetsprov.stugbokning.service.UserService;
import com.arbetsprov.stugbokning.web.dto.ReservationDto;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	private ReservationService reservationService;
	private CabinService cabinService;
	private UserService userService;

	public ReservationController(ReservationService reservationService, CabinService cabinService,
			UserService userService) {
		super();
		this.reservationService = reservationService;
		this.cabinService = cabinService;
		this.userService = userService;
	}

	@PostMapping()
	public String createReservation(@ModelAttribute(value = "reservation") Reservation reservation,
									Principal principal) {
		
		User user = userService.findUserByEmail(principal.getName());
		reservation.setUserId(user.getId());
		
		reservationService.createReservation(reservation);
		
		String redirect = "redirect:/reservation/"
						  + reservation.getCabinId().toString() 
						  + "?success";
		
		return redirect;
	}
	
	@GetMapping("/{id}")
	public String showFormForReservation(@PathVariable(value = "id") Long cabinId, 
			Principal principal, Model model) {
		
		Cabin cabin = cabinService.getCabinById(cabinId);
		Reservation reservation = new Reservation();
		
		model.addAttribute("cabin", cabin);
		model.addAttribute("reservation", reservation);
		
		return "new_reservation";
	}
	
	@GetMapping("/myReservationsList")
	public String myReservationsList(Principal principal, Model model) throws ParseException {
		
		List<ReservationDto> reservationDtos = reservationService.mapReservationDto(principal);
		
		model.addAttribute("reservationsList", reservationDtos);
		
		return "my_reservations_list";
	}
}
