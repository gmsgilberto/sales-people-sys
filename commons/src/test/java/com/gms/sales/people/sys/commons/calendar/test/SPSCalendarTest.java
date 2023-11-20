package com.gms.sales.people.sys.commons.calendar.test;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.gms.sales.people.sys.commons.calendar.SPSCalendar;
import com.gms.sales.people.sys.commons.calendar.exceptions.SPSCalendarException;

public class SPSCalendarTest {

	private final SPSCalendar spsCalendar = SPSCalendar.getInstance();
	private final String strFormat = "dd-MM-yyyy HH:mm:ss.SSS";
	
	@Test
	public void testFormat() {
		Assertions.assertNull(spsCalendar.format(null, null));
		Assertions.assertNull(spsCalendar.format(null, strFormat));
		Assertions.assertNotNull(spsCalendar.format(new Date(), strFormat));
		Assertions.assertThrows(SPSCalendarException.class, () -> spsCalendar.format(new Date(), null));
		Assertions.assertThrows(SPSCalendarException.class, () -> spsCalendar.format(new Date(), ""));
		Assertions.assertThrows(SPSCalendarException.class, () -> spsCalendar.format(new Date(), " "));
	}
	
	@Test
	public void testParse() {
		
		var strDate = "25-12-2023 23:59:59.999";
		
		Assertions.assertNull(spsCalendar.parse(null, null));
		Assertions.assertNull(spsCalendar.parse(null, strFormat));
		Assertions.assertNotNull(spsCalendar.parse(strDate, strFormat));
		Assertions.assertThrows(SPSCalendarException.class, () -> spsCalendar.parse(strDate, null));
		Assertions.assertThrows(SPSCalendarException.class, () -> spsCalendar.parse(strDate, ""));
		Assertions.assertThrows(SPSCalendarException.class, () -> spsCalendar.parse(strDate, " "));
	}

}
