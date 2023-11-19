package com.gms.sales.people.sys.commons.person.exceptions;

import com.gms.sales.people.sys.commons.exceptions.SPSException;

public class PersonTypeNotFoundException extends SPSException {


	private static final long serialVersionUID = 1L;

	public PersonTypeNotFoundException(String code) {
		super("person.type.notfound", code);
	}

}
