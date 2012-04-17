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

public class RequestTag extends SimpleTagSupport{
	private String from;
	private String to;
	private String page;
	private String id;
	private String fromto;

	public void setTo(String to){
		this.to = to;
	}
	public void setFrom(String from){this.from = from;}
	public void setPage(String page){this.page = page;}
	public void setId(String id){this.id = id;}
	public void setFromto(String fromto){this.fromto = fromto;}
	
	public void doTag(){
		Datastore ds = new Datastore();
		byte type=0;
		if(page.equalsIgnoreCase("manage")){
			
			String opposite = (String) getJspContext().getAttribute("opposite", PageContext.SESSION_SCOPE);
			
			/*
			 * This is an Agent
			 */
			if(opposite.equalsIgnoreCase("sub-agent")){
				if(to.equalsIgnoreCase("opposite")) {type=1;}
				else if(to.equalsIgnoreCase("user")){type=3;}
				else if(to.equalsIgnoreCase("master")){type=2;}
			}
			/*
			 * This is a Sub-Agent
			 */			
			else if(opposite.equalsIgnoreCase("Agent")){
				if(to.equalsIgnoreCase("opposite")) {type=2;}
				else if(to.equalsIgnoreCase("user")){type=4;}
				else if(to.equalsIgnoreCase("master")){type=1;}
			}
			
		}else if(page.equalsIgnoreCase("userDashboard")){
			if(from.equalsIgnoreCase("User")){
				if(to.equalsIgnoreCase("agent")) {type=5;}
				else if(to.equalsIgnoreCase("sub-agent")){type=6;}
			}else if(to.equalsIgnoreCase("user")){
				if(to.equalsIgnoreCase("agent")) {type=2;}
				else if(to.equalsIgnoreCase("sub-agent")){type=3;}
			}
		}
		List<Request> requests = ds.getRequests(fromto, id, type);
		requests.size();
		if(!requests.isEmpty()){
			for(Request req: requests){
				getJspContext().setAttribute("requestId", req.getKey());
				getJspContext().setAttribute("from", req.getFrom());
				getJspContext().setAttribute("to", req.getTo());
				getJspContext().setAttribute("fromName", req.getFromName());
				getJspContext().setAttribute("toName", req.getToName());
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
