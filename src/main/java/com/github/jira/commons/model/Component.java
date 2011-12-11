package com.github.jira.commons.model;

import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class Component extends Entity {
	public static final String SELF = "self";
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	
	@Override
	public String toString() {
		return getName();
	}
	
	public String getSelf() {
		return StringUtils.defaultString((String) get(SELF));
	}
	
	public String getId() {
		return StringUtils.defaultString((String) get(ID));
	}
	
	public String getName() {
		return StringUtils.defaultString((String) get(NAME));
	}
	
	public String getDescription() {
		return StringUtils.defaultString((String) get(DESCRIPTION));
	}
}
