package com.example.artist.controller;
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

import com.example.artist.model.Artist;
import com.example.artist.repo.ArtistDalImplementation;

@RestController
public class ArController {

	@Autowired
	private ArtistDalImplementation repo;

	@RequestMapping(value = "/artist", method = RequestMethod.GET, produces = "application/json")
	public List<Artist> firstPage() {

		return repo.findAll();
	}

	@PostMapping("/artist")
	public void create(@RequestBody Artist al) {
		repo.create(al);
		System.out.println(al + " insert");
	}

	@DeleteMapping(path = { "/artist/{name}" })
	public Artist delete(@PathVariable("name") String name) {
		System.out.println("name " + name);
		Artist deletedal = repo.findByName(name);
		System.out.println(deletedal);

		if (repo.delete(deletedal))
			return deletedal;
		else
			return null;
	}

	@PutMapping("/artist")
	public Artist update(@RequestBody Artist al) {
		repo.update(al);

		System.out.println(al + " updated");
		return al;
	}

}

