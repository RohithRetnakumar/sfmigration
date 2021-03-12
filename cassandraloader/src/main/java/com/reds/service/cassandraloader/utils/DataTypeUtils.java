package com.reds.service.cassandraloader.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.reds.service.cassandraloaderapi.tracker.CassandraloaderTrack;

public class DataTypeUtils {

	public static long getLong(String stringVal) {
		try {
			return Long.parseLong(stringVal);
		} catch (NumberFormatException e) {
			// CassandraloaderTrack.me.warn("Could not parse value {} {}", stringVal, e);
			return 0;

		}
	}

	public static double getDoubleOf(String stringVal) {
		try {
			return Double.parseDouble(stringVal);
		} catch (NumberFormatException e) {
			// CassandraloaderTrack.me.warn("Could not parse value {} {}", stringVal, e);
			return 0;

		}

	}

	public static Date getDate(String dateString) {
		String dateFormat = "yyyy-MM-dd HH:mm:ss.SSSSSS";
		try {
			return new SimpleDateFormat(dateFormat).parse(dateString);
		} catch (ParseException e) {
			// CassandraloaderTrack.me.warn("Could not parse date {} {}", dateString, e);
			return null;

		}
	}

	@Deprecated // deprecated so as to check if this implementation will work or not , for the
				// requirement
	public static boolean getBoolean(String booleanString) {
		if (booleanString == null || booleanString.equals("")) {
			return false;
		} else if (booleanString.equals("TRUE") || booleanString.equals("true")) {
			return true;
		}

		return false;
	}
}
