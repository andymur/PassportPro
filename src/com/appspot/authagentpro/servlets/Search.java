package com.appspot.authagentpro.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.appspot.authagentpro.Agent;
import com.appspot.authagentpro.Application;
import com.appspot.authagentpro.PMF;
import com.appspot.authagentpro.SubAgent;

public class Search extends HttpServlet {
	
	private static final long serialVersionUID = 2111109932395576844L;

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException,ServletException {
		
		resp.setContentType("application/json");
		JSONObject reply = new JSONObject();
		HttpSession session = req.getSession();
		//ProUser proUser = (ProUser)session.getAttribute("proUser");
		PrintWriter out = resp.getWriter();
		Application app = new Application();
		List<Application> rs; 
		JSONArray array = new JSONArray();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Agent agent; SubAgent subAgent; 
		String opposite=(String) session.getAttribute("opposite");
		String masterId;
		String master;
		String temp = "";
		String id = null;
		
		if(opposite.equals("Sub-Agent")){
			agent = (Agent)session.getAttribute("master");
			master="agent";
			opposite="subAgent";
			masterId=agent.getId().toString();
			
		}
		else{
			subAgent = (SubAgent)session.getAttribute("master");
			master="subAgent";
			opposite="agent";
			masterId=subAgent.getId().toString();
		}
		
		
		id = req.getParameter("formId");
		
		
		if(id.length()>0){
			try{
				app = pm.getObjectById(Application.class,Long.parseLong(id));
				
				if(app.getAgent().equals(masterId) || app.getSubAgent().equals(masterId)){
					reply=new JSONObject();
					try {
						reply.put("Found", true);
						reply.put("msg", "1 Result found");
						array.put(new JSONObject(app));
						reply.put("rs", array);
					} catch (JSONException e) {}
				}
				else{
					try {
						reply.put("Found", false);
						reply.put("msg", "You are not authorized to view this Application Form");
					} catch (JSONException e) {}
				}
			}catch(Exception ex){
				try {
					reply.put("Found", false);
					reply.put("msg", "This form Id doesn\'t exist");
				
				} catch (JSONException e) {}
				
			}
		}
				
		Query q = pm.newQuery(Application.class);
		String filter= master+"=='"+masterId+"' ";
		
		if(!(id.length()>0)){

		try{
			temp=req.getParameter("opposite");
			if(temp.length()>0 && !temp.equals("!valid")){
			filter += "&& "+opposite+"=='"+temp+"' ";
		}
		}catch(NullPointerException e1){}
		
		try{
			temp=req.getParameter("surname");
			if(temp.length()>0 && !temp.equals("!valid"))
			filter += "&& surname=='"+temp+"' ";
		}catch(NullPointerException e1){}
		
		try{
			temp=req.getParameter("name");
			if(temp.length()>0 && !temp.equals("!valid"))
			filter += "&& name=='"+temp+"' ";
		}catch(NullPointerException e1){}
		
		try{
			temp=req.getParameter("sex");
			if(temp.length()>0 && !temp.equals("!valid"))
			filter += "&& sex=='"+temp.charAt(0)+"' ";
		}catch(NullPointerException e1){}
		
		try{
			temp=req.getParameter("dob");
			if(temp.length()>0 && !temp.equals("!valid"))
			filter += "&& dob=='"+temp+"' ";
		}catch(NullPointerException e1){}
		
		try{
			temp=req.getParameter("loggedAtFrom");
			if(temp.length()>0 )
			filter += "&& loggedAt>= "+temp+" ";
		}catch(NullPointerException e1){}
		try{
			temp=req.getParameter("loggedAtTo");
			if(temp.length()>0)
			filter += "&& loggedAt<= "+temp+" ";
		}catch(NullPointerException e1){}
		
		try{
			temp=req.getParameter("submittedAt");
			if(temp.length()>0 && !temp.equals("!valid"))
			filter += "&& submittedAt >= "+temp+" ";
		}catch(NullPointerException e1){}
		try{
			temp=req.getParameter("submittedAtTo");
			if(temp.length()>0 && !temp.equals("!valid"))
			filter += "&& submittedAt <="+temp+" ";
		}catch(NullPointerException e1){}
		
		try{
			temp=req.getParameter("PIA");
			if(temp.length()>0 && !temp.equals("!valid"))
			filter += "&& poId=='"+temp+"' ";
		}catch(NullPointerException e1){}
		
		try{
			temp=req.getParameter("district");
			if(temp.length()>0 && !temp.equals("!valid") && !temp.equals("-1"))
			filter += "&& districtId=='"+temp+"' ";
		}catch(NullPointerException e1){}
		
		try{
			temp=req.getParameter("service");
			if(temp.length()>0 && !temp.equals("!valid"))
			filter += "&& service=='"+temp+"' ";
		}catch(NullPointerException e1){}
		
			q.setFilter(filter);
			
			System.out.println(q);
			try{
				rs =  (List<Application>) q.execute();
				if(!rs.isEmpty()){
					array = new JSONArray();
					Iterator<Application> iterator = rs.iterator();
					while(iterator.hasNext()){
						array.put(new JSONObject(iterator.next()));
					}
					reply.put("Found", true);
					reply.put("msg", array.length()+" results fetched");
					reply.put("rs",array);
				}
				else{
					try {
						reply.put("Found", false);
						reply.put("msg", "No application found with selected criterion");
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}catch(Exception e2){
				try {
					reply.put("Found", false);
					reply.put("msg", "No application found with selected criterion");
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}finally{
				pm.close();
			}
		}
		
		

		System.out.println(reply);
		out.print(reply);
		out.flush();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException,ServletException {
		doPost(req,resp);
	}
}