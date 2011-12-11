package com.github.jira.commons.model;

import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class Schema extends Entity {
	public static final String TYPE = "type";
	public static final String SYSTEM = "system";
	
	public String getType() {
		return StringUtils.defaultString((String) get(TYPE));
	}

	public String getSystem() {
		return StringUtils.defaultString((String) get(SYSTEM));
	}
	
}
