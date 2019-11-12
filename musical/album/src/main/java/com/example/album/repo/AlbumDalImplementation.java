package com.example.album.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.album.model.Album;


@Repository
public class AlbumDalImplementation implements AlbumDal {

	
	
	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public Album create(Album art) {
		// TODO Auto-generated method stub
		return mongo.insert(art);
	}

	@Override
	public Boolean delete(Album art) {
		// TODO Auto-generated method stub
		return mongo.remove(art).wasAcknowledged();
	}

	@Override
	public List<Album> findAll() {
		// TODO Auto-generated method stub
		return mongo.findAll(Album.class);
	}

	@Override
	public Album findByName(String name) {
		// TODO Auto-generated method stub
		return (Album) mongo.findAndRemove(new Query(Criteria.where("name").is(name)),Album.class);
	}

	@Override
	public Album update(Album al) {
		// TODO Auto-generated method stub
		return mongo.save(al);
	}

}


