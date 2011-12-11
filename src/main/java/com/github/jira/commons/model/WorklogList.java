package com.github.jira.commons.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;

@SuppressWarnings("serial")
public class WorklogList extends Entity {
	public static final String START_AT = "startAt";
	public static final String MAX_RESULTS = "maxResults";
	public static final String TOTAL = "total";
	public static final String WORKLOGS = "worklogs";
	
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
	public Iterable<Worklog> getComments() {
		List<Map<String, Object>> reads = (List<Map<String, Object>>) get(WORKLOGS);
		if (reads == null) {
			return new ArrayList<Worklog>();
		}
		
		List<Worklog> worklogs = new ArrayList<Worklog>();
		for (Map<String, Object> read : reads) {
			Worklog worklog = new Worklog();
			worklog.putAll(read);
			worklogs.add(worklog);
		}
		
		return worklogs;
	}
}
