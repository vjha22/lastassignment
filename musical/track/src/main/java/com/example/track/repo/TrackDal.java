package com.example.track.repo;
import java.util.List;

import com.example.track.model.Track;


	
	
	
public interface TrackDal {

		
		public Track create(Track tr);
		
		public Track update(Track tr);
		
		public Boolean delete(Track tr);
		
		public List<Track> findAll();
		
		public Track findByName(String name);
	}


