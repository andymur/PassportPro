package com.appspot.authagentpro;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.users.User;

@PersistenceCapable(detachable="true")
public class UserRelationship {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long key;

	@Persistent private String userId;
	@Persistent private String userName;
	@Persistent private String hostId;
	@Persistent private String hostName;
	@Persistent private boolean isAgent;
	@Persistent private boolean isAdmin=false;
	
	public UserRelationship(ProUser proUser, long host, String hostName, boolean agent, boolean admin){
		this.setUserId(proUser.getKey());
		this.setUserName(proUser.getName());
		this.setHostId(host);
		this.setHostName(hostName);
		this.setAgent(agent);
		this.setAdmin(admin);
	}
	public UserRelationship(String userId, String userName, long host, String hostName, boolean agent, boolean admin){
		this.setUserId(userId);
		this.setUserName(userName);
		this.setHostId(host);
		this.setHostName(hostName);
		this.setAgent(agent);
		this.setAdmin(admin);
	}

	public long getKey() {
		return key;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String user) {
		this.userId = user;
	}
	
	public String getUserIdLong() {
		return userId;
	}
	
	public String getHostId() {
		return hostId;
	}
	public void setHostId(long host) {
		this.hostId = host+"";
	}
	public boolean isAgent() {
		return isAgent;
	}
	public void setAgent(boolean isAgent) {
		this.isAgent = isAgent;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public boolean checkAdminRights(String id){
		if(id.equals(hostId) || id.equals(userId)) return true;
		else return false;
	}

}
