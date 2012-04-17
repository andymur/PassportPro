package com.appspot.authagentpro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.Transactional;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.appengine.api.users.User;


public class Datastore {
	
	
	public Datastore(){};
	
	@SuppressWarnings("unchecked")
	public HashMap<Agent, Boolean> getAgentsForUser(String user){
		HashMap<Agent, Boolean> relMap = new HashMap<Agent,Boolean>();
		List<Agent> agents = new ArrayList<Agent>();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(UserRelationship.class);
		Query q2 = pm.newQuery(Agent.class);
		q.setFilter("userId == userParam && isAgent == true");
		q.setOrdering("isAdmin asc");
		q.declareParameters("String userParam");
		//System.out.println("User: "+user+"\nAgent Query: "+q);
		try{
			
			List<UserRelationship> relations = (List<UserRelationship>) q.execute(user);
			//System.out.println("AgentRelationsFetched: "+relations);
			if(!relations.isEmpty()){
				List<Long> hosts = new ArrayList<Long>();
				for (UserRelationship rel: relations){
					//System.out.println("Agent"+rel.getHost());
					hosts.add(Long.parseLong(rel.getHostId()));
				}
				q2 = pm.newQuery(Agent.class);
				q2.setFilter("hostId.contains(this.id)");
				q2.declareParameters("Long hostId");
				
				agents= (List<Agent>) q2.execute(hosts);
				
				for(Agent a: agents){
					for(UserRelationship rel: relations){
						if (a.getId() == Long.parseLong(rel.getHostId())) relMap.put(a, rel.isAdmin());
					}
				}
			}
		}
		finally{
			q.closeAll();q2.closeAll();pm.close();
		}

		return relMap;
	}

	@SuppressWarnings("unchecked")
	public HashMap<SubAgent, Boolean> getSubAgentsForUser(String user){
		HashMap<SubAgent, Boolean> relMap = new HashMap<SubAgent, Boolean>();
		List<SubAgent> subAgents = new ArrayList<SubAgent>();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(UserRelationship.class);
		Query q2 = pm.newQuery(SubAgent.class);
		q.setFilter("userId == userParam && isAgent == false");
		q.setOrdering("isAdmin desc");
		q.declareParameters("String userParam");
		//System.out.println("SubAgent Query: "+q);
		
		try{
			List<UserRelationship> relations = (List<UserRelationship>) q.execute(user);
			//System.out.println("SubAgentrelations Fetched: "+relations);
			if(!relations.isEmpty()){
				List<Long> hosts = new ArrayList<Long>();
				for (UserRelationship rel: relations){
					//System.out.println("Subagent"+rel.getHost());
					hosts.add(Long.parseLong(rel.getHostId()));
				}

				q2.setFilter("hostId.contains(this.id)");
				q2.declareParameters("Long hostId");
				
				subAgents= (List<SubAgent>) q2.execute(hosts);
				for(SubAgent s: subAgents){
					for(UserRelationship rel: relations){
						if (s.getId() == Long.parseLong(rel.getHostId())) relMap.put(s, rel.isAdmin());
					}
				}
			}
		}
		finally{
			q.closeAll();q2.closeAll();
		}
		return relMap;
	}

	public Agent getAgentById(String id){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Agent agent = null;
		try{
			agent = pm.getObjectById(Agent.class,Long.parseLong(id));
			return pm.detachCopy(agent);
		}catch(Exception e){
			//agent=new Agent();
		}finally{
			pm.close();
		}
		return agent;	
	}

	public SubAgent getSubAgentById(String id) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			SubAgent subAgent = pm.getObjectById(SubAgent.class,Long.parseLong(id));
			return pm.detachCopy(subAgent);
		}catch(Exception e){
			return null;
		}
		finally{
			pm.close();
		}
		
	}

	public ProUser getProUser(User user){
		
		ProUser proUser = null;
		return getProUserById(user.getUserId());
		
	}
	public ProUser getProUserById(String id){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		ProUser proUser = null;
		try{
			proUser= pm.getObjectById(ProUser.class, id);
			} catch(javax.jdo.JDOObjectNotFoundException e){}
			return proUser;
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, String> getSelectMap(String type, String id, List<Long> list){
		HashMap<String,String> selectMap = new HashMap<String, String>();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		if (list.isEmpty()) {
			selectMap.put("-1","None Added");
		}
		else{
		
		
		
		if (type.equalsIgnoreCase("agent")){
			Query q = pm.newQuery(SubAgent.class);
			q.setFilter("list.contains(this.id)");
			q.declareParameters("Long list");
			System.out.println(q);
			
			List <SubAgent> subAgents= (List<SubAgent>) q.execute(list);
			Iterator<SubAgent> iterator = subAgents.iterator();
			while(iterator.hasNext()){
				SubAgent s = iterator.next();
				selectMap.put(s.getId().toString(), s.getName());
			}
		}
		else if (type.equalsIgnoreCase("subagent") || type.equalsIgnoreCase("sub-agent")){
			Query q = pm.newQuery(Agent.class);
			q.setFilter("ids.contains(this.id)");
			q.declareParameters("Long ids");
			System.out.println(q);
			List <Agent> Agents= (List<Agent>) q.execute(list);
			Iterator<Agent> iterator = Agents.iterator();
			while(iterator.hasNext()){
				Agent a = iterator.next();
				selectMap.put(a.getId().toString(), a.getName());
			}
		}
		}
		return selectMap;
	}


	public String[] requestToSubAgent(String str, Agent agent) {
		long id = Long.parseLong(str);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		SubAgent subAgent = null;
		String[] reply = new String[2];
		reply[0] = "Failure";
		List<Long> subAgents = agent.getSubAgents();
		if (subAgents.contains(id)){
			reply[1] = "You Already have this Sub-Agent Added";
			return reply;
		}
		else{
			
			try{
				subAgent = pm.getObjectById(SubAgent.class, id);
			}catch(Exception e){
				//e.printStackTrace();
			}
			if(null == subAgent){
				reply[1] = "No Sub-Agent found with given Id "+id;
				return reply;
			}
			Query q = pm.newQuery(Request.class), q2 = pm.newQuery(Request.class);
			q.setFilter("from == f && to == t && type==1 && status==3");
			q2.setFilter("from == t && to == f && type==2 && status==3");
			q.declareParameters("String f, String t");
			try{
				List<Request> existing = (List<Request>) q.execute(agent.getId().toString(),subAgent.getId().toString());
				if((existing.size()>0)){
					reply[1] = "This request has already been made by you for Sub-Agent "+subAgent.getName()+". Request Number: "+existing.get(0).getKey();
					return reply;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				List<Request> existing2 = (List<Request>)  q2.execute(agent.getId().toString(),subAgent.getId().toString()); 
				if((existing2.size()>0)){
					reply[1] = "This request has already been made by Sub-Agent "+subAgent.getName()+". Request Number: "+existing2.get(0).getKey();
					return reply;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			Request r = new Request((byte)1,agent.getId().toString(),agent.getName(),subAgent.getId().toString(),subAgent.getName(),false);
			
			try{
				pm.makePersistent(r);
				reply[0] = "SUCCESS";
				reply[1] = "Request Sent to Sub-Agent vide: "+r.getKey();
			}finally{
				pm.close();
			}
		}
		return reply;
	}

	public String CreateProxy(String name, Contact contact, Agent agent) {
		SubAgent sub = new SubAgent(name,contact);
		sub.addAgent(agent);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		//PersistenceManager pm2 = PMF.get().getPersistenceManager();
		try{
			Agent a = (Agent) pm.getObjectById(Agent.class, agent.getId());
			pm.makePersistent(sub);
			a.addSubAgent(sub);
			pm.makePersistent(a);
			agent.addSubAgent(sub);
		}finally{
			pm.close();
		}
		return sub.getId().toString();
	}

	public String[] requestToAgent(String str, SubAgent subAgent) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		long id = Long.parseLong(str);
		Agent agent = null;
		String[] reply = new String[2];
		reply[0] = "Failure";
		List<Long> agents = subAgent.getAgents();
		if (agents.contains(id)){
			reply[1] = "You Already have this Agent Added";
			return reply;
		}
		else{
			
			try{
			agent = pm.getObjectById(Agent.class, id);
			}catch(Exception e){
				//e.printStackTrace();
			}
			if(null == agent){
				reply[1] = "No Agent found with given Id "+id;
				return reply;
			}
			Query q = pm.newQuery(Request.class), q2 = pm.newQuery(Request.class);
			q.setFilter("from == f && to == t && type==2 && status==3");
			q2.setFilter("from == t && to == f && type==1 && status==3");
			q.declareParameters("String f, String t");
			try{
				List<Request> existing = (List<Request>) q.execute(subAgent.getId().toString(),agent.getId().toString());
				if((existing.size()>0)){
					reply[1] = "This request has already been made either by you for Agent "+agent.getName()+". Request Number: "+existing.get(0).getKey();
					return reply;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			try{
				List<Request> existing2 = (List<Request>) q2.execute(subAgent.getId().toString(),agent.getId().toString());
				if((existing2.size()>0)){
					reply[1] = "This request has already been made to you by Agent  "+agent.getName()+". Request Number: "+existing2.get(0).getKey();
					return reply;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			Request r = new Request((byte)2,subAgent.getId().toString(),subAgent.getName(),agent.getId().toString(),agent.getName(),false);
			try{
				pm.makePersistent(r);
				reply[0] = "Success";
				reply[1] = "Request Sent to Agent Request Id: "+r.getKey();
			}finally{
				pm.close();
			}
		}
		return reply;
	}

	public String getRelationship(String userId, String masterIdString) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		//long id = Long.parseLong(masterIdString);
		
		Query q = pm.newQuery(UserRelationship.class);
		q.setFilter("userId == '"+userId+"' && hostId == '"+masterIdString+"'");
		//q.declareParameters("String u, String h");
		System.out.print(q);
		UserRelationship rel=null;
		try{
			List<UserRelationship> results =  (List<UserRelationship>) q.execute(/*key,id*/);
			rel=results.get(0);
			return rel.isAdmin()?"Admin":"User";
		}finally{
			pm.close();
		}
	}
	
	public Application getApplicationById(String id){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Application app,detached=null;
		try{
			app=pm.getObjectById(Application.class,Long.parseLong(id));
			detached = pm.detachCopy(app);
		}
		catch(Exception e){
			app=null;
			return app;
		}finally{pm.close();}
		return detached;
	}
	public void saveApplication(Application app){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(app);
			} finally{
				pm.close();
			}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Request> getRequests(String fromto, String id, byte type){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		List<Request> requests = new ArrayList();
		List<Request> detached = null;
		Query q = pm.newQuery(Request.class);
		q.setFilter(fromto+" == '"+id+"' && type == "+type+" && status == 3");
		
		try{
			requests = (List<Request>) q.execute();
			detached = (List<Request>) pm.detachCopyAll(requests);
		}finally{
			pm.close();
		}
		return detached;
	}
	@Transactional
	public List<UserRelationship> getUserRelationship(String filter, String filterId, boolean isAgent){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(UserRelationship.class);
		q.setFilter(filter+" == filterId && isAgent == isAgentValue");
		q.declareParameters("long filterId, boolean isAgenValue");
		
		try{
			List<UserRelationship> rel = (List<UserRelationship>) q.execute(filterId, isAgent);
			int temp = rel.size();
			return rel;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pm.close();
		}
		return null;
	}
	public JSONObject createRequest(Request request) throws JSONException{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Request.class);
		q.setFilter("from == fromP &&  to == toP && type == typeP && status == "+request.getStatus()+"");
		q.declareParameters("String fromP, String toP, byte typeP");
		JSONObject status = new JSONObject();
		
		try{
			List<Request> requests = (List<Request>) q.execute(request.getFrom(), request.getTo(), request.getType());
			int size = requests.size();
			if(requests.size() > 0){
				status.put("SUCCESS", false);
				status.put("msg", "This request has already been made!");
				status.put("requests", new JSONArray(requests));
				return status;
			}
			else{
				//PersistenceManager pm2 = PMF.get().getPersistenceManager();
				try{
					pm.makePersistent(request);
					
				}catch(Exception e){}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			pm.close();
		}
		status.put("SUCCESS", true);
		status.put("request", new JSONObject(request));
		return status;
	}
	public JSONObject cancelRequest(String id, String masterId, ProUser proUser) throws JSONException{
		JSONObject reply = new JSONObject();
		reply.put("SUCCESS", false);
		Request request = getRequestById(id);
		
		if(null == request){
			reply.put("msg", "This Request Doesn't exist");
			return reply;
		}
		byte type = request.getType();
		if((type !=5 && type !=6 && request.getFrom().equals(masterId)) || 
				((type == 5 || type == 6) && request.getFrom().equals(proUser.getKey()))){
			request.setStatus((byte) 1);
			PersistenceManager pm = PMF.get().getPersistenceManager();
			try{
				pm.makePersistent(request);
			}finally{
				pm.close();
			}
			reply.put("SUCCESS", true);
			reply.put("request", request);
			return reply;
		}
		reply.put("msg", "You are not authorized to Approve/Reject/Cancel this request!");
		return reply;
	}
	
	public JSONObject ApproveRequest(String id, String masterId,String masterName, ProUser proUser) throws JSONException{
		JSONObject reply = new JSONObject();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		reply.put("SUCCESS", false);
		Request request = getRequestById(id);
		String hostId, hostName, userId, userName;
		if(null == request){
			reply.put("msg", "This Request Doesn't exist");
			return reply;
		}
		byte type = request.getType();
		if(request.checkApprovalRights(masterId, proUser)){
			
			boolean isAgent = type==3 || type==5?true:false;
			request.setStatus((byte) 4);
			Agent agent;
			SubAgent subAgent;
			
			if(type == 1 || type == 2){
				if(type==1){
					agent = getAgentById(request.getFrom());
					subAgent = getSubAgentById(request.getTo());
					agent.addSubAgent(subAgent);
					subAgent.addAgent(agent);
				}
				else{
					agent = getAgentById(request.getTo());
					subAgent = getSubAgentById(request.getFrom());
					agent.addSubAgent(subAgent);
					subAgent.addAgent(agent);
				}
				agent.addSubAgent(subAgent);
				subAgent.addAgent(agent);
				pm.makePersistent(agent);
				pm.makePersistent(subAgent);
			}
			else{
				if(type==3 || type==4){
					hostId = request.getFrom();
					hostName = request.getFromName();
					userId = request.getTo();
					userName = request.getToName();
				}
				else{
					hostId = request.getTo();
					hostName = request.getToName();
					userId = request.getFrom();
					userName = request.getFromName();
				}
				UserRelationship rel = new UserRelationship(userId, userName, Long.parseLong(hostId), hostName,isAgent, false);
				pm.makePersistent(rel);
			}
			try{
				pm.makePersistent(request);
			}
			finally{
				pm.close();
			}
			reply.put("SUCCESS", true);
			reply.put("request", request);
			return reply;
		}
		reply.put("msg", "You are not authorized to Approve/Reject/Cancel this request!");
		return reply;
	}
	public JSONObject RejectRequest(String id, String masterId,String masterName, ProUser proUser) throws JSONException{
		JSONObject reply = new JSONObject();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		reply.put("SUCCESS", false);
		Request request = getRequestById(id);
		
		if(null == request){
			reply.put("msg", "This Request Doesn't exist");
			return reply;
		}
		byte type = request.getType();
		if(request.checkApprovalRights(masterId, proUser)){
			request.setStatus((byte) 5);
			try{
				pm.makePersistent(request);
			}
			finally{
				pm.close();
			}
			reply.put("SUCCESS", true);
			reply.put("request", request);
			return reply;
		}
		reply.put("msg", "You are not authorized to Approve/Reject/Cancel this request!");
		return reply;
	}
	private Request getRequestById(String id) {
		long l = Long.parseLong(id);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Request request = null;
		try{
			request = (Request) pm.getObjectById(Request.class, l);
			request = pm.detachCopy(request);
		}finally{
			pm.close();
		}
		return request;
	}

	public JSONObject BreakUp(Agent agent, SubAgent subAgent) throws JSONException {
		JSONObject json = new JSONObject();
		json.put("msg", "Something went wrong, please try again later or contact administrator");
		json.put("SUCCESS", false);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		if (agent.removeSubAgent(subAgent) &&	subAgent.removeAgent(agent)){
			try{
				pm.makePersistent(agent);
				pm.makePersistent(subAgent);
				json.put("msg", "Successfully removed!");
				json.put("SUCCESS", true);
			}catch(Exception e){
				return json;
			}finally{
				pm.close();
			}
		}
		return json;
	}

	public JSONObject BreakUp(String relId) throws JSONException {
		JSONObject json = new JSONObject();
		json.put("SUCCESS", false);
		json.put("msg", "Something wen't wrong, Please contact the admin or raise a bug.");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			UserRelationship rel = pm.getObjectById(UserRelationship.class, relId);
			pm.deletePersistent(relId);
			json.put("SUCCESS", true);
			json.put("msg", "Successfully removed!");
			return json;
		}catch(Exception e){
			return json;
		}finally{
			pm.close();
		}
	}

	private UserRelationship getUserRelationshipById(String relId) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		UserRelationship rel = null;
		try{
			rel = pm.getObjectById(UserRelationship.class, relId);
			return pm.detachCopy(rel);
		}catch(Exception e){
			return rel;
		}finally{
			pm.close();
		}
		
	}
}

