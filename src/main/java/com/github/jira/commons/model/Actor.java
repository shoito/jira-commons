package com.github.jira.commons.model;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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

		Actor target = (Actor) o;
		return new EqualsBuilder().append(getId(), target.getId()).isEquals();
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
