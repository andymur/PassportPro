package com.appspot.authagentpro.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.appspot.authagentpro.Agent;
import com.appspot.authagentpro.Contact;
import com.appspot.authagentpro.Datastore;
import com.appspot.authagentpro.SubAgent;
import org.json.*;

public class Add extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2999757674765875648L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException,ServletException {
		response.setContentType("application/json");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		Datastore ds= new Datastore();
		PrintWriter out = response.getWriter();
		JSONObject ans= new JSONObject();
		
		if(type.equalsIgnoreCase("subagent")){
			String id = request.getParameter("id");
			String reply[] = (String[]) ds.requestToSubAgent(id, (Agent)session.getAttribute("master"));
			
			try {
				ans.put("status",reply[0].equalsIgnoreCase("success")?"SUCCESS":"FAILURE");
				ans.put("message",reply[1]);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		else if(type.equalsIgnoreCase("proxy")){
			String name = request.getParameter("name");
			Contact contact = new Contact(request.getParameter("address"),request.getParameter("phone"),request.getParameter("cell"),request.getParameter("email"));
			String id = ds.CreateProxy(name, contact,(Agent)session.getAttribute("master"));
			
			try {
				ans.put("id", id);
				ans.put("name", name);
				ans.put("status", "SUCCESS");
				ans.put("message", "Proxy Sub-Agent Successfully Added, Id: "+id);
				HashMap<String,String> selectMap = (HashMap<String, String>) session.getAttribute("selectMap");
				selectMap.put(id, name);
				session.setAttribute("selectMap", selectMap);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		else if(type.equalsIgnoreCase("agent")){
			String id = request.getParameter("id");
			String reply[] = (String[]) ds.requestToAgent(id, (SubAgent)session.getAttribute("master"));
			try {
				ans.put("status",reply[0].equalsIgnoreCase("success")?"SUCCESS":"FAILURE");
				ans.put("message",reply[1]);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		System.out.println("JSON: "+ans);
		out.print(ans);
		out.flush();
	}
}
