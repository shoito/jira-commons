package com.github.jira.commons.model;

import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class Priority extends Entity {
	public static final String SELF = "self";
	public static final String ICON_URL = "iconUrl";
	public static final String NAME = "name";
	public static final String ID = "id";
	
	@Override
	public String toString() {
		return getName();
	}
	
	public String getSelf() {
		return StringUtils.defaultString((String) get(SELF));
	}

	public String getIconUrl() {
		return StringUtils.defaultString((String) get(ICON_URL));
	}

	public String getName() {
		return StringUtils.defaultString((String) get(NAME));
	}

	public String getId() {
		return StringUtils.defaultString((String) get(ID));
	}
}
