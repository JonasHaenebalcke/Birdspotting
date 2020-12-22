package com.springBoot.birdSpotter;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.BirdSpecie;
import domain.BirdSpotLocation;
import domain.SpottedBird;
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

	@GetMapping(value = "/{name}")
	public String spottedBirds(@PathVariable("name") String locationName, Model model) {

		Optional<BirdSpotLocation> location = spottedBirdService.findByName(locationName);

		if (location == null)
			return "locationList";

		List<SpottedBird> spottedBirds = location.get().getSpottedBirds();
		model.addAttribute("location", location);
		model.addAttribute("spottedBirds", spottedBirds);
		return "locationDetails";
	}

	@GetMapping(value = "/{location}/newbirdspotting")
	public String AddSpotting(@PathVariable("location") String locationName, 
			Model model) {
		
		Optional<BirdSpotLocation> location = spottedBirdService.findByName(locationName);
		if (location == null)
			return "locationList";
		
		BirdSpecie birdSpecie = new BirdSpecie("Specie", 2020, "AA000");
		
		model.addAttribute("location", location);		
		model.addAttribute("specie", birdSpecie);
		
		return "addSpotting";
	}
	
	@PostMapping(value = "/{location}/newbirdspotting")
	public String SubmitSpotting(@PathVariable("location") String locationName,
			@Valid BirdSpecie specie, BindingResult result, Model model) {
		
		Optional<BirdSpotLocation> location = spottedBirdService.findByName(locationName);
		if (location == null)
			return "locationList";
		
		location.get().increaseBirdSpot(specie);
		
		return "redirect:/birdspotting/" + locationName;
	}

}
