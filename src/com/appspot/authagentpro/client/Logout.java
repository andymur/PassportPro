package com.appspot.authagentpro.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class Logout extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1213775434036458721L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {
		UserService userService = UserServiceFactory.getUserService();
		
		request.getSession().invalidate();
		response.sendRedirect(userService.createLogoutURL("/PassportPro.jsp"));
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {
		doPost(request, response);
	}
}
