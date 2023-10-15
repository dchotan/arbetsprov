package com.arbetsprov.stugbokning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.arbetsprov.stugbokning.model.Datepicker;

@Controller
public class DatepickerController {
	
	@PostMapping("/saveDatepicker")
	public String saveDatepicker(@ModelAttribute(value = "datepicker") Datepicker datepicker, Model model) {
		
		model.addAttribute("datepicker", datepicker);
		
		return "display_date";
	}
	
	@GetMapping("/showDatepickerForm")
	public String showdDatepickerForm(Model model) {
		Datepicker datepicker = new Datepicker();
		model.addAttribute("datepicker", datepicker);
		return "date_form";
	}

}
