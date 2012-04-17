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

public class AddUser extends HttpServlet {


	private static final long serialVersionUID = 6683159920203677779L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException,ServletException {
		resp.setContentType("text/json");
		HttpSession session = req.getSession();
		ProUser proUser = (ProUser)session.getAttribute("proUser");
		Object master = session.getAttribute("master");
		PrintWriter out = resp.getWriter();
		JSONObject json=new JSONObject();
		Datastore ds= new Datastore();
		byte type;
		Request request;
		ProUser user = ds.getProUserById(req.getParameter("userid"));
		
		if(null == user){
			try {
				json.put("SUCCESS", false);
				json.put("msg", "This User doesn't exist");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			out.print(json);
			out.flush();
			return;
		}
		
		
		if(((String) session.getAttribute("opposite")).equalsIgnoreCase("sub-agent")){
			type=3;
			Agent agent = (Agent) master;
			request = new Request(type, agent.getId()+"",agent.getName(),user.getKey(),user.getName(),false );
		}
		else{
			type = 4;
			SubAgent agent = (SubAgent) master;
			request = new Request(type, agent.getId()+"",agent.getName(),user.getKey(),user.getName(),false );
		}
		try {
			json = ds.createRequest(request);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.print(json);
		out.flush();
		return;
		
	}

}
