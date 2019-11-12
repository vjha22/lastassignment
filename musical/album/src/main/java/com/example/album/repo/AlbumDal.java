package com.example.album.repo;


import java.util.List;

import com.example.album.model.Album;



public interface AlbumDal {

	
	public Album create(Album al);
	
	public Album update(Album al);
	
	public Boolean delete(Album al);
	
	public List<Album> findAll();
	
	public Album findByName(String name);
}