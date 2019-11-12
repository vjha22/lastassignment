package com.example.track.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.track.model.Track;


@Repository
public class TrackDalImplementation implements TrackDal {

	
	
	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public Track create(Track tr) {
		// TODO Auto-generated method stub
		return mongo.insert(tr);
	}

	@Override
	public Boolean delete(Track tr) {
		// TODO Auto-generated method stub
		return mongo.remove(tr).wasAcknowledged();
	}

	@Override
	public List<Track> findAll() {
		// TODO Auto-generated method stub
		return mongo.findAll(Track.class);
	}

	@Override
	public Track findByName(String name) {
		// TODO Auto-generated method stub
		return (Track) mongo.findAndRemove(new Query(Criteria.where("name").is(name)),Track.class);
	}

	@Override
	public Track update(Track tr) {
		// TODO Auto-generated method stub
		return mongo.save(tr);
	}

}


