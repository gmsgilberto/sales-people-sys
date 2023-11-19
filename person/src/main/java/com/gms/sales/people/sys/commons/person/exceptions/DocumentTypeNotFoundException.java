package com.gms.sales.people.sys.commons.person.exceptions;

import com.gms.sales.people.sys.commons.exceptions.SPSException;

public class DocumentTypeNotFoundException extends SPSException {


	private static final long serialVersionUID = 1L;

	public DocumentTypeNotFoundException(String code) {
		super("person.type.notfound", code);
	}

}
