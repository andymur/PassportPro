package com.appspot.authagentpro;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Key;
import java.util.List;

@PersistenceCapable
public class PO {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String id;
	
	@Persistent
	private String name;
	
	@Persistent
	private List<District> districts;
	
	PO(String id, String name){
		this.id=id;
		this.name=name;
	}
	
	public String getValue(){
		return id;
	}
	public void setValue(String id){
		this.id=id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name= name;
	}
	
	public void addDistrict (District district){
		districts.add(district);
	}
	
	public List<District> getDistricts(){
		return districts;
	}

	public Key getKey() {
		return key;
	}

}
