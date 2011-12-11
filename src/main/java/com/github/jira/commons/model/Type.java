package com.github.jira.commons.model;

import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class Type extends Entity {
	public static final String NAME = "name";
	public static final String DIRECTION = "direction";
	public static final String DESCRIPTION = "description";
	
	@Override
	public String toString() {
		return getName();
	}
	
	public String getName() {
		return StringUtils.defaultString((String) get(NAME));
	}
	
	public String getDirection() {
		return StringUtils.defaultString((String) get(DIRECTION));
	}
	
	public String getDescription() {
		return StringUtils.defaultString((String) get(DESCRIPTION));
	}
}
