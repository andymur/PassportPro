package com.appspot.authagentpro;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class District {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private byte id;
	
	@Persistent
	private String district;
	
	District(byte id, String district){
		this.id=id;
		this.district=district;
	}
	
	public byte getId(){
		return id;
	}
	public void setId(byte id){
		this.id=id;
	}
	
	public String getDistrict(){
		return district;
	}
	public void setDistrict(String district){
		this.district=district;
	}

	public Key getKey() {
		return key;
	}
}