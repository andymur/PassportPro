package com.appspot.authagentpro;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(detachable="true")
public class Request {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;
	
	/**************************************************
	* 		Request Type			Status
	* 1 - Agent To SubAgent		0 - Invalid
	* 2 - SubAgent To Agent		1 - Cancelled
	* 3 - Agent to User			2 - Generated
	* 4 - SubAgent to User		3 - Pending
	* 5 - User to Agent			4 - Accepted
	* 6 - User to SubAgent		5 - Denied
	***************************************************/
	
	@Persistent private byte type;
	@Persistent private String from;
	@Persistent private String fromName;
	@Persistent private String to;
	@Persistent private String toName;
	@Persistent private boolean isAdmin;
	@Persistent private byte status=3;
	
	public Request (byte type, String from, String fromName, String to,String toName, boolean isAdmin){
		this.setType(type);
		this.setFrom(from);
		this.fromName = fromName;
		this.setTo(to);
		this.toName = toName;
		this.setIsAdmin(isAdmin);
	}
	
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAgent) {
		this.isAdmin = isAgent;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		if  (status>0 && status<=5)	this.status = status;
		else this.status = 0;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}
	public boolean isOpen(){
		if(this.status ==2 || this.status == 3) return true;
		else return false;
	}
	public boolean checkApprovalRights(String masterId, ProUser proUser){
		if(!this.isOpen()) return false;
		if(this.to.equalsIgnoreCase(masterId) && this.type != 5 && this.type != 6) return true;
		if(this.to.equalsIgnoreCase(proUser.getKey()) && this.type == 5 && this.type == 6) return true;
		else return false;
	}
}
