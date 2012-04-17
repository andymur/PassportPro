package com.appspot.authagentpro;
import java.io.Serializable;
import java.util.Date;
//import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;

@PersistenceCapable(detachable="true")
public class ProUser  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent
	private String key;
	
	@Persistent	private User user;
	@Persistent	private String name = "";
	@Persistent	private Date createdOn = new Date();
	@Persistent private String contact;
	@Persistent private byte offset = 0;
	
	
	public ProUser(User user, String name, String contact){
		this.setUser(user);
		this.setName(name);
		this.setKey(user.getUserId()+"");
		this.setContact(contact);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key=key;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public byte getOffset() {
		return offset;
	}

	public void setOffset(byte offset) {
		this.offset = offset;
	}
}
