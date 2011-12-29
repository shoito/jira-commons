package com.github.jira.commons.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.restlet.Context;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jira.commons.exception.JiraRequestException;
import com.github.jira.commons.model.IssueField;
import com.github.jira.commons.model.Priority;
import com.github.jira.commons.model.Project;
import com.github.jira.commons.model.SearchResults;

public class JiraClient {
	private static final Logger logger = LoggerFactory.getLogger(JiraClient.class);
	private static final String DEFAULT_TIMEOUT = "1500";
	private String context = "http://localhost:8080/jira/";
	private String userName = "";
	private String password = "";
	
	public JiraClient() {
	}
	
	public JiraClient(String context) {
		setContext(context);
	}
	
	public JiraClient(String context, String userName, String password) {
		this(context);
		setUserName(userName);
		setPassword(password);
	}
	
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		if (StringUtils.isNotBlank(context)) {
			this.context = (context.endsWith("/")) ? context : context + "/";
		} else {
			this.context = context;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isConnectable() {
		boolean connectable = false;
		
		ClientResource resource = new ClientResource(new Context(), context);
		resource.getContext().getParameters().add("socketTimeout", DEFAULT_TIMEOUT);
		resource.setRetryOnError(false);
		Representation representation = null;
		try {
			representation = resource.get();
			Status status = resource.getStatus();
			connectable = status.isSuccess();
		} catch (Exception e) {
			logger.info("Failed connect to JIRA", e);
		} finally {
			if (representation != null) representation.release();
			if (resource != null) resource.release();
		}
		return connectable;
	}
	
	// /rest/api/2/project/{key}
	//		components, issueTypes, versions
	// /rest/api/2/user/assignable/search
	public Project getProject(String projectKey) throws JiraRequestException {
		String relativeUrl = "rest/api/2/project";
		Project project = null;
		
		ClientResource resource = createClientResource(relativeUrl + "/" + projectKey);
		Representation representation = null;
		try {
			representation = resource.get();
			if (representation != null) {
				project = new ObjectMapper().readValue(representation.getStream(), Project.class);
			}
		} catch (Exception e) {
			throw new JiraRequestException("Request to failed", e);
		} finally {
			if (representation != null) representation.release();
			if (resource != null) resource.release();
		}

		return project;
	}
	
	// JIRA 5.0-rc1以降
	@SuppressWarnings("unchecked")
	public Iterable<Priority> getPriorities() throws JiraRequestException {
		String relativeUrl = "rest/api/2/priority";
		List<Priority> priorities = new ArrayList<Priority>();
		List<Map<String, Object>> resultMap = new ArrayList<Map<String, Object>>();
		
		ClientResource resource = createClientResource(relativeUrl);
		Representation representation = null;
		try {
			representation = resource.get();
			if (representation != null) {
				resultMap = new ObjectMapper().readValue(representation.getStream(), List.class);
			}
		} catch (Exception e) {
			throw new JiraRequestException("Request to failed", e);
		} finally {
			if (representation != null) representation.release();
			if (resource != null) resource.release();
		}
		
		for (Map<String, Object> result : resultMap) {
			Priority priority = new Priority();
			priority.putAll(result);
			priorities.add(priority);
		}
		return priorities;
	}
	
	// JIRA 5.0-rc1以降
	@SuppressWarnings("unchecked")
	public Iterable<com.github.jira.commons.model.Status> getStatuses() throws JiraRequestException {
		String relativeUrl = "rest/api/2/status";
		List<com.github.jira.commons.model.Status> statuses = new ArrayList<com.github.jira.commons.model.Status>();
		List<Map<String, Object>> resultMap = new ArrayList<Map<String, Object>>();
		
		ClientResource resource = createClientResource(relativeUrl);
		Representation representation = null;
		try {
			representation = resource.get();
			if (representation != null) {
				resultMap = new ObjectMapper().readValue(representation.getStream(), List.class);
			}
		} catch (Exception e) {
			throw new JiraRequestException("Request to failed", e);
		} finally {
			if (representation != null) representation.release();
			if (resource != null) resource.release();
		}
		
		for (Map<String, Object> result : resultMap) {
			com.github.jira.commons.model.Status status = new com.github.jira.commons.model.Status();
			status.putAll(result);
			statuses.add(status);
		}
		return statuses;
	}
	
	// JIRA 5.0-rc1以降
	@SuppressWarnings("unchecked")
	public Iterable<IssueField> getFields() throws JiraRequestException {
		String relativeUrl = "rest/api/2/field";
		List<IssueField> fields = new ArrayList<IssueField>();
		List<Map<String, Object>> resultMap = new ArrayList<Map<String, Object>>();
		
		ClientResource resource = createClientResource(relativeUrl);
		Representation representation = null;
		try {
			representation = resource.get();
			if (representation != null) {
				resultMap = new ObjectMapper().readValue(representation.getStream(), List.class);
			}
		} catch (Exception e) {
			throw new JiraRequestException("Request to failed", e);
		} finally {
			if (representation != null) representation.release();
			if (resource != null) resource.release();
		}
		
		for (Map<String, Object> result : resultMap) {
			IssueField field = new IssueField();
			field.putAll(result);
			fields.add(field);
		}
		return fields;
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<Project> getProjects() throws JiraRequestException {
		String relativeUrl = "rest/api/2/project";
		List<Project> projects = new ArrayList<Project>();
		List<Map<String, Object>> resultMap = new ArrayList<Map<String, Object>>();
		
		ClientResource resource = createClientResource(relativeUrl);
		Representation representation = null;
		try {
			representation = resource.get();
			if (representation != null) {
				resultMap = new ObjectMapper().readValue(representation.getStream(), List.class);	
			}
		} catch (Exception e) {
			throw new JiraRequestException("Request to failed", e);
		} finally {
			if (representation != null) representation.release();
			if (resource != null) resource.release();
		}
		
		for (Map<String, Object> result : resultMap) {
			Project project = new Project();
			project.putAll(result);
			projects.add(project);
		}
		return projects;
	}
	
	public SearchResults search(JSONObject requestParams) throws JiraRequestException {
		String relativeUrl = "rest/api/2/search";
		SearchResults resultMap = new SearchResults();
		
		ClientResource resource = createClientResource(relativeUrl);
		Representation representation = null;
		try {
			representation = resource.post(new JsonRepresentation(requestParams));
			if (representation != null) {
				resultMap = new ObjectMapper().readValue(representation.getStream(), SearchResults.class);
			}
		} catch (Exception e) {
			throw new JiraRequestException("Request to failed", e);
		} finally {
			if (representation != null) representation.release();
			if (resource != null) resource.release();
		}
		
		return resultMap;
	}

	private ClientResource createClientResource(String relativeUrl) {
		ClientResource resource = new ClientResource(new Context(), context + relativeUrl);
		if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)) {
			resource.setChallengeResponse(ChallengeScheme.HTTP_BASIC, userName, password);
		}
		resource.getContext().getParameters().add("socketTimeout", DEFAULT_TIMEOUT);
		resource.setRetryOnError(false);
		return resource;
	}
	

	public static void main(String[] args) throws Exception {
		String userName = "admin";
		String password = "admin";
		
		JiraClient client = new JiraClient("http://localhost:2990/jira", userName, password);
		
		Project mp = client.getProject("MP");
		System.out.println(mp.getId() + "," + mp.getKey() + " : " + mp.getName());
		
//		List<Priority> priorities = client.getPriorities();
//		for (Priority priority : priorities) {
//			System.out.println(priority.getId() + ", " + priority.getName());
//		}
		
//		List<IssueField> fields = client.getFields();
//		for (IssueField field : fields) {
//			System.out.println(field.getName() + ", " + field.getSchema());
//		}
		
//		Iterable<com.github.jira.commons.model.Status> statuses = client.getStatuses();
//		for (com.github.jira.commons.model.Status status : statuses) {
//			System.out.println(status.getId() + ", " + status.getName());
//		}
		
//		List<Project> projects = client.getProjects();
//		for (Project project : projects) {
//			System.out.println(project.getId() + "," + project.getKey() + " : " + project.getName());
//			
//			Map<String, Object> jqlParams = new HashMap<String, Object>();
//			jqlParams.put(IssueFields.ASSIGNEE, userName);
//			
//			JSONObject requestParams = new JSONObject();
//			requestParams.put(IssueSearchParameter.JQL, RequestUtils.buildQueryParameters(jqlParams));
//			requestParams.put(IssueSearchParameter.START_AT, 0);
//			requestParams.put(IssueSearchParameter.MAX_RESULTS, 3);
//			requestParams.put(IssueSearchParameter.FIELDS, new String[]{IssueFields.SUMMARY, IssueFields.REPORTER});
//			
//			SearchResults result = client.search(requestParams);
//			System.out.println("Total: " + result.getTotal());
//
//			List<Issue> issues = result.getIssues();
//			for (Issue issue : issues) {
//				System.out.println(issue.getFields().getSummary() + ", " +issue.getFields().getReporter().getDisplayName());
//			}
//		}
	}
}