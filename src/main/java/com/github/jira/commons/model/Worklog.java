package com.github.jira.commons.model;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.github.jira.commons.util.DateUtils;

@SuppressWarnings("serial")
public class Worklog extends Entity {
	public static final String SELF = "self";
	public static final String ISSUE = "issue";
	public static final String ID = "id";
	public static final String AUTHOR = "author";
	public static final String UPDATE_AUTHOR = "updateAuthor";
	public static final String COMMENT = "comment";
	public static final String CREATED = "created";
	public static final String UPDATED = "updated";
	public static final String STARTED = "started";
	public static final String TIME_SPENT = "timeSpent";
	
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

		Worklog target = (Worklog) o;
		return new EqualsBuilder().append(getId(), target.getId()).isEquals();
	}
	
	public String getSelf() {
		return StringUtils.defaultString((String) get(SELF));
	}

	public String getIssue() {
		return StringUtils.defaultString((String) get(ISSUE));
	}

	public String getId() {
		return StringUtils.defaultString((String) get(ID));
	}
	
	@SuppressWarnings("unchecked")
	public User getAuthor() {
		Map<String, Object> read = (Map<String, Object>) get(AUTHOR);
		if (read == null) {
			return new User();
		}
		
		User ret = new User();
		ret.putAll(read);
		return ret;
	}

	public String getComment() {
		return StringUtils.defaultString((String) get(COMMENT));
	}
	
	@SuppressWarnings("unchecked")
	public User getUpdateAuthor() {
		Map<String, Object> read = (Map<String, Object>) get(UPDATE_AUTHOR);
		if (read == null) {
			return new User();
		}
		
		User ret = new User();
		ret.putAll(read);
		return ret;
	}
	
	public Date getCreated() {
		Object read = get(CREATED);
		try {
			return (read != null) ? DateUtils.parseDate((String) read) : null;
		} catch (ParseException e) {
			return null;
		}
	}
	
	public Date getUpdated() {
		Object read = get(UPDATED);
		try {
			return (read != null) ? DateUtils.parseDate((String) read) : null;
		} catch (ParseException e) {
			return null;
		}
	}
	
	public Date getStarted() {
		Object read = get(STARTED);
		try {
			return (read != null) ? DateUtils.parseDate((String) read) : null;
		} catch (ParseException e) {
			return null;
		}
	}

	public String getTimeSpent() {
		return StringUtils.defaultString((String) get(TIME_SPENT));
	}
}
