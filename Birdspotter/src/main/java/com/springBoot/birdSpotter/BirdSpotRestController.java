package com.springBoot.birdSpotter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.BirdSpecie;
import domain.BirdSpotLocation;
import domain.SpottedBird;
import service.SpottedBirdService;

@RestController
@RequestMapping(value = "/birds-spotted")
public class BirdSpotRestController {

	@Autowired
	private SpottedBirdService spottedBirdService;

	@GetMapping(value = "/{location}")
	public List<SpottedBird> getAllBirds(@PathVariable("location") String locationName){
		
		List<SpottedBird> spottings = new ArrayList<SpottedBird>();
		Optional<BirdSpotLocation> location = spottedBirdService.findByName(locationName);
		
		spottings = location.get().getSpottedBirds();	
		
		
		return spottings;
	}
}
