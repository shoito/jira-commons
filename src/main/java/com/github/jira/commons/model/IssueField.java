package com.github.jira.commons.model;

import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@SuppressWarnings("serial")
public class IssueField extends Entity {
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String CUSTOM = "custom";
	public static final String SCHEMA = "schema";
	
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

		IssueField target = (IssueField) o;
		return new EqualsBuilder().append(getId(), target.getId()).isEquals();
	}
	
	public String getId() {
		return StringUtils.defaultString((String) get(ID));
	}
	
	public String getName() {
		return StringUtils.defaultString((String) get(NAME));
	}
	
	public boolean isCustom() {
		return (Boolean) ObjectUtils.defaultIfNull(get(CUSTOM), false);
	}
	
	@SuppressWarnings("unchecked")
	public Schema getSchema() {
		Map<String, Object> read = (Map<String, Object>) get(SCHEMA);
		if (read == null) {
			return new Schema();
		}
		
		Schema ret = new Schema();
		ret.putAll(read);
		return ret;
	}
}
