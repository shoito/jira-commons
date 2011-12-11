package com.github.jira.commons.model;

import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class Visibility extends Entity {
	public static final String TYPE = "type";
	public static final String VALUE = "value";
	
	public String getType() {
		return StringUtils.defaultString((String) get(TYPE));
	}

	public String getValue() {
		return StringUtils.defaultString((String) get(VALUE));
	}
}
