package com.gms.sales.people.sys.commons.person.exceptions;

import com.gms.sales.people.sys.commons.exceptions.SPSException;

public class StatusNotFoundException extends SPSException {


	private static final long serialVersionUID = 1L;

	public StatusNotFoundException(String code) {
		super("person.status.notfound", code);
	}

}
