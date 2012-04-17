package com.appspot.authagentpro.servlets.manage;

import java.io.IOException;
import java.io.PrintWriter;

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

public class ApproveRequest extends HttpServlet {



	public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException,ServletException {
		resp.setContentType("text/json");
		HttpSession session = req.getSession();
		ProUser proUser = (ProUser)session.getAttribute("proUser");
		Object master = null;
		PrintWriter out = resp.getWriter();
		JSONObject json=new JSONObject();
		Datastore ds= new Datastore();

		Request request;
		
		try{
			 master = session.getAttribute("master");
		}catch(Exception e){}
		
		if(null == master){
			try {
				json = ds.ApproveRequest(req.getParameter("requestId"),"","", proUser);
			} catch (JSONException e) {}
			out.print(json);
			out.flush();
			return;
		}
		
		
		if(((String) session.getAttribute("opposite")).equalsIgnoreCase("sub-agent")){

			Agent agent = (Agent) master;
			try {
				json = ds.ApproveRequest(req.getParameter("requestId"), agent.getId()+"", agent.getName(), proUser);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{

			SubAgent agent = (SubAgent) master;
			try {
				json = ds.ApproveRequest(req.getParameter("requestId"), agent.getId()+"",agent.getName(), proUser);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		out.print(json);
		out.flush();
		return;
		
	}
}
