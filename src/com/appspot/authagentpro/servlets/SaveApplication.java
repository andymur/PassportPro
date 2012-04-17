package com.appspot.authagentpro.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.appspot.authagentpro.Agent;
import com.appspot.authagentpro.Application;
import com.appspot.authagentpro.Datastore;
import com.appspot.authagentpro.ProUser;
import com.appspot.authagentpro.SubAgent;
import org.json.*;

public class SaveApplication extends HttpServlet {
	private static final long serialVersionUID = -6582910545107116579L;
	/**
	 * 
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException,ServletException {
		resp.setContentType("text/json");
		HttpSession session = req.getSession();
		ProUser proUser = (ProUser)session.getAttribute("proUser");
		PrintWriter out = resp.getWriter();
		JSONObject json=new JSONObject();
		Datastore ds= new Datastore();
		Agent agent=new Agent();
		Application application = new Application();
		String savetype = req.getParameter("savetype");
		
		
		// VERIFY AGENT, SUBAGENT
		if(session.getAttribute("opposite").equals("Sub-Agent")){
			agent = (Agent)session.getAttribute("master");
			application.setAgent(agent.getId().toString());
			application.setSubAgent(req.getParameter("Sub-Agent"));
		}
		else{
			
			agent=ds.getAgentById(req.getParameter("Agent"));
			if(null==agent.getId()) {
			
				try {
					json.put("success", false);
					json.put("msg", "The agent you submitted is invalid. You cannot submit a form without a valid agent");
					System.out.print(json);
					out.print(json);
					out.flush();
					return;
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			application.setAgent(req.getParameter("Agent"));
			SubAgent subAgent = (SubAgent)session.getAttribute("master");
			application.setSubAgent(subAgent.getId().toString());
		}
		
		
		
		
		if(savetype.equalsIgnoreCase("updateSubmit")){
			try {
				json = updateSubmit(req,ds,proUser);
			} catch (JSONException e) {e.printStackTrace();}
			out.print(json);
			out.flush();
			return;
		}
		else if (savetype.equalsIgnoreCase("editForm")){
			application = ds.getApplicationById(req.getParameter("formId"));
		}
		
		
		if(!savetype.equalsIgnoreCase("updateSubmit")){
			application.setLoggedBy(proUser.getName()+" ("+proUser.getUser().getEmail()+")" );
			application.setLoggedAt(new java.util.Date());
			application.setType(req.getParameter("applicationType"));
			application.setPoId(req.getParameter("PIA"));
			application.setDistrictId(req.getParameter("district"));
			application.setService(req.getParameter("service"));
			application.setSurname(req.getParameter("surname"));
			application.setName(req.getParameter("name"));
			try{
				if(req.getParameter("isNameChanged").equalsIgnoreCase("nameChange")){
					application.setIsNameChanged(true);
					application.setPreviousName(req.getParameter("previousName"));
				}
			}catch(java.lang.NullPointerException e){e.printStackTrace();}
			
		
			application.setSex(req.getParameter("sex").charAt(0));
			application.setDob(req.getParameter("dob"));
			application.setPob(req.getParameter("pob"));
			application.setPobDistrict(req.getParameter("pobDistrict"));
			
			try{
				application.setQualification(req.getParameter("education"));
			}catch(java.lang.NullPointerException e){e.printStackTrace();}
			
			try{
				application.setProfession(req.getParameter("profession"));
			}catch(java.lang.NullPointerException e){e.printStackTrace();}
			
			application.setVisibleMark(req.getParameter("imark"));
			application.setHeight(req.getParameter("height"));
			application.setResidingSince(req.getParameter("residingSince"));
			
			try{
			application.setPhone(req.getParameter("phone"));
			}catch(java.lang.NullPointerException e){e.printStackTrace();}
			
			try{
			application.setMob(req.getParameter("mob"));
			}catch(java.lang.NullPointerException e){e.printStackTrace();}
			
			try{
				application.setEmail(req.getParameter("email"));
			}catch(java.lang.NullPointerException e){e.printStackTrace();}
				
			application.setPermAddress(new String[] {req.getParameter("presadd1"),req.getParameter("presadd2"),req.getParameter("presadd3")});
			application.setAddress(new String[] {req.getParameter("permadd1"),req.getParameter("permadd2"),req.getParameter("permadd3")});
			
			application.setMaritalStatus(req.getParameter("maritalStatus").charAt(0));
			
			try{
				application.setSpouse(req.getParameter("spouse"));
			}catch(java.lang.NullPointerException e){e.printStackTrace();}
			
			
			application.setFather(req.getParameter("father"));
			application.setMother(req.getParameter("mother"));
			try{
				if(req.getParameter("isAddChange").equalsIgnoreCase("addChange"))
				application.setIsAddChange(true);
			}catch(java.lang.NullPointerException e){e.printStackTrace();}
			
			try{	// this is a problematic block
				application.setFrom(new String[]{req.getParameter("from1"),req.getParameter("from2")});
				//application.setFromYear(new String[]{req.getParameter("fromYear1"),req.getParameter("fromYear2")});
				application.setTo(new String[]{req.getParameter("to1"),req.getParameter("to2")});
				//application.setToYear(new String[]{req.getParameter("toYear1"),req.getParameter("toYear2")});
			
				String[] add1 =  {req.getParameter("prevadd11"),req.getParameter("prevadd12"),req.getParameter("prevadd13")};
				String[] add2 =  {req.getParameter("prevadd21"),req.getParameter("prevadd22"),req.getParameter("prevadd23")};
				application.setPrevAdd1(add1);
				application.setPrevAdd2(add2);
			}catch(java.lang.NullPointerException e){e.printStackTrace();}
			
			try{
				if(req.getParameter("isDD").equalsIgnoreCase("DD"))
				application.setIsDD(true);
			}catch(java.lang.NullPointerException e){e.printStackTrace();}
			
			try{
				application.setDdNo(req.getParameter("ddNO"));
				application.setDdDate(req.getParameter("ddDATE"));
				application.setBank(req.getParameter("bank"));
			}catch(java.lang.NullPointerException e){e.printStackTrace();}
			
			try{
				if(req.getParameter("isRenew").equalsIgnoreCase("renew")){
					application.setIsRenew(true);
				
					application.setOldPassportNo(req.getParameter("oldPassportNo"));
					application.setIssueDate(req.getParameter("oldIssueDate"));
					application.setPlaceOfIssue(req.getParameter("placeOfIssue"));
					application.setOldFileNo(req.getParameter("oldFileNo"));
					application.setExpiry(req.getParameter("oldExpiry"));
				}
			}catch(java.lang.NullPointerException e){e.printStackTrace();}
				
			try{
				application.setFileNo(req.getParameter("fileNo"));
			}catch(Exception e){}
			
			
			application.setLastUpdated(new java.util.Date());
			application.setLastUpdatedBy(proUser.getName()+" ("+proUser.getUser().getEmail()+")");
		}
		
		
		ds.saveApplication(application);
		
		
		String[] names = {"formId","name","surname"};
		json= new JSONObject(application);
		JSONObject temp=new JSONObject(json, names);
		json=temp;
		try {
			json.put("success", true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		out.print(json);
		out.flush();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException,ServletException {
		doPost(req,resp);
		
	}
	
	public JSONObject updateSubmit(HttpServletRequest req, Datastore ds, ProUser proUser) throws JSONException{
		JSONObject json=new JSONObject();
		Application app = ds.getApplicationById(req.getParameter("formId"));
		if(null == app){
			json.put("success", false);
			json.put("msg", "There is something wrong, Update this information from Application");
		}
		else{
			app.setSubmittedAt(new java.util.Date(Long.parseLong(req.getParameter("submissionDate"))));
			app.setOnlineFileNo(req.getParameter("onlineFileNo"));
			app.setSubmittedBy(proUser.getName()+" ("+proUser.getUser().getEmail()+")");
			
			ds.saveApplication(app);
			json.put("success", true);
			json.put("msg", "Information successfully updated");
		}
		return json;
		
	}
}
