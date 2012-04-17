package com.appspot.authagentpro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class SubAgent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4768547521102116339L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent	private String name;
	@Persistent private String email;
	@Persistent	private List<Long> agents = new ArrayList<Long>();	
	@Persistent	private List<Contact> contacts = new ArrayList<Contact>();
	@Persistent	private Date createdOn = new Date();	
	@SuppressWarnings("deprecation")
	@Persistent	private Date validUpto = new Date(2012-1900,9,31);
	
	SubAgent(){}
	public SubAgent(String name, Contact contact, String email){
		this.setName(name);
		this.contacts.add(contact);
		this.setEmail(email);
	}
	public SubAgent(String name, Contact contact){
		this.setName(name);
		this.contacts.add(contact);
		this.setEmail(contact.getEmails());
	}
	SubAgent(String name, String admin){
		this.setName(name);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String subName) {
		this.name = subName;
	}
	public List<Long> getAgents() {
		return agents;
	}

	public void addAgent(long agent) {
		this.agents.add(agent);
	}
	public void addAgent(Agent agent) {
		this.agents.add(agent.getId());
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void addContacts(Contact contact) {
		this.contacts.add(contact);
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(Date validUpto) {
		this.validUpto = validUpto;
	}
	
	public boolean isValid(){
		Date now = new Date();
		return now.before(getValidUpto());
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean removeAgent(Agent agent) {
		ListIterator<Long> iter = agents.listIterator();
		long find;
		
		while(iter.hasNext()){
			find = iter.next();
			if(find == agent.getId()){
				agents.remove(agent.getId());
				return true;
			}
		}
		return false;
	}
	

}
