package com.appspot.authagentpro.server;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class SelectMapTag extends SimpleTagSupport{
	private HashMap<String,String> map;

	public void setMap(HashMap<String,String> map){
		this.map = map;
	}
	
	public void doTag(){
		if(!map.isEmpty()){
			//getJspContext().setAttribute("agentMap", agentMap,PageContext.SESSION_SCOPE);
			for(String key: map.keySet()){
				getJspContext().setAttribute("value", key);
				getJspContext().setAttribute("name", map.get(key));
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
