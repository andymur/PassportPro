package com.appspot.authagentpro.servlets;

import java.io.IOException;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.appspot.authagentpro.Application;
import com.appspot.authagentpro.PMF;
import com.appspot.authagentpro.ProUser;
import com.appspot.authagentpro.UserBean;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class ProcessForm extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2273091392466460965L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {
		String regType = request.getParameter("regType");
		
		if (regType.equalsIgnoreCase("user")){
			ProUser proUser = registerUser(request, response);
			if (null != proUser) request.getSession().setAttribute("proUser", proUser);
			response.sendRedirect("/dashboard/userDashboard.jsp");
		}
	}
	
	
	private ProUser registerUser(HttpServletRequest request,
			HttpServletResponse response) {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		
		ProUser proUser = new ProUser(user,request.getParameter("name"),request.getParameter("contactNum"));
		proUser.setCreatedOn(new java.util.Date());
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try{
			pm.makePersistent(proUser);
			} finally{
				pm.close();
			}
		return proUser;		
	}

}
