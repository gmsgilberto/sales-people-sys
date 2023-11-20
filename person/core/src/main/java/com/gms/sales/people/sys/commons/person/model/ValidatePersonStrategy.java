package com.gms.sales.people.sys.commons.person.model;

import java.util.Arrays;
import java.util.List;

abstract class ValidatePersonStrategy {

	private static final List<ValidatePersonStrategy> validations;
	
	static{
		validations = Arrays.asList(
							new ValidateMandatoryFields(),
							new ValidateDocumentId()
						);
		
	}
	
	public static void validate(Person person) {
		
		var listErros = new StringBuilder();
		
		for(ValidatePersonStrategy validation : validations) {
			try {
				validation.execute(person);
			}catch (Exception e) {
				listErros.append(e.getMessage()).append("\n");
			}
		}
		
		if(!listErros.isEmpty()) {
			throw new InvalidaPersonFieldsException(listErros.toString());
		}
		
	}
	
	
	protected abstract void execute(Person person);

}
