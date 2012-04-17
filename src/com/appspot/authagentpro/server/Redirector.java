package com.appspot.authagentpro.server;

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


public class Redirector extends HttpServlet {

	private static final long serialVersionUID = 6992378701142969128L;
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {
		doGet(request,response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {	
		response.sendRedirect("/dashboard/UserDashboard");
	}
}