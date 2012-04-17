package com.appspot.authagentpro;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

@PersistenceCapable(detachable="true")
public class Agency implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2040024594283433159L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent private String name;
	@Persistent private String owner;
	@Persistent private List<Contact> contacts;
	@Persistent private String createdBy;
	
	Agency(String name, User createdBy){
		this.setName(name);
		this.setCreatedBy(createdBy.toString());
	}
	public Agency(String name, String createdBy){
		this.setName(name);
		this.setCreatedBy(createdBy.toString());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void addContacts(Contact contact) {
		this.contacts.add(contact);
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy.toString();
	}
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}

}
