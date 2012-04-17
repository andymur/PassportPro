package com.appspot.authagentpro.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.appspot.authagentpro.Agency;
import com.appspot.authagentpro.Agent;
import com.appspot.authagentpro.Contact;
import com.appspot.authagentpro.PMF;
import com.appspot.authagentpro.ProUser;
import com.appspot.authagentpro.SubAgent;
import com.appspot.authagentpro.UserRelationship;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

public class CreateAgent extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2999757674765875648L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {
		String regType = request.getParameter("regType");
		HttpSession session = request.getSession();
		ProUser proUser = (ProUser)session.getAttribute("proUser");
		Contact agentContact = new Contact(request.getParameter("spoc"), request.getParameter("address"),
				request.getParameter("phone"), request.getParameter("cell"),
				request.getParameter("contEmail"));
		User user = UserServiceFactory.getUserService().getCurrentUser();
		
		if (regType.equalsIgnoreCase("agent")){
			makeAgent(request, response, agentContact, proUser);
			
		}
		else if (regType.equalsIgnoreCase("subAgent")){
			makeSubAgent(request, response, agentContact, proUser);
		}
		response.sendRedirect("userDashboard.jsp");
		
	}

	private void makeAgent(HttpServletRequest request,
			HttpServletResponse response, Contact contact, ProUser proUser) throws ServletException, IOException {

		
		
		ArrayList<Contact> c= new ArrayList<Contact>();
		c.add(contact);
		Agent agent = new Agent(request.getParameter("name"), c, request.getParameter("agency"), request.getParameter("email"));
		
		
		PersistenceManager pm = PMF.get().getPersistenceManager();

		try{
			pm.makePersistent(agent);
			UserRelationship rel = new UserRelationship(proUser, agent.getId().longValue(), agent.getName(), true, true);
			pm.makePersistent(rel);
			} finally{
				pm.close();
			}

		/*PersistenceManager pm2 = PMF.get().getPersistenceManager();
		
		UserRelationship rel = new UserRelationship(user, agent.getId().longValue(), true, true);
		try{
			pm2.makePersistent(rel);
			} finally{
				pm.close();
			}*/
		
				//return agent;
		
	}
	
	
	private void makeSubAgent(HttpServletRequest request,
			HttpServletResponse response, Contact contact,ProUser proUser) {


		SubAgent subAgent = new SubAgent(request.getParameter("name"), contact,  request.getParameter("email"));
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		try{
			pm.makePersistent(subAgent);
			UserRelationship rel = new UserRelationship(proUser, subAgent.getId().longValue(),subAgent.getName(), false, true);
			pm.makePersistent(rel);
			} finally{
				pm.close();
			}
		
				//return subAgent;
	}

}