package com.appspot.authagentpro.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.appspot.authagentpro.Application;
import com.appspot.authagentpro.Datastore;

public class SearchForm extends HttpServlet {
	
	private static final long serialVersionUID = 2111109932395576844L;

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException,ServletException {
		resp.setContentType("application/json");
		Datastore ds=new Datastore();
		PrintWriter out = resp.getWriter();
		JSONObject reply = new JSONObject();
		JSONArray array = new JSONArray();
		String id = req.getParameter("formId");
		log(id);
		Application app = ds.getApplicationById(id);
		if(null!=app){
			try {
				reply.put("Found", true);
				reply.put("msg", "1 Result found");
				array.put(new JSONObject(app));
				reply.put("rs", array);
			} catch (Exception e) {}
		}
		else{
			try {
				reply.put("Found", false);
				reply.put("msg", "This form Id doesn't exist");
			}catch (Exception e) {}
		}
		out.print(reply);
		out.flush();
		
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException,ServletException {
		doPost(req,resp);
		
		
	}
	
}