package lesson08_newdatetimeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Java8LocalDateTimeAPI {

	public static void main(String[] args) {
		Java8LocalDateTimeAPI tester = new Java8LocalDateTimeAPI();
		tester.testLocalDateTime();
	}
	
	public void testLocalDateTime() {
		//Get the current date and time
		LocalDateTime currentTime = LocalDateTime.now();
		System.out.println("Current DateTime: " + currentTime);
		
		LocalDate date1 = currentTime.toLocalDate();
		System.out.println("date1: " + date1);
		
		Month month = currentTime.getMonth();
		int day = currentTime.getDayOfMonth();
		int seconds = currentTime.getSecond();
		
		System.out.println("Month: " + month + " day: " + day + " seconds: " + seconds);
		
		LocalDateTime date2 = currentTime.withDayOfMonth(20).withYear(2018);
		System.out.println("date2: " + date2);
		
		//27 April 2018
		LocalDate date3 = LocalDate.of(2018, Month.APRIL, 27);
		System.out.println("date3: " + date3);
		
		//22 hour 15 minutes
		LocalTime date4 = LocalTime.of(22, 15);
		System.out.println("date4: " + date4);
		
		//parse a string
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5: " + date5);
		
	}

}
