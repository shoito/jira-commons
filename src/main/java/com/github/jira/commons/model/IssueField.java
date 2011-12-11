package com.github.jira.commons.model;

import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

@SuppressWarnings("serial")
public class IssueField extends Entity {
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String CUSTOM = "custom";
	public static final String SCHEMA = "schema";
	
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
