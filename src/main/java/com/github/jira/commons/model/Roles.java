package com.github.jira.commons.model;

import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class Roles extends Entity {
	public static final String DEVELOPERS = "Developers";
	
	@Override
	public String toString() {
		return getDevelopers();
	}
	
	public String getDevelopers() {
		return StringUtils.defaultString((String) get(DEVELOPERS));
	}
}
