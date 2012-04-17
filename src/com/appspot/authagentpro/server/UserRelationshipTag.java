package com.appspot.authagentpro.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.jdo.Query;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import com.appspot.authagentpro.Datastore;
import com.appspot.authagentpro.Request;
import com.appspot.authagentpro.UserRelationship;

public class UserRelationshipTag extends SimpleTagSupport{
	private String filter;
	private String page;
	private String id;
	private String opposite;
	private boolean isAgent;
	
	public void setFilter(String filter){
		this.filter = filter;
	}
	public void setPage(String page){this.page = page;}
	public void setId(String id){this.id = id;}
	public void setOpposite(String opposite){this.opposite = new String(opposite);}
	public void setIsAgent(String isAgent){this.isAgent = Boolean.parseBoolean(isAgent);}
	
	public void doTag(){
		Datastore ds = new Datastore();
		
		if(opposite.equalsIgnoreCase("agent")) isAgent = false;
		else if(opposite.equalsIgnoreCase("sub-agent")) isAgent = true;
		List<UserRelationship> rel = ds.getUserRelationship(filter, id, isAgent);
		
		if(!rel.isEmpty()){
			for(UserRelationship rels: rel){
				getJspContext().setAttribute("relId", rels.getKey());
				getJspContext().setAttribute("userName", rels.getUserName());
				getJspContext().setAttribute("hostName", rels.getHostName());
				getJspContext().setAttribute("isAgent", rels.isAgent());
				getJspContext().setAttribute("isAdmin", rels.isAdmin());
				try {
					getJspBody().invoke(null);
				} catch (JspException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
