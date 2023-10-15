package com.arbetsprov.stugbokning.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.arbetsprov.stugbokning.model.Cabin;
import com.arbetsprov.stugbokning.service.CabinService;
import com.arbetsprov.stugbokning.service.ReservationService;
import com.arbetsprov.stugbokning.web.dto.ReservationListDto;

@Controller
public class CabinController {

	private CabinService cabinService;
	private ReservationService reservationService;
		
	public CabinController(CabinService cabinService, ReservationService reservationService) {
		super();
		this.cabinService = cabinService;
		this.reservationService = reservationService;
	}

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listCabins", cabinService.getAllCabins());
		return "landing_page";
	}
	
	@GetMapping("/admin/viewCabinListPage")
	public String viewCabinListPage(Model model) {
		model.addAttribute("listCabins", cabinService.getAllCabins());
		return "view_cabin_list";
	}
	
	@GetMapping("/admin/showNewCabinForm")
	public String showNewCabinForm(Model model) {
		Cabin cabin = new Cabin();
		model.addAttribute("cabin", cabin);
		return "new_cabin";
	}
	
	@PostMapping("/admin/createCabin")
	public String createCabin(@ModelAttribute(value = "cabin") Cabin cabin) {
		
		cabinService.createCabin(cabin);
		
		return "redirect:/admin/viewCabinListPage";
	}
	
	@GetMapping("/admin/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
		
		Cabin cabin = cabinService.getCabinById(id);
		
		model.addAttribute("cabin", cabin);
		
		return "update_cabin";
	}
	
	@GetMapping("/admin/deleteCabin/{id}")
	public String deleteCabin(@PathVariable(value = "id") Long id, Model model) {
		
		cabinService.deleteCabinById(id);	
		
		return "redirect:/admin/viewCabinListPage";
	}
	
	@GetMapping("/admin/reservationsList")
	public String reservationsList(Model model) {
		
		List<ReservationListDto> reservationsListDtos = reservationService.getReservationListDtosByCabinId();
		
		model.addAttribute("reservationsList", reservationsListDtos);
		return "reservations_list";
	}
	
}
