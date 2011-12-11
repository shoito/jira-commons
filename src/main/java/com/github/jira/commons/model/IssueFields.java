package com.github.jira.commons.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.github.jira.commons.util.DateUtils;

@SuppressWarnings("serial")
public class IssueFields extends Entity {
	public static final String SUMMARY = "summary";
	public static final String TIMETRACKING = "timetracking";
	public static final String ISSUETYPE = "issuetype";
	public static final String VOTES = "votes";
	public static final String SECURITY = "security";
	public static final String FIX_VERSIONS = "fixVersions";
	public static final String RESOLUTION = "resolution";
	public static final String RESOLUTION_DATE = "resolutiondate";
	public static final String REPORTER = "reporter";
	public static final String CREATED = "created";
	public static final String UPDATED = "updated";
	public static final String PRIORITY = "priority";
	public static final String DESCRIPTION = "description";
	public static final String DUEDATE = "duedate";
	public static final String ISSUELINKS = "issuelinks";
	public static final String WATCHES = "watches";
	public static final String WORKLOG = "worklog";
	public static final String STATUS = "status";
	public static final String LABELS = "labels";
	public static final String ASSIGNEE = "assignee";
	public static final String ATTACHMENT = "attachment";
	public static final String SUB_TASKS = "sub-tasks";
	public static final String PROJECT = "project";
	public static final String VERSIONS = "versions";
	public static final String ENVIRONMENT = "environment";
	public static final String COMPONENTS = "components";
	public static final String COMMENT = "comment";
	
	public String getSummary() {
		return StringUtils.defaultString((String) get(SUMMARY));
	}
	
	@SuppressWarnings("unchecked")
	public TimeTracking getTimeTracking() {
		Map<String, Object> read = (Map<String, Object>) get(TIMETRACKING);
		if (read == null) {
			return new TimeTracking();
		}
		
		TimeTracking ret = new TimeTracking();
		ret.putAll(read);
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public IssueType getIssueType() {
		Map<String, Object> read = (Map<String, Object>) get(ISSUETYPE);
		if (read == null) {
			return new IssueType();
		}
		
		IssueType ret = new IssueType();
		ret.putAll(read);
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<Votes> getVotes() {
		List<Map<String, Object>> reads = (List<Map<String, Object>>) get(VOTES);
		if (reads == null) {
			return new ArrayList<Votes>();
		}
		
		List<Votes> ret = new ArrayList<Votes>();
		for (Map<String, Object> read : reads) {
			Votes vote = new Votes();
			vote.putAll(read);
			ret.add(vote);
		}
		
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public Security getSecurity() {
		Map<String, Object> read = (Map<String, Object>) get(SECURITY);
		if (read == null) {
			return new Security();
		}
		
		Security ret = new Security();
		ret.putAll(read);
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<Version> getFixVersions() {
		List<Map<String, Object>> reads = (List<Map<String, Object>>) get(FIX_VERSIONS);
		if (reads == null) {
			return new ArrayList<Version>();
		}
		
		List<Version> ret = new ArrayList<Version>();
		for (Map<String, Object> read : reads) {
			Version version = new Version();
			version.putAll(read);
			ret.add(version);
		}
		
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public Resolution getResolution() {
		Map<String, Object> read = (Map<String, Object>) get(RESOLUTION);
		if (read == null) {
			return new Resolution();
		}
		
		Resolution ret = new Resolution();
		ret.putAll(read);
		return ret;
	}
	
	public Date getResolutionDate() {
		Object read = get(RESOLUTION_DATE);
		try {
			return (read != null) ? DateUtils.parseDate((String) read) : null;
		} catch (ParseException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public User getReporter() {
		Map<String, Object> read = (Map<String, Object>) get(REPORTER);
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
	
	@SuppressWarnings("unchecked")
	public Priority getPriority() {
		Map<String, Object> read = (Map<String, Object>) get(PRIORITY);
		if (read == null) {
			return new Priority();
		}
		
		Priority ret = new Priority();
		ret.putAll(read);
		return ret;
	}

	public String getDescription() {
		return StringUtils.defaultString((String) get(DESCRIPTION));
	}
	
	public Date getDuedate() {
		Object read = get(DUEDATE);
		try {
			return (read != null) ? DateUtils.parseDate((String) read) : null;
		} catch (ParseException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<IssueLink> getIssuelinks() {
		List<Map<String, Object>> reads = (List<Map<String, Object>>) get(ISSUELINKS);
		if (reads == null) {
			return new ArrayList<IssueLink>();
		}
		
		List<IssueLink> ret = new ArrayList<IssueLink>();
		for (Map<String, Object> read : reads) {
			IssueLink link = new IssueLink();
			link.putAll(read);
			ret.add(link);
		}
		
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public Watches getWatches() {
		Map<String, Object> read = (Map<String, Object>) get(WATCHES);
		if (read == null) {
			return new Watches();
		}
		
		Watches ret = new Watches();
		ret.putAll(read);
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public WorklogList getWorklog() {
		Map<String, Object> read = (Map<String, Object>) get(WORKLOG);
		if (read == null) {
			return new WorklogList();
		}
		
		WorklogList ret = new WorklogList();
		ret.putAll(read);
		return ret;
	}

	@SuppressWarnings("unchecked")
	public Status getStatus() {
		Map<String, Object> read = (Map<String, Object>) get(STATUS);
		if (read == null) {
			return new Status();
		}
		
		Status ret = new Status();
		ret.putAll(read);
		return ret;
	}
	
	
	@SuppressWarnings("unchecked")
	public Iterable<String> getLabels() {
		List<String> reads = (List<String>) get(LABELS);
		if (reads == null) {
			return new ArrayList<String>();
		}
		
		List<String> labels = new ArrayList<String>();
		for (String read : reads) {
			labels.add(read);
		}
		
		return labels;
	}
	
	@SuppressWarnings("unchecked")
	public User getAssignee() {
		Map<String, Object> read = (Map<String, Object>) get(ASSIGNEE);
		if (read == null) {
			return new User();
		}
		
		User ret = new User();
		ret.putAll(read);
		return ret;
	}

	@SuppressWarnings("unchecked")
	public Iterable<Attachment> getAttachment() {
		List<Map<String, Object>> reads = (List<Map<String, Object>>) get(ATTACHMENT);
		if (reads == null) {
			return new ArrayList<Attachment>();
		}
		
		List<Attachment> ret = new ArrayList<Attachment>();
		for (Map<String, Object> read : reads) {
			Attachment attachment = new Attachment();
			attachment.putAll(read);
			ret.add(attachment);
		}
		
		return ret;
	}

	@SuppressWarnings("unchecked")
	public Iterable<SubTask> getSubTasks() {
		List<Map<String, Object>> reads = (List<Map<String, Object>>) get(SUB_TASKS);
		if (reads == null) {
			return new ArrayList<SubTask>();
		}
		
		List<SubTask> ret = new ArrayList<SubTask>();
		for (Map<String, Object> read : reads) {
			SubTask task = new SubTask();
			task.putAll(read);
			ret.add(task);
		}
		
		return ret;
	}

	@SuppressWarnings("unchecked")
	public Project getProject() {
		Map<String, Object> read = (Map<String, Object>) get(PROJECT);
		if (read == null) {
			return new Project();
		}
		
		Project ret = new Project();
		ret.putAll(read);
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<Version> getVersions() {
		List<Map<String, Object>> reads = (List<Map<String, Object>>) get(VERSIONS);
		if (reads == null) {
			return new ArrayList<Version>();
		}
		
		List<Version> ret = new ArrayList<Version>();
		for (Map<String, Object> read : reads) {
			Version version = new Version();
			version.putAll(read);
			ret.add(version);
		}
		
		return ret;
	}
	
	public String getEnvironment() {
		return StringUtils.defaultString((String) get(ENVIRONMENT));
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<Component> getComponents() {
		List<Map<String, Object>> reads = (List<Map<String, Object>>) get(COMPONENTS);
		if (reads == null) {
			return new ArrayList<Component>();
		}
		
		List<Component> ret = new ArrayList<Component>();
		for (Map<String, Object> read : reads) {
			Component component = new Component();
			component.putAll(read);
			ret.add(component);
		}
		
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public CommentList getComment() {
		Map<String, Object> read = (Map<String, Object>) get(COMMENT);
		if (read == null) {
			return new CommentList();
		}
		
		CommentList ret = new CommentList();
		ret.putAll(read);
		return ret;
	}
}
