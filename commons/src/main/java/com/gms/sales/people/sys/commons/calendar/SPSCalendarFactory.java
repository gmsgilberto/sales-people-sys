package com.gms.sales.people.sys.commons.calendar;

import lombok.Getter;

class SPSCalendarFactory {
	
	@Getter
	private static final SPSCalendarFactory instance = new SPSCalendarFactory(); 

	public SPSCalendar build() {
		return new SPSCalendar();
	}

}
