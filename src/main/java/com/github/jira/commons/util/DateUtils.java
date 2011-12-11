package com.github.jira.commons.util;

import java.text.ParseException;
import java.util.Date;

public class DateUtils {
	public static Date parseDate(String s) throws ParseException {
		return org.apache.commons.lang.time.DateUtils.parseDate((String) s,
				new String[] { "yyyy-MM-dd'T'HH:mm:ss.SSSZZ", "yyyy-MM-dd" });
	}
}
