package com.appspot.authagentpro.server;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.*;
import com.appspot.authagentpro.Datastore;
import com.appspot.authagentpro.SubAgent;

public class SubAgentTag extends SimpleTagSupport{
	private String userId;

	public void setUserId(String userId){
		this.userId = userId;
	}
	
	public void doTag(){
		Datastore ds = new Datastore();
		HashMap<SubAgent,Boolean> subAgentMap = (HashMap<SubAgent,Boolean>) ds.getSubAgentsForUser(userId);
		if(!subAgentMap.isEmpty()){
			//getJspContext().setAttribute("subAgentMap", subAgentMap,PageContext.SESSION_SCOPE);
			for(SubAgent subAgent : subAgentMap.keySet()){

				getJspContext().setAttribute("subAgent", subAgent);
				getJspContext().setAttribute("isAdmin", subAgentMap.get(subAgent));
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
