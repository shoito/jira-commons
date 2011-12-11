package com.github.jira.commons.model;

import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class AvatarUrls extends Entity {
	public static final String _16x16 = "16x16";
	public static final String _48x48 = "48x48";
	
	public String get16x16() {
		return StringUtils.defaultString((String) get(_16x16));
	}

	public String get48x48() {
		return StringUtils.defaultString((String) get(_48x48));
	}
}
