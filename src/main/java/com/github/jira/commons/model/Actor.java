package com.github.jira.commons.model;

import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class Actor extends Entity {
	public static final String ID = "id";
	public static final String DISPLAY_NAME = "displayName";
	public static final String TYPE = "type";
	public static final String NAME = "name";
	
	@Override
	public String toString() {
		return getName();
	}
	
	public String getId() {
		return StringUtils.defaultString((String) get(ID));
	}

	public String getDisplayName() {
		return StringUtils.defaultString((String) get(DISPLAY_NAME));
	}

	public String getType() {
		return StringUtils.defaultString((String) get(TYPE));
	}

	public String getName() {
		return StringUtils.defaultString((String) get(NAME));
	}
}
