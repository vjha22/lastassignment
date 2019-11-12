package com.example.album.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Album {
	@Id
	private String id;
	private String name;
	@DBRef
	private List<Artist> al;
	@DBRef
	private List<Track> tr;
	
	public Album() {}

	public Album(String id, String name, List<Artist> al, List<Track> tr) {
		super();
		this.id = id;
		this.name = name;
		this.al = al;
		this.tr = tr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Artist> getAl() {
		return al;
	}

	public void setAl(List<Artist> al) {
		this.al = al;
	}

	public List<Track> getTr() {
		return tr;
	}

	public void setTr(List<Track> tr) {
		this.tr = tr;
	}
	

}
