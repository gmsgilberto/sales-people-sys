package com.gms.sales.people.sys.commons.person.model;

import com.gms.sales.people.sys.commons.internationalization.SPSMessage;
import com.gms.sales.people.sys.commons.person.exceptions.StatusNotFoundException;

import lombok.Getter;

@Getter
public enum StatusOfPerson {

	DRAFT("DRAFT","person.status.draft"),
	BLOCKED("BLOCKED","person.status.blocked");
	
	private final String code;
	private final String name;
	
	StatusOfPerson(String code, String label){
		this.code = code;
		this.name = SPSMessage.getInstance().toMessage(label);
	}
	
	public static StatusOfPerson get(String code) {
		
		for(StatusOfPerson type: values()) {
			if(type.code.equalsIgnoreCase(code)) {
				return type;
			}
		}
		
		throw new StatusNotFoundException(code);
	}
	
}
