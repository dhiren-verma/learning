package learning.java8;

public class NewDateTimePOC {
	
	/**
	 * Drawbacks of existing DateTime API:
	 * 1. Thread safety: The existing classes such as Date and Calendar does
	 * 	  not provide thread safety. Hence it leads to hard-to-debug
	 * 	  concurrency issues that are needed to be taken care by developers.
	 * 	  The new Date and Time APIs of Java 8 provide thread safety and are
	 * 	  immutable, hence avoiding the concurrency issue from developers.
	 * 2. Bad API designing: The classic Date and Calendar APIs does not
	 * 	  provide methods to perform basic day-to-day functionalities. The
	 * 	  Date and Time classes introduced in Java 8 are ISO-centric and
	 * 	  provides number of different methods for performing operations
	 * 	  regarding date, time, duration and periods.
	 * 3. Difficult time zone handling: To handle the time-zone using classic
	 * 	  Date and Calendar classes is difficult because the developers were
	 * 	  supposed to write the logic for it. With the new APIs, the time-zone
	 * 	  handling can be easily done with Local and ZonedDate/Time APIs.
	 * 
	 * Classes in new DateTime API:
	 * 1. java.time.LocalDate: It represents a year-month-day in the ISO
	 * 	  calendar and is useful for representing a date without a time. It can
	 * 	  be used to represent a date only information such as a birth date or
	 * 	  wedding date.
	 * 2. java.time.LocalTime: It deals in time only. It is useful for
	 * 	  representing human-based time of day, such as movie times, or the
	 * 	  opening and closing times of the local library.
	 * 3. java.time.LocalDateTime: It handles both date and time, without a
	 * 	  time zone. It is a combination of LocalDate with LocalTime.
	 * 4. java.time.ZonedDateTime: It combines the LocalDateTime class with the
	 * 	  zone information given in ZoneId class. It represent a complete date
	 * 	  time stamp along with timezone information.
	 * 5. java.time.OffsetTime: It handles time with a corresponding time zone
	 * 	  offset from Greenwich/UTC, without a time zone ID.
	 * 6. java.time.OffsetDateTime: It handles a date and time with a
	 * 	  corresponding time zone offset from Greenwich/UTC, without a time zone ID.
	 * 7. java.time.Clock : It provides access to the current instant, date and
	 * 	  time in any given time-zone. Although the use of the Clock class is
	 * 	  optional, this feature allows us to test your code for other time zones,
	 * 	  or by using a fixed clock, where time does not change.
	 * 8. java.time.Instant : It represents the start of a nanosecond on the
	 * 	  timeline (since EPOCH) and useful for generating a timestamp to
	 * 	  represent machine time. An instant that occurs before the epoch has a
	 * 	  negative value, and an instant that occurs after the epoch has a
	 * 	  positive value.
	 * 9. java.time.Duration : Difference between two instants and measured in
	 * 	  seconds or nanoseconds and does not use date-based constructs such as
	 * 	  years, months, and days, though the class provides methods that convert
	 * 	  to days, hours, and minutes.
	 * 10.java.time.Period : It is used to define the difference between dates in
	 * 	  date-based values (years, months, days).
	 * 11.java.time.ZoneId : It states a time zone identifier and provides rules
	 * 	  for converting between an Instant and a LocalDateTime.
	 * 12.java.time.ZoneOffset : It describe a time zone offset from Greenwich/UTC
	 * 	  time.
	 * 13.java.time.format.DateTimeFormatter : It comes up with various predefined
	 * 	  formatter, or we can define our own. It has parse() or format() method
	 * 	  for parsing and formatting the date time values.
	 * 
	 */
	
}
