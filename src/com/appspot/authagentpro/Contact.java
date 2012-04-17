package com.appspot.authagentpro;
import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;


@PersistenceCapable
public class Contact implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key key;
	
	@Persistent
	private String type;
	
	@Persistent
	private String spoc;
	
	@Persistent
	private String address;
	
	@Persistent
	private String phone;
	
	@Persistent
	private String cell;
	
	@Persistent
	private String emails;
	
	public Contact(){}
	
	public Contact(String address, String phone, String cell, String emails){
		this.setType(type);
		this.address=address;
		this.phone=phone;
		this.cell=cell;
		this.setEmails(emails);
	}
	public Contact(String spoc, String address, String phone, String cell, String emails){
		this.spoc=spoc;
		this.address=address;
		this.phone=phone;
		this.cell=cell;
		this.setEmails(emails);
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getSpoc() {
		return spoc;
	}

	public void setSpoc(String spoc) {
		this.spoc = spoc;
	}
	public String getEmails() {
		return emails;
	}
	public void setEmails(String emails) {
		this.emails = emails;
	}

	public Key getKey() {
		return key;
	}
}
