package com.springBoot.birdSpotter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.SpottedBirdService;

@Controller
@RequestMapping("/birdspotting")	
public class BirdSpottingController {
	
	@Autowired
	private SpottedBirdService spottedBirdService;
	
	@GetMapping(value = "")
	public String ListLocations(Model model) {
		model.addAttribute("locationList", spottedBirdService.findAll());
		return "locationList";
	}

}
