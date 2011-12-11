package com.github.jira.commons.model;

import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class User extends Entity {
	public static final String SELF = "self";
	public static final String NAME = "name";
	public static final String EMAIL_ADDRESS = "emailAddress";
	public static final String AVATAR_URLS = "avatarUrls";
	public static final String DISPLAY_NAME = "displayName";
	public static final String ACTIVE = "active";
	
	@Override
	public String toString() {
		return getDisplayName();
	}
	
	public String getSelf() {
		return StringUtils.defaultString((String) get(SELF));
	}

	public String getName() {
		return StringUtils.defaultString((String) get(NAME));
	}
	
	public String getEmailAddress() {
		return StringUtils.defaultString((String) get(EMAIL_ADDRESS));
	}
	
	@SuppressWarnings("unchecked")
	public AvatarUrls getAvatarUrls() {
		Map<String, Object> read = (Map<String, Object>) get(AVATAR_URLS);
		if (read == null) {
			return new AvatarUrls();
		}
		
		AvatarUrls ret = new AvatarUrls();
		ret.putAll(read);
		return ret;
	}

	public String getDisplayName() {
		return StringUtils.defaultString((String) get(DISPLAY_NAME));
	}
	
	public boolean isActive() {
		return (Boolean) ObjectUtils.defaultIfNull(get(ACTIVE), true);
	}
}
