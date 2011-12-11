package com.github.jira.commons.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;

@SuppressWarnings("serial")
public class CommentList extends Entity {
	public static final String START_AT = "startAt";
	public static final String MAX_RESULTS = "maxResults";
	public static final String TOTAL = "total";
	public static final String COMMENTS = "comments";
	
	public int getStartAt() {
		return (Integer) ObjectUtils.defaultIfNull(get(START_AT), 0);
	}
	
	public int getMaxResults() {
		return (Integer) ObjectUtils.defaultIfNull(get(MAX_RESULTS), 0);
	}
	
	public int getTotal() {
		return (Integer) ObjectUtils.defaultIfNull(get(TOTAL), 0);
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<Comment> getComments() {
		List<Map<String, Object>> reads = (List<Map<String, Object>>) get(COMMENTS);
		if (reads == null) {
			return new ArrayList<Comment>();
		}
		
		List<Comment> comments = new ArrayList<Comment>();
		for (Map<String, Object> read : reads) {
			Comment comment = new Comment();
			comment.putAll(read);
			comments.add(comment);
		}
		
		return comments;
	}
}
