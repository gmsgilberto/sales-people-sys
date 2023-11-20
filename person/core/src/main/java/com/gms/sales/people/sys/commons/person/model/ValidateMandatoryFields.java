package com.gms.sales.people.sys.commons.person.model;

import com.gms.sales.people.sys.commons.internationalization.SPSMessage;
import com.gms.sales.people.sys.commons.text.TextUtil;

public class ValidateMandatoryFields extends ValidateStrategy {

	private final SPSMessage spsMessage = SPSMessage.getInstance();

	@Override
	protected void execute(Person person) {
		
		var message = new StringBuilder();

		if(TextUtil.isBlank(person.getFirstName())) {
			message.append(spsMessage.toMessage("person.validation.firstname.null")).append("\n");
		}
		
		if(TextUtil.isBlank(person.getLastName())) {
			message.append(spsMessage.toMessage("person.validation.lastName.null")).append("\n");
		}
		
		if(person.getStatus() == null) {
			message.append(spsMessage.toMessage("person.validation.status.null")).append("\n");
		}
		
		if(person.getPersonType() == null) {
			message.append(spsMessage.toMessage("person.validation.personType.null")).append("\n");
		}
		
		if(person.getDocumentId() == null) {
			message.append(spsMessage.toMessage("person.validation.documentId.null")).append("\n");
		}
		
		if(!message.isEmpty()) {
			throw new IllegalArgumentException(message.toString());
		}
		
		
		
		
	}

}
