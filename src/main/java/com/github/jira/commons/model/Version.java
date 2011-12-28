package com.github.jira.commons.model;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.github.jira.commons.util.DateUtils;

@SuppressWarnings("serial")
public class Version extends Entity {
	public static final String SELF = "self";
	public static final String ID = "id";
	public static final String DESCRIPTION = "description";
	public static final String NAME = "name";
	public static final String OVERDUE = "overdue";
	public static final String RELEASE_DATE = "releaseDate";
	public static final String ARCHIVED = "archived";
	public static final String RELEASED = "released";	
	
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

		Version target = (Version) o;
		return new EqualsBuilder().append(getId(), target.getId()).isEquals();
	}
	
	public String getSelf() {
		return StringUtils.defaultString((String) get(SELF));
	}

	public String getId() {
		return StringUtils.defaultString((String) get(ID));
	}

	public String getDescription() {
		return StringUtils.defaultString((String) get(DESCRIPTION));
	}

	public String getName() {
		return StringUtils.defaultString((String) get(NAME));
	}

	public boolean isOverdue() {
		return (Boolean) ObjectUtils.defaultIfNull(get(OVERDUE), false);
	}

	public Date getReleaseDate() {
		Object read = get(RELEASE_DATE);
		try {
			return (read != null) ? DateUtils.parseDate((String) read) : null;
		} catch (ParseException e) {
			return null;
		}
	}

	public boolean isArchived() {
		return (Boolean) ObjectUtils.defaultIfNull(get(ARCHIVED), false);
	}

	public boolean isReleased() {
		return (Boolean) ObjectUtils.defaultIfNull(get(RELEASED), false);
	}
}
