package com.github.jira.commons.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class SearchResults extends Entity {
	public static final String EXPAND = "expand";
	public static final String START_AT = "startAt";
	public static final String MAX_RESULTS = "maxResults";
	public static final String TOTAL = "total";
	public static final String ISSUES = "issues";
	
	public String getExpand() {
		return StringUtils.defaultString((String) get(EXPAND));
	}
	
	public int getStartAt() {
		return (Integer) ObjectUtils.defaultIfNull(get(START_AT), 0);
	}
	
	public int getMaxResults() {
		return (Integer) ObjectUtils.defaultIfNull(get(MAX_RESULTS), 0);
	}
	
	public int getTotal() {
		return (Integer) ObjectUtils.defaultIfNull(get(TOTAL), 0);
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<Issue> getIssues() {
		List<Map<String, Object>> reads = (List<Map<String, Object>>) get(ISSUES);
		if (reads == null) {
			return new ArrayList<Issue>();
		}
		
		List<Issue> issues = new ArrayList<Issue>();
		for (Map<String, Object> read : reads) {
			Issue issue = new Issue();
			issue.putAll(read);
			issues.add(issue);
		}
		
		return issues;
	}
}

