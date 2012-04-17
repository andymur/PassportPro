package com.appspot.authagentpro;
import javax.jdo.PersistenceManager;
import com.google.appengine.api.users.*;

public class UserBean {

	public UserBean(){}
	
	public ProUser getProUser(User user){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		ProUser proUser = null;
		try{
		proUser= pm.getObjectById(ProUser.class, user.getUserId());
		} catch(javax.jdo.JDOObjectNotFoundException e){}
		if (null == proUser) return null;
		else return proUser;
	}
}
