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



public class AdminFilter implements Filter{


	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
    	HttpSession session = request.getSession();
		HttpServletResponse response = (HttpServletResponse) resp;
    	ProUser proUser = (ProUser)session.getAttribute("proUser");
    	String role = (String) session.getAttribute("role");
    	
    	
    	
    	if(role.equalsIgnoreCase("Admin"))	chain.doFilter(req, resp);
	}


	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
