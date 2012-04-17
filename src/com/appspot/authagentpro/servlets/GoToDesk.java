package com.appspot.authagentpro.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.appspot.authagentpro.ProUser;
import com.appspot.authagentpro.Agent;
import com.appspot.authagentpro.Datastore;
import com.appspot.authagentpro.SubAgent;


public class GoToDesk extends HttpServlet {

	private static final long serialVersionUID = 6992378701142969128L;
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {
		Datastore ds = new Datastore();
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		session.setAttribute("type",type);
		String id=request.getParameter("id");
		session.setAttribute("role", ds.getRelationship(((ProUser) session.getAttribute("proUser")).getKey(),id ));
		
		if(type.equalsIgnoreCase("agent")){
			Agent agent = ds.getAgentById(id);
			session.setAttribute("master", agent);
			//session.setAttribute("role","Agent");
			session.setAttribute("opposite","Sub-Agent");
			session.setAttribute("selectMap", ds.getSelectMap(type,id,agent.getSubAgents()));
		}
		
		else if(type.equalsIgnoreCase("Sub-Agent")){
			SubAgent subAgent = ds.getSubAgentById(id);
			//session.setAttribute("role","Sub-Agent");
			session.setAttribute("opposite","Agent");
			session.setAttribute("master", subAgent);
			session.setAttribute("selectMap", ds.getSelectMap(type,id,subAgent.getAgents()));
		}
		
		response.sendRedirect("/desk/Search.jsp");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {
		doPost(request, response);
	}
}
