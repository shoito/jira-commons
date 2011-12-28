package com.github.jira.commons.model;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

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

		Priority target = (Priority) o;
		return new EqualsBuilder().append(getId(), target.getId()).isEquals();
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
