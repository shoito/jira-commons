package com.github.jira.commons.model;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import com.github.jira.commons.util.DateUtils;

@SuppressWarnings("serial")
public class Attachment extends Entity {
	public static final String SELF = "self";
	public static final String ID = "id";
	public static final String FILENAME = "filename";
	public static final String AUTHOR = "author";
	public static final String CREATED = "created";
	public static final String SIZE = "size";
	public static final String MIME_TYPE = "mimeType";
	public static final String CONTENT = "content";
	public static final String THUMBNAIL = "thumbnail";
	
	@Override
	public String toString() {
		return getFilename();
	}
	
	public String getSelf() {
		return StringUtils.defaultString((String) get(SELF));
	}

	public String getId() {
		return StringUtils.defaultString((String) get(ID));
	}

	public String getFilename() {
		return StringUtils.defaultString((String) get(FILENAME));
	}
	
	@SuppressWarnings("unchecked")
	public User getAuthor() {
		Map<String, Object> read = (Map<String, Object>) get(AUTHOR);
		if (read == null) {
			return new User();
		}
		
		User ret = new User();
		ret.putAll(read);
		return ret;
	}
	
	public Date getCreated() {
		Object read = get(CREATED);
		try {
			return (read != null) ? DateUtils.parseDate((String) read) : null;
		} catch (ParseException e) {
			return null;
		}
	}
	
	public int getSize() {
		return (Integer) ObjectUtils.defaultIfNull(get(SIZE), 0);
	}

	public String getMimeType() {
		return StringUtils.defaultString((String) get(MIME_TYPE));
	}
	
	public String getContent() {
		return StringUtils.defaultString((String) get(CONTENT));
	}
	
	public String getThumbnail() {
		return StringUtils.defaultString((String) get(THUMBNAIL));
	}
}
