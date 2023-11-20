package com.gms.sales.people.sys.commons.person.model;

import com.gms.sales.people.sys.commons.internationalization.SPSMessage;

public class ValidateDocumentId extends ValidatePersonStrategy {

	private final SPSMessage spsMessage = SPSMessage.getInstance();

	@Override
	protected void execute(Person person) {
		if(person.getDocumentId() == null) {
			throw new IllegalArgumentException(spsMessage.toMessage("person.validation.documentId.null"));
		}else if(! person.getDocumentId().validate()){
			throw new IllegalArgumentException(spsMessage.toMessage("person.validation.documentId.invalid", person.getDocumentId().getDocumentType()));
		}
		
		
		var document = person.getDocumentId();
		if(!document.getDocumentType().isValid(person.getPersonType())) {
			throw new IllegalArgumentException(spsMessage.toMessage("person.validation.documentId.notpermitted", person.getDocumentId().getDocumentType(), person.getPersonType()));
		}
		
		
	}

}
