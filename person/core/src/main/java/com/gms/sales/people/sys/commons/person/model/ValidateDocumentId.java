package com.gms.sales.people.sys.commons.person.model;

import com.gms.sales.people.sys.commons.internationalization.SPSMessage;

public class ValidateDocumentId extends ValidatePersonStrategy {

	private final SPSMessage spsMessage = SPSMessage.getInstance();

	@Override
	protected void execute(Person person) {
		
		var documentId = person.getDocumentId();
		
		if(documentId == null) {
			throw new IllegalArgumentException(spsMessage.toMessage("person.validation.documentId.null"));
		}else if(! documentId.validate()){
			throw new IllegalArgumentException(spsMessage.toMessage("person.validation.documentId.invalid", documentId.getDocumentType()));
		}
		
		
		var document = documentId;
		if(!document.getDocumentType().isValid(person.getPersonType())) {
			throw new IllegalArgumentException(spsMessage.toMessage("person.validation.documentId.notpermitted", documentId.getDocumentType(), person.getPersonType()));
		}
		
		
	}

}
