package com.example.album.model;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Artist {
	@Id
	private String id;
	private String name;
	@DBRef
	private List<Album> al =new ArrayList<>();
	@DBRef
	private List<Track> tr =new ArrayList<>();
	
	public Artist(){}

	public Artist(String id, String name, List<Album> al, List<Track> tr) {
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

	public List<Album> getAl() {
		return al;
	}

	public void setAl(List<Album> al) {
		this.al = al;
	}

	public List<Track> getTr() {
		return tr;
	}

	public void setTr(List<Track> tr) {
		this.tr = tr;
	}
	
	
}

