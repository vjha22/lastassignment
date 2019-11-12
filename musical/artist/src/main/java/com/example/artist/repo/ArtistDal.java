package com.example.artist.repo;


import java.util.List;

import com.example.artist.model.Artist;



public interface ArtistDal {

	
	public Artist create(Artist art);
	
	public Artist update(Artist art);
	
	public Boolean delete(Artist art);
	
	public List<Artist> findAll();
	
	public Artist findByName(String name);
}

