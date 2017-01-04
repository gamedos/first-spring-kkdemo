<<<<<<< HEAD
package com.quya.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;

public class DateTimeUtils extends org.joda.time.DateTimeUtils {
	public static final DateTimeZone SEOUL = DateTimeZone.forOffsetHours(9);
	public static final DateTimeZone CHINA = DateTimeZone.forOffsetHours(8);

	public static int getTime(){
		long current = System.currentTimeMillis();
		int time = (int)(current / 1000 );
		return time;
	}
	
	public static String getYYYYMMDD(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		long time = System.currentTimeMillis();
		return simpleDateFormat.format(time);
	}
	
	public static String getYestoday(){
		Date as = new Date(new Date().getTime()-86400*1000);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		return simpleDateFormat.format(as);
	}
	
	public static int getDurationMinutes(DateTime start, DateTime end) {
		Duration duration = new Duration(start, end);
		return duration.toStandardMinutes().getMinutes();
	}

	public static long getDurationSeconds(DateTime start, DateTime end) {
		Duration duration = new Duration(start, end);
		return duration.getStandardSeconds();
	}

	public static boolean isExpiredBySeconds(DateTime from, DateTime to, int seconds) {
		if (to.isBefore(from)) {
			return true;
		}

		return to.minusSeconds(seconds).isAfter(from);
	}

	public static boolean isExpiredByMinutes(DateTime from, DateTime to, int minutes) {
		if (to.isBefore(from)) {
			return true;
		}

		return to.minusMinutes(minutes).isAfter(from);
	}

	public static boolean isAvailable(DateTime begin, DateTime end) {
		return (begin.isBeforeNow()) && (end.isAfterNow());
	}

	public static DateTime parseFullDateTime(String ymdhms) {
		return DateTimeFormat.forPattern("yyyyMMddHHmmss").parseDateTime(ymdhms);
	}

	public static DateTime parseShortDateTime(String ymd) {
		return DateTimeFormat.forPattern("yyyyMMdd").parseDateTime(ymd);
	}
=======
package com.quya.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;

public class DateTimeUtils extends org.joda.time.DateTimeUtils {
	public static final DateTimeZone SEOUL = DateTimeZone.forOffsetHours(9);
	public static final DateTimeZone CHINA = DateTimeZone.forOffsetHours(8);

	public static int getTime(){
		long current = System.currentTimeMillis();
		int time = (int)(current / 1000 );
		return time;
	}
	
	public static String getYYYYMMDD(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		long time = System.currentTimeMillis();
		return simpleDateFormat.format(time);
	}
	
	public static String getYestoday(){
		Date as = new Date(new Date().getTime()-86400*1000);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		return simpleDateFormat.format(as);
	}
	
	public static int getDurationMinutes(DateTime start, DateTime end) {
		Duration duration = new Duration(start, end);
		return duration.toStandardMinutes().getMinutes();
	}

	public static long getDurationSeconds(DateTime start, DateTime end) {
		Duration duration = new Duration(start, end);
		return duration.getStandardSeconds();
	}

	public static boolean isExpiredBySeconds(DateTime from, DateTime to, int seconds) {
		if (to.isBefore(from)) {
			return true;
		}

		return to.minusSeconds(seconds).isAfter(from);
	}

	public static boolean isExpiredByMinutes(DateTime from, DateTime to, int minutes) {
		if (to.isBefore(from)) {
			return true;
		}

		return to.minusMinutes(minutes).isAfter(from);
	}

	public static boolean isAvailable(DateTime begin, DateTime end) {
		return (begin.isBeforeNow()) && (end.isAfterNow());
	}

	public static DateTime parseFullDateTime(String ymdhms) {
		return DateTimeFormat.forPattern("yyyyMMddHHmmss").parseDateTime(ymdhms);
	}

	public static DateTime parseShortDateTime(String ymd) {
		return DateTimeFormat.forPattern("yyyyMMdd").parseDateTime(ymd);
	}
>>>>>>> branch 'master' of https://github.com/gamedos/first-spring-kkdemo.git
}