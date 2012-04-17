package com.appspot.authagentpro.server;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.*;
import com.appspot.authagentpro.Agent;
import com.appspot.authagentpro.Datastore;

public class AgentTag extends SimpleTagSupport{
	private String userId;

	public void setUserId(String userId){
		this.userId = userId;
	}

	
	public void doTag(){
		Datastore ds = new Datastore();
		//System.out.println("in AgentTag"+userId);
		HashMap<Agent, Boolean> agentMap = (HashMap<Agent, Boolean>) ds.getAgentsForUser(""+userId);
		if(!agentMap.isEmpty()){
			//getJspContext().setAttribute("agentMap", agentMap,PageContext.SESSION_SCOPE);
			for(Agent agent: agentMap.keySet()){
				getJspContext().setAttribute("agent", agent);
				getJspContext().setAttribute("isAdmin", agentMap.get(agent));
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
