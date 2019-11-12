package com.example.track.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.track.model.Track;

import com.example.track.repo.*;
@RestController
public class TrController {

	@Autowired
	private TrackDalImplementation repo;

	@RequestMapping(value = "/track", method = RequestMethod.GET, produces = "application/json")
	public List<Track> firstPage() {

		return repo.findAll();
	}

	@PostMapping("/track")
	public void create(@RequestBody Track al) {
		repo.create(al);
		System.out.println(al + " insert");
	}

	@DeleteMapping(path = { "/track/{name}" })
	public Track delete(@PathVariable("name") String name) {
		System.out.println("name " + name);
		Track deletedal = repo.findByName(name);
		System.out.println(deletedal);

		if (repo.delete(deletedal))
			return deletedal;
		else
			return null;
	}

	@PutMapping("/album")
	public Track update(@RequestBody Track al) {
		repo.update(al);

		System.out.println(al + " updated");
		return al;
	}

}

