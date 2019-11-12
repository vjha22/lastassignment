package com.example.album.controller;

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

import com.example.album.model.Album;

import com.example.album.repo.*;
@RestController
public class AlController {

	@Autowired
	private AlbumDalImplementation repo;

	@RequestMapping(value = "/album", method = RequestMethod.GET, produces = "application/json")
	public List<Album> firstPage() {

		return repo.findAll();
	}

	@PostMapping("/album")
	public void create(@RequestBody Album al) {
		repo.create(al);
		System.out.println(al + " insert");
	}

	@DeleteMapping(path = { "/album/{name}" })
	public Album delete(@PathVariable("name") String name) {
		System.out.println("name " + name);
		Album deletedal = repo.findByName(name);
		System.out.println(deletedal);

		if (repo.delete(deletedal))
			return deletedal;
		else
			return null;
	}

	@PutMapping("/album")
	public Album update(@RequestBody Album al) {
		repo.update(al);

		System.out.println(al + " updated");
		return al;
	}

}

