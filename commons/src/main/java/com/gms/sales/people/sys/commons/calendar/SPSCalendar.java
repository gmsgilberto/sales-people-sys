package com.gms.sales.people.sys.commons.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.logging.Logger;

import com.gms.sales.people.sys.commons.calendar.exceptions.SPSCalendarException;

import lombok.Getter;


public final class SPSCalendar {
	
	private static final Logger logger = Logger.getLogger("SPSCalendar");
	
	@Getter
	private static final SPSCalendar instance = SPSCalendarFactory.getInstance().build();
	private Map<String, DateFormat> cache = new Hashtable<String, DateFormat>();
	
	SPSCalendar(){
		super();
		logger.info("Inicializada....");
	}
	
	
	public synchronized final String format(Date date, String strDateFormat) {
		
		try {
			return date == null ? null : initDateFormat(strDateFormat).format(date);
		}catch (Exception e) {
			throw new SPSCalendarException(e, "calendar.date.parse.exception", date, strDateFormat);
		}

	}
	

	public synchronized final Date parse(String date, String strDateFormat) {
		try {
			
			return date == null  || date.isBlank() ? null : initDateFormat(strDateFormat).parse(date);
			
		}catch (Exception e) {
			throw new SPSCalendarException(e, "calendar.date.parse.exception", date, strDateFormat);
		}
	}


	private synchronized DateFormat initDateFormat(String strDateFormat) {
		
		if(strDateFormat == null || strDateFormat.isBlank()) {
			throw new SPSCalendarException("calendar.date.strformat.null");
		}
		
		strDateFormat = strDateFormat.trim();
		
		var dateFormat = this.cache.get(strDateFormat);
		if(dateFormat == null) {
			dateFormat = new SimpleDateFormat(strDateFormat);
			this.cache.put(strDateFormat, dateFormat);
			logger.info("Adiciona novo formato de data ao cache: " + strDateFormat);
		}
		return dateFormat;
	}
	
	
}
