package com.github.jira.commons.client;

import org.junit.After;
import org.junit.Before;

import com.github.jira.commons.client.JiraClient;

public class JiraClientTest {
	JiraClient client;

	@Before
	public void setUp() throws Exception {
		String userName = "admin";
		String password = "admin";
		client = new JiraClient("http://localhost:2990/jira", userName, password);		
	}

	@After
	public void tearDown() throws Exception {
		client = null;
	}

//	@Test
//	public void search() throws Exception {
//		Map<String, Object> jqlParams = new HashMap<String, Object>();
//		jqlParams.put("assignee", "admin");
//		
//		JSONObject requestParams = new JSONObject();
//		requestParams.put("jql", RequestUtils.buildQueryParameters(jqlParams));
//		
//		SearchResults result = client.search(requestParams);
//		System.out.println(result.getTotal());
//		
//		List<Issue> issues = result.getIssues();
//		for (Issue issue : issues) {
//			System.out.println(issue.getFields().getSummary());
//			System.out.println(issue.getFields().getReporter().getDisplayName());
//			System.out.println(issue.getFields().getCreated());
//			System.out.println(issue.getFields().getLabels());
//			System.out.println(issue.getFields().getAttachment());
//			System.out.println();
//		}
//	
//		assertThat(result, is(notNullValue()));
//	}
}
