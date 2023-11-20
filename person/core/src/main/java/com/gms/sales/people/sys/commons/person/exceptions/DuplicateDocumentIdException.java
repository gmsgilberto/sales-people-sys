package com.gms.sales.people.sys.commons.person.exceptions;

import com.gms.sales.people.sys.commons.exceptions.SPSException;
import com.gms.sales.people.sys.commons.person.model.DocumentId;

public class DuplicateDocumentIdException extends SPSException {

	private static final long serialVersionUID = 1L;
	
	public DuplicateDocumentIdException(DocumentId documentId) {
		super("person.exceptions.duplicate.documentid", documentId.getDocumentType(), documentId.getDocumentId());
	}

	

}
