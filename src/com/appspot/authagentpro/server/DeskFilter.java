package com.appspot.authagentpro.server;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.appspot.authagentpro.Datastore;
import com.appspot.authagentpro.ProUser;
import com.google.appengine.api.users.UserServiceFactory;

public class DeskFilter implements Filter{
	
	public void destroy() {}
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
    	HttpSession session = request.getSession();
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//com.google.appengine.api.users.UserService userService = UserServiceFactory.getUserService();
    	//com.google.appengine.api.users.User user= userService.getCurrentUser();
    	//if (null == user) response.sendRedirect(userService.createLoginURL("/dashboard/UserDashboard"));

    	if(null == session.getAttribute("master")) 
    		response.sendRedirect("/dashboard/UserDashboard");
    	
    	chain.doFilter(req, resp);
	}


	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
