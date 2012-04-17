package com.appspot.authagentpro.servlets.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.appspot.authagentpro.Agent;
import com.appspot.authagentpro.Datastore;
import com.appspot.authagentpro.ProUser;
import com.appspot.authagentpro.Request;
import com.appspot.authagentpro.SubAgent;

public class BreakUp extends HttpServlet {



	public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException,ServletException {
		resp.setContentType("text/json");
		HttpSession session = req.getSession();
		ProUser proUser = (ProUser)session.getAttribute("proUser");
		Object master = null;
		PrintWriter out = resp.getWriter();
		JSONObject json=new JSONObject();
		Datastore ds = new Datastore();
		String previous;

		Request request;
		
		try{
			Agent agent; SubAgent subAgent;
			String param = (req.getParameter("oppositeId"));
			HashMap<String, String> selectMap = (HashMap<String, String>) session.getAttribute("selectMap");
			
			master = session.getAttribute("master");
			if(((String) session.getAttribute("opposite")).equalsIgnoreCase("sub-agent")){
				 agent =(Agent) master;
				 subAgent= ds.getSubAgentById(param);
				 previous = selectMap.remove(""+subAgent.getId());
				 //System.out.println(agent.toString()+subAgent+selectMap);
			}
			else{
				 subAgent =(SubAgent) master;
				 agent = ds.getAgentById(param);
				 previous = selectMap.remove(""+agent.getId());
			}
			json = ds.BreakUp(agent, subAgent);
			if(json.getBoolean("SUCCESS")){
				session.setAttribute("selectMap", selectMap);
			}
			
			out.print(json);
			out.flush();
			
			return;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		if(((String) session.getAttribute("opposite")).equalsIgnoreCase("sub-agent")){

			Agent agent = (Agent) master;
			try {
				json = ds.BreakUp(req.getParameter("relId"));
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		else{

			SubAgent subAgent = (SubAgent) master;
			try {
				json = ds.BreakUp(req.getParameter("relId"));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}

		out.print(json);
		out.flush();
		return;
		
	}
}
