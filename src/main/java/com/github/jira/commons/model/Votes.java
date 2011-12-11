package com.github.jira.commons.model;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class Votes extends Entity {
	public static final String SELF = "self";
	public static final String VOTES = "votes";
	public static final String HAS_VOTED = "hasVoted";
	
	public String getSelf() {
		return StringUtils.defaultString((String) get(SELF));
	}
	
	public int getVotes() {
		return (Integer) ObjectUtils.defaultIfNull(get(VOTES), 0);
	}
	
	public boolean hasVoted() {
		return (Boolean) ObjectUtils.defaultIfNull(get(HAS_VOTED), false);
	}
}
