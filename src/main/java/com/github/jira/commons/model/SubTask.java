package com.github.jira.commons.model;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class SubTask extends Entity {
	public static final String ISSUE_ID = "issueId";
	public static final String ISSUE_KEY = "issueKey";
	public static final String ISSUE = "issue";
	public static final String TYPE = "type";
	
	public String getIssueId() {
		return StringUtils.defaultString((String) get(ISSUE_ID));
	}
	
	public String getIssueKey() {
		return StringUtils.defaultString((String) get(ISSUE_KEY));
	}
	
	public String getIssue() {
		return StringUtils.defaultString((String) get(ISSUE));
	}
	
	@SuppressWarnings("unchecked")
	public Type getType() {
		Map<String, Object> read = (Map<String, Object>) get(TYPE);
		if (read == null) {
			return new Type();
		}
		
		Type ret = new Type();
		ret.putAll(read);
		return ret;
	}
}
