package com.appspot.authagentpro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(detachable="true")
public class Agent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4705882824092036779L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	@Persistent private String name;	//Name of the Agency
	@Element(dependent = "true") 
	private List<Contact> contacts = new ArrayList<Contact>();
	@Element(dependent = "true") 
	private List<String> agencies = new ArrayList<String>();
	
	@Persistent private String email;
	@Persistent private List<Long> subAgents = new ArrayList<Long>();
	@Persistent	private Date createdOn = new Date();	
	@SuppressWarnings("deprecation")
	@Persistent	private Date validUpto = new Date(2012-1900,9-1,31);
	
	public Agent(){}
	Agent(String name, List<Contact> contacts){
		this.name=name;
		this.contacts.addAll(contacts);
	}
	public Agent(String name, ArrayList<Contact> agentContact, String agency, String email) {
		this.setName(name);
		this.contacts=agentContact;
		this.agencies.add(agency);
		this.setEmail(email);
	}
	public String getName() {
		return name;
	}

	public void setName(String agentName) {
		this.name = agentName;
	} 
	public List<String> getAgencies(){
		return agencies;
	}
	public void addAgency(String agency){
		agencies.add(agency);
	}
	public boolean removeAgency(String toRemove){
		ListIterator<String> iter = agencies.listIterator();
		String agency;
		
		while(iter.hasNext()){
			agency=iter.next();
			if (toRemove.equals(agency)){
				agencies.remove(toRemove);
				return true;
			}
		}
		return false;
	}

	public Long getId() {
		return id;
	}
	public String getDefaultAgency(){
		return agencies.get(1);
	}
	public List<Long> getSubAgents() {
		return subAgents;
	}
	public void addSubAgent(SubAgent subAgent) {
		this.subAgents.add(subAgent.getId());
	}
	public void addSubAgent(long subAgent) {
		this.subAgents.add(subAgent);
	}
	public boolean removeSubAgent(SubAgent subAgent){
		ListIterator<Long> iter = subAgents.listIterator();
		long find;
		
		while(iter.hasNext()){
			find = iter.next();
			if(find == subAgent.getId()){
				subAgents.remove(subAgent.getId());
				return true;
			}
		}
		return false;
	}
	public Date getValidUpto() {
		return validUpto;
	}
	public void setValidUpto(Date validUpto) {
		this.validUpto = validUpto;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setDefault(String agency){
		String previous = agencies.get(1);
		agencies.add(1,agency);
		agencies.add(previous);
	}
	
}