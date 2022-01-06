package learning.generics;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public class Test1 {
	
	public static void main(String[] args) {
		// Current date and time using now()
		ZonedDateTime currentDateTime = ZonedDateTime.now();
		
		// Creating timezone zoneid objects using ZoneId.of() method.
		ZoneId indianTimeZone = ZoneId.of("Asia/Kolkata");
		ZoneId losAngelesTimeZone = ZoneId.of("America/Los_Angeles");
		ZoneId dubaiTimeZone = ZoneId.of("Asia/Dubai");
		ZoneId utcTimeZone = ZoneId.of("UTC");
		
		// Converting Current timezone time to Log Angeles time
		ZonedDateTime losAngelesDateTime = currentDateTime.withZoneSameInstant(losAngelesTimeZone);
		
		// Converting Current timezone time to Dubai time
		ZonedDateTime dubaiDateTime = currentDateTime.withZoneSameInstant(dubaiTimeZone);
		
		//Converting Current TimeZone time to UTC time:
		ZonedDateTime utcDateTime = currentDateTime.withZoneSameInstant(utcTimeZone);
		
		
		// Datetime formatting 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm z");
		
		// Print all 3 dates
		System.out.println("Current time in IST : " + formatter.format(currentDateTime));
		System.out.println("Los Angeles time now : " + formatter.format(losAngelesDateTime));
		System.out.println("Dubai time now : " + formatter.format(dubaiDateTime));
		System.out.println("UTC time now : " + formatter.format(utcDateTime));
		
		//Converting from Local Date Time to ZonedDateTime:
		LocalDateTime currentLocalDateTime = LocalDateTime.now();
		
		ZonedDateTime indianDateTime = currentLocalDateTime.atZone(indianTimeZone);
		
		// Converting Current timezone time to Log Angeles time
		losAngelesDateTime = indianDateTime.withZoneSameInstant(losAngelesTimeZone);
		
		// Converting Current timezone time to Dubai time
		dubaiDateTime = losAngelesDateTime.withZoneSameInstant(dubaiTimeZone);
		
		//Converting Current timezone time to UTC time
		utcDateTime = losAngelesDateTime.withZoneSameInstant(utcTimeZone);
		
		// Datetime formatting 
		formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm");
		
		// Print all 3 dates
		System.out.println("\n\nCurrent time in IST : " + formatter.format(currentLocalDateTime));
		System.out.println("Los Angeles time : " + formatter.format(losAngelesDateTime));
		System.out.println("Dubai time : " + formatter.format(dubaiDateTime));
		System.out.println("UTC time : "+formatter.format(utcDateTime));
		
		
		String providedDateTime = "2018-12-21 14:43";
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		LocalDateTime localDateTime = LocalDateTime.parse(providedDateTime, customFormatter);
		
		ZoneId koreanTimeZone = ZoneId.of("Asia/Tokyo");
		
		ZonedDateTime koreanDateTime = localDateTime.atZone(koreanTimeZone);
		
		utcDateTime = koreanDateTime.withZoneSameInstant(utcTimeZone);
		
		System.out.println("Parsed Korean Date Time is: "+koreanDateTime+
				"\nIts parsed from: "+providedDateTime+
				"\nIts UTC Equivalent is: "+utcDateTime);
		
		
		int offsetHours = 5;
		int offsetMinutes = 30;
		ZoneId randomZone = ZoneId.ofOffset("", ZoneOffset.ofHoursMinutes(offsetHours, offsetMinutes));
		
		System.out.println("Generated Random Zone is: "+randomZone.getId()+" more details: "+randomZone.toString());
		
		System.out.println("Seconds in a Day: "+TimeUnit.DAYS.toSeconds(1));
		System.out.println("Seconds*2 in a Day: "+TimeUnit.DAYS.toSeconds(2));
		System.out.println("Seconds in a Day: "+TimeUnit.DAYS.toSeconds(0));
		
	}

}
