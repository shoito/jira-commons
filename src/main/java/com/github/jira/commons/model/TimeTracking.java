package com.github.jira.commons.model;

import org.apache.commons.lang.ObjectUtils;

@SuppressWarnings("serial")
public class TimeTracking extends Entity {
	public static final String TIME_ORIGINAL_ESTIMATE = "timeoriginalestimate";
	public static final String TIME_ESTIMATE = "timeestimate";
	public static final String TIME_SPENT = "timespent";
	
	public int getTimeOriginalEstimate() {
		return (Integer) ObjectUtils.defaultIfNull(get(TIME_ORIGINAL_ESTIMATE), 0);
	}
	
	public int getTimeEstimate() {
		return (Integer) ObjectUtils.defaultIfNull(get(TIME_ESTIMATE), 0);
	}
	
	public int getTimeSpent() {
		return (Integer) ObjectUtils.defaultIfNull(get(TIME_SPENT), 0);
	}
}
