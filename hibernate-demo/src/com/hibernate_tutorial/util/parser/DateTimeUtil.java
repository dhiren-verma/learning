package com.hibernate_tutorial.util.parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateTimeUtil {
	
	/**
	 * The Date Formatter:
	 * -dd - Day in Month	(number)
	 * -MM - Month in Year	(number)
	 * -yyyy - Year			(number)
	 */
	private static SimpleDateFormat dateFormatter =
			new SimpleDateFormat("dd/MM/yyyy");
	
	/**
	 * Read a date string and parse/convert to a date
	 * 
	 * @param dateStr
	 * @return Date
	 * @throws ParseException
	 */
	public static Date parseDate(String dateStr) throws ParseException {
		return dateFormatter.parse(dateStr);
	}
	
	/**
	 * Read a date and format/convert to a string
	 */
	public static String formatDate(Date date) {
		return date!=null? dateFormatter.format(date):null;
	}
	
}