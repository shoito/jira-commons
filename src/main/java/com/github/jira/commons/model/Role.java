package com.github.jira.commons.model;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@SuppressWarnings("serial")
public class Role extends Entity {
	public static final String SELF = "self";
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ACTORS = "actors";
	
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

		Role target = (Role) o;
		return new EqualsBuilder().append(getId(), target.getId()).isEquals();
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

	@SuppressWarnings("unchecked")
	public Actor getActors() {
		Map<String, Object> read = (Map<String, Object>) get(ACTORS);
		if (read == null) {
			return new Actor();
		}
		
		Actor ret = new Actor();
		ret.putAll(read);
		return ret;
	}
}
