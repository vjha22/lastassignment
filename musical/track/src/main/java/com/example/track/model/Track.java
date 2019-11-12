package com.example.track.model;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Track {
	@Id
	private String id;
	private String name;
@DBRef	
private List<Artist> ar;

public Track() {}

public Track(String id, String name, List<Artist> ar) {
	super();
	this.id = id;
	this.name = name;
	this.ar = ar;
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

public List<Artist> getArr() {
	return ar;
}

public void setArr(List<Artist> arr) {
	this.ar = ar;
}


}
