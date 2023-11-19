package com.gms.sales.people.sys.commons.calendar.exceptions;

import com.gms.sales.people.sys.commons.exceptions.SPSException;

public class SPSCalendarException extends SPSException {

	private static final long serialVersionUID = 1L;

	public SPSCalendarException(Throwable cause, String label, Object... args) {
		super(cause, label, args);
	}
	
	public SPSCalendarException(String label, Object... args) {
		super(label, args);
	}
	

}
