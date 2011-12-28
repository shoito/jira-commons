package com.github.jira.commons.model;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

// https://developer.atlassian.com/display/JIRADEV/Database+Schema
@SuppressWarnings("serial")
public class Issue extends Entity {
	public static final String SELF = "self";
	public static final String ID = "id";
	public static final String KEY = "key";
	public static final String FIELDS = "fields";
	public static final String TRANSITIONS = "transitions";
	public static final String CHANGELOG = "changelog";
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass()) {
			return false;
		}
		if (o == this) {
			return true;
		}

		Issue target = (Issue) o;
		return new EqualsBuilder().append(getId(), target.getId()).isEquals();
	}
	
	public String getSelf() {
		return StringUtils.defaultString((String) get(SELF));
	}

	public String getId() {
		return StringUtils.defaultString((String) get(ID));
	}
	
	public String getKey() {
		return StringUtils.defaultString((String) get(KEY));
	}
	
	@SuppressWarnings("unchecked")
	public IssueFields getFields() {
		Map<String, Object> read = (Map<String, Object>) get(FIELDS);
		if (read == null) {
			return new IssueFields();
		}
		
		IssueFields ret = new IssueFields();
		ret.putAll(read);
		return ret;
	}
	
	public String getTransitions() {
		return StringUtils.defaultString((String) get(TRANSITIONS));
	}
	
	public String getChangelog() {
		return StringUtils.defaultString((String) get(CHANGELOG));
	}
}