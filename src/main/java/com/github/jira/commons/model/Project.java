package com.github.jira.commons.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@SuppressWarnings("serial")
public class Project extends Entity {
	public static final String SELF = "self";
	public static final String ID = "id";
	public static final String KEY = "key";
	public static final String DESCRIPTION = "description";
	public static final String LEAD = "lead";
	public static final String COMPONENTS = "components";
	public static final String URL = "url";
	public static final String ASSIGNEE_TYPE = "assigneeType";
	public static final String VERSIONS = "versions";
	public static final String NAME = "name";
	public static final String ROLES = "roles";
	public static final String AVATAR_URLS = "avatarUrls";
	
	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass()) {
			return false;
		}
		if (o == this) {
			return true;
		}

		Project target = (Project) o;
		return new EqualsBuilder().append(getId(), target.getId()).isEquals();
	}
	
	public String getSelf() {
		return StringUtils.defaultString((String) get(SELF));
	}

	public String getId() {
		return StringUtils.defaultString((String) get(ID));
	}
	
	public String getKey() {
		return StringUtils.defaultString((String) get(KEY));
	}
	
	public String getDescription() {
		return StringUtils.defaultString((String) get(DESCRIPTION));
	}
	
	@SuppressWarnings("unchecked")
	public User getLead() {
		Map<String, Object> read = (Map<String, Object>) get(LEAD);
		if (read == null) {
			return new User();
		}
		
		User ret = new User();
		ret.putAll(read);
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<Component> getComponents() {
		List<Map<String, Object>> reads = (List<Map<String, Object>>) get(COMPONENTS);
		if (reads == null) {
			return new ArrayList<Component>();
		}
		
		List<Component> ret = new ArrayList<Component>();
		for (Map<String, Object> read : reads) {
			Component component = new Component();
			component.putAll(read);
			ret.add(component);
		}
		
		return ret;
	}
	
	public String getUrl() {
		return StringUtils.defaultString((String) get(URL));
	}
	
	public String getAssigneeType() {
		return StringUtils.defaultString((String) get(ASSIGNEE_TYPE));
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<Version> getVersions() {
		List<Map<String, Object>> reads = (List<Map<String, Object>>) get(VERSIONS);
		if (reads == null) {
			return new ArrayList<Version>();
		}
		
		List<Version> ret = new ArrayList<Version>();
		for (Map<String, Object> read : reads) {
			Version version = new Version();
			version.putAll(read);
			ret.add(version);
		}
		
		return ret;
	}
	
	public String getName() {
		return StringUtils.defaultString((String) get(NAME));
	}
	
	@SuppressWarnings("unchecked")
	public Roles getRoles() {
		Map<String, Object> read = (Map<String, Object>) get(ROLES);
		if (read == null) {
			return new Roles();
		}
		
		Roles ret = new Roles();
		ret.putAll(read);
		return ret;
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
}
