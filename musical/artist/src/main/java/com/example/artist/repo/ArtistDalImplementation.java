package com.example.artist.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.artist.model.Artist;


@Repository
public class ArtistDalImplementation implements ArtistDal {

	
	
	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public Artist create(Artist art) {
		// TODO Auto-generated method stub
		return mongo.insert(art);
	}

	@Override
	public Boolean delete(Artist art) {
		// TODO Auto-generated method stub
		return mongo.remove(art).wasAcknowledged();
	}

	@Override
	public List<Artist> findAll() {
		// TODO Auto-generated method stub
		return mongo.findAll(Artist.class);
	}

	@Override
	public Artist findByName(String name) {
		// TODO Auto-generated method stub
		return (Artist) mongo.findAndRemove(new Query(Criteria.where("name").is(name)),Artist.class);
	}

	@Override
	public Artist update(Artist art) {
		// TODO Auto-generated method stub
		return mongo.save(art);
	}

}


