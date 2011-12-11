package com.github.jira.commons.model;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class Watches extends Entity {
	public static final String SELF = "self";
	public static final String WATCH_COUNT = "watchCount";
	public static final String IS_WATCHING = "isWatching";
	

	public String getSelf() {
		return StringUtils.defaultString((String) get(SELF));
	}

	public int getWatchCount() {
		return (Integer) ObjectUtils.defaultIfNull(get(WATCH_COUNT), 0);
	}
	
	public boolean isWatching() {
		return (Boolean) ObjectUtils.defaultIfNull(get(IS_WATCHING), false);
	}
}
