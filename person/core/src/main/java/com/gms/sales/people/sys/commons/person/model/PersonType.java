package com.gms.sales.people.sys.commons.person.model;

import com.gms.sales.people.sys.commons.internationalization.SPSMessage;
import com.gms.sales.people.sys.commons.person.exceptions.PersonTypeNotFoundException;

import lombok.Getter;

@Getter
public enum PersonType{

	NATURAL_PERSON("PF","person.type.natural"),
	LEGAL_PERSON("PJ","person.type.legal");
	
	private final String code;
	private final String name;
	
	PersonType(String code, String label){
		this.code = code;
		this.name = SPSMessage.getInstance().toMessage(label);
	}
	
	public static PersonType get(String code) {
		
		for(PersonType type: values()) {
			if(type.code.equalsIgnoreCase(code)) {
				return type;
			}
		}
		
		throw new PersonTypeNotFoundException(code);
	}
	
}
